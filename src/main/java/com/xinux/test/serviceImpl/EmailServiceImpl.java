package com.xinux.test.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.xinux.test.model.Email;
import com.xinux.test.model.User;
import com.xinux.test.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    //简单的文本邮件发送
    @Autowired
    private MailSender          mailSender;

    //复杂邮件发送类
    @Autowired
    private JavaMailSender      javaMailSender;

    @Autowired
    private VelocityEngine      velocityEngine;

    @Override
    public void send(Email email) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(email.getFrom());
        smm.setSubject(email.getSubject());
        smm.setTo(email.getTo());
        smm.setText(email.getText());
        mailSender.send(smm);
    }

    @Override
    public void sendMime(Email email) throws MessagingException {
        MimeMessage mm = javaMailSender.createMimeMessage();
        //加上编码，解决中文乱码
        MimeMessageHelper helper = new MimeMessageHelper(mm, true, "GB2312");

        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getText(), true);

        //添加附件
        if (email.getResources() != null && email.getResources().size() > 0) {
            for (AbstractResource resource : email.getResources()) {
                helper.addAttachment(resource.getFilename(), resource);
            }
        }

        javaMailSender.send(mm);
    }

    @Override
    public void sendMime(Email email, User user) throws MessagingException {
        MimeMessage mm = javaMailSender.createMimeMessage();
        //加上编码，解决中文乱码
        MimeMessageHelper helper = new MimeMessageHelper(mm, true, "GB2312");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", user);
        model.put("appUrl", getAppUrl());
        String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
            "/mail/welcome.vm", model);
        System.out.println(emailText);
        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(emailText, true);

        //添加附件
        if (email.getResources() != null && email.getResources().size() > 0) {
            for (AbstractResource resource : email.getResources()) {
                helper.addAttachment(resource.getFilename(), resource);
            }
        }

        javaMailSender.send(mm);

    }

    /* @Override
     public void sendWelcomeEmail(Email email, User user) throws MessagingException {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("user", user);
         model.put("appUrl", getAppUrl());
         String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
             "/mail/welcome.vm", model);
         MimeMessage msg = javaMailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(msg);
         helper.setTo(email.getTo());
         helper.setFrom(email.getFrom());
         helper.setSubject("Registration confirm mail");
         helper.setText(emailText, true);

         javaMailSender.send(msg);

     }*/

    /*@Override
    public void sendWelcomeEmail(final Email email, final User user) throws MessagingException {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("user", user);
                model.put("appUrl", getAppUrl());
                String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    "/mail/welcome.vm", model);
                //                MimeMessage msg = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(email.getFrom());
                helper.setTo(email.getTo());
                helper.setSubject("Registration confirm mail");
                helper.setText(emailText, true);
            }
        };

        this.javaMailSender.send(preparator);
        logger.debug("Successfully sent email to [" + user.getEmail() + "]");

    }*/

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private String getAppUrl() {
        return "http://localhost:8080/springDemo/";
    }

    /*@Autowired
    private JavaMailSender      mailSender;
    @Autowired
    private VelocityEngine      velocityEngine;
    @Autowired
    private Environment         environment;

    @Async
    @Override
    public void sendWelcomeEmail(final User user) {
        try {
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    message.setTo(user.getEmail());
                    message.setFrom("webservice@xxx.com"); // could be parameterized...
                    message.setSubject("Xinux.Inc registration. Welcome.");
                    Map<String, Object> model = new HashMap<String, Object>();
                    model.put("user", user);
                    model.put("appUrl", getAppUrl());
                    String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                        "/mail/welcome.vm", model);
                    message.setText(text, true);
                }
            };
            this.mailSender.send(preparator);
            logger.debug("Successfully sent email to [" + user.getEmail() + "]");
        } catch (Exception e) {
            logger.error("Error while sending email: " + e.getLocalizedMessage());
        }
    }

    private String getAppUrl() {
        return environment.getProperty("application.url");
    }*/
}
