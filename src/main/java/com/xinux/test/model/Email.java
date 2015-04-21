package com.xinux.test.model;

import java.util.List;

import org.springframework.core.io.AbstractResource;

public class Email {
    //发件人
    private String                from;
    //收件人
    private String[]              to;
    //主题
    private String                subject;
    //邮件内容
    private String                text;
    //附件
    public List<AbstractResource> resources;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AbstractResource> getResources() {
        return resources;
    }

    public void setResources(List<AbstractResource> resources) {
        this.resources = resources;
    }

}
