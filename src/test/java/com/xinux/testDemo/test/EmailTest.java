package com.xinux.testDemo.test;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinux.test.model.Email;
import com.xinux.test.model.User;
import com.xinux.test.service.EmailService;

public class EmailTest {

    public EmailService emailService;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
                "classpath:config/spring.xml", "classpath:config/spring-mybatis.xml" });
        emailService = (EmailService) context.getBean("emailService");
    }

    /*@Test
    public void testSendEmail() throws MessagingException {
        Email email = new Email();
        email.setFrom("luckyxu1126@126.com");
        email.setTo(new String[] { "luckyxu1126@126.com", "xuxinpie@gmail.com" });
        email.setSubject("复杂邮件");
        String text = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"></head><body><h1><a href='http://luxh.cnblogs.com'>我的博客</a></h1></body></html>";
        email.setText(text);

        List<AbstractResource> resources = new ArrayList<AbstractResource>();
        //添加附件
        ClassPathResource file1 = new ClassPathResource("/picture/icon.png");
        FileSystemResource file2 = new FileSystemResource("D:\\temp\\pet.txt");
        resources.add(file1);
        resources.add(file2);
        email.setResources(resources);

        emailService.sendMime(email);
    }*/

    @Test
    public void testSendWelcomeEmail() throws MessagingException {
        Email email = new Email();
        User user = new User();
        email.setFrom("luckyxu1126@126.com");
        email.setTo(new String[] { "luckyxu1126@126.com", "xuxinpie@gmail.com" });
        email.setSubject("注册邮件");
        user.setUserName("Xinux");
        emailService.sendMime(email, user);
    }

}
