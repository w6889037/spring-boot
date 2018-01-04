package com.boot.email;

/**
 * Created by xianchun.hu on 1/3/2018.
 */
public interface MailService {

    public void sendMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

    public void sendTemplateMail();

    public void sendTemplateMail2();
}
