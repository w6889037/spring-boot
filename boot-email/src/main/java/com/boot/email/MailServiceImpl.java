package com.boot.email;


import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.StringWriter;
import java.util.*;

/**
 * Created by xianchun.hu on 1/3/2018.
 */
@Service
public class MailServiceImpl implements MailService {

    private final Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngineBean velocityEngine;

    @Autowired
    private VelocityContextBean context;

    @Autowired
    private HttpServletRequest request;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            LOG.info("简单邮件已经发送。");
        } catch (Exception e) {
            LOG.error("发送简单邮件时发生异常！", e);
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            LOG.info("html邮件发送成功");
        } catch (MessagingException e) {
            LOG.error("发送html邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            LOG.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            LOG.error("发送带附件的邮件时发生异常！", e);
        }
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            LOG.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            LOG.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }

    @Override
    public void sendTemplateMail() {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
                message.setTo("ijiaobu@qq.com");
                message.setFrom(new InternetAddress(from));
                message.setSubject("Registration Confirmation");
                Map model = new HashMap<>();
                model.put("currentDate", "2016-03-31");

                try {
                    StringWriter writer = new StringWriter();
                    context.put("toUserName","hahaha");
                    context.put("message","这是vm邮件模板");
                    context.put("fromUserName","hehehe");
                    context.put("time", DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
                    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
                    velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
                    velocityEngine.mergeTemplate("templates/test.vm", "UTF-8", context, writer);
                    String emailMessage = writer.toString();
                    System.out.println(emailMessage);
                    //false表示不按html格式解析
                    message.setText(emailMessage,false);
                } catch (Exception e) {
                }
            }
        };
        try {
            mailSender.send(preparator);
            LOG.info("vm模板邮件已经发送。");
        } catch (MailException e) {
            LOG.error("发送vm模板邮件时发生异常！", e);
        }
    }

    @Override
    public void sendTemplateMail2() {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            List<String> emailList = new ArrayList<>();
            emailList.add("aaa@163.com");
            emailList.add("bbb@163.com");

            //多个收件人
            InternetAddress[] toAddress = new InternetAddress[emailList.size()];
            for (int i = 0; i < emailList.size(); i++) {
                toAddress[i] = new InternetAddress(emailList.get(i));
            }
            helper.setFrom(from);
            helper.setTo(toAddress);
            helper.setSubject("html vm 模板");

            StringBuffer url = request.getRequestURL();
            String baseUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).toString();
            LOG.info(baseUrl);

            context.put("toUserName","hahaha");
            context.put("message","这是vm邮件模板");
            context.put("fromUserName","hehehe");
            context.put("time", DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
            context.put("baseUrl", baseUrl);

            StringWriter writer = new StringWriter();
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            velocityEngine.mergeTemplate("templates/test.vm", "UTF-8", context, writer);
            String emailMessage = writer.toString();
            LOG.info(emailMessage);
            //true表示按照html格式解析
            helper.setText(emailMessage,true);
            mailSender.send(message);
            LOG.info("html template邮件发送成功");
        } catch (MessagingException e) {
            LOG.error("发送html template邮件时发生异常！", e);
        }
    }
}
