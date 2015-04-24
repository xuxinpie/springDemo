package com.xinux.test.model;

/**
 * User photos(avatars).
 *
 * @author Xinux
 */
public class UserPhoto {
    // surrogate registry identifier
    private int    id;

    private int    userId;
    private byte[] content;
    private String contentType;

    // ------------------------------------------------------------------------
    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
