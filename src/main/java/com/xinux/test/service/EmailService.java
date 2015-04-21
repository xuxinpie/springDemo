package com.xinux.test.service;

import javax.mail.MessagingException;

import com.xinux.test.model.Email;
import com.xinux.test.model.User;

public interface EmailService {

    /**
     * 发送简单文本文件
     * 
     * @param email
     */
    public void send(Email email);

    /**
     * 发送复杂邮件
     * 
     * @param email
     * @throws MessagingException
     */
    public void sendMime(Email email) throws MessagingException;

    /**
     * 发送注册确认邮件
     * 
     * @param user
     */
    public void sendMime(Email email, User user) throws MessagingException;
}
