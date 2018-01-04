package com.boot.email;

import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootEmailApplicationTests {

	@Autowired
	private MailService mailService;

	@Autowired
	private VelocityEngineBean velocityEngine;

	@Test
	public void testSimpleMail() {
		mailService.sendMail("ityouknow@126.com","test simple mail"," hello this is simple mail");
	}

	@Test
	public void testHtmlMail() throws Exception {
		String content="<html>\n" +
				"<body>\n" +
				"    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
				"</body>\n" +
				"</html>";
		mailService.sendHtmlMail("ityouknow@126.com","test html mail",content);
	}

	@Test
	public void sendAttachmentsMail() {
		String filePath="D:\\1.txt";
		mailService.sendAttachmentsMail("ityouknow@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	@Test
	public void sendInlineResourceMail() {
		String rscId = "neo006";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "C:\\Users\\xianchun.hu\\Desktop\\一月story.png";

		mailService.sendInlineResourceMail("ityouknow@126.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

//	@Test
//	public void velocityTest(){
//		Map<String, Object> model = new HashMap<>();
//		model.put("time", DateUtil.formatAsDatetime(new Date()));
//		model.put("message", "这是测试的内容。。。");
//		model.put("toUserName", "张三");
//		model.put("fromUserName", "老许");
//		System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "D:\\work\\my\\springboot\\boot-email\\src\\main\\resources\\templates\\test.vm", "UTF-8", model));
//	}
}
