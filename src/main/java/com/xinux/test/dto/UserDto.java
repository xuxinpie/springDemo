package com.xinux.test.dto;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class UserDto {
    private int           id;

    @NotNull
    @Length(min = 1, max = 40)
    private String        userName;

    @Email
    @Length(min = 1, max = 256)
    private String        email;

    @NotNull
    private int           age;

    @NotEmpty
    @Length(min = 1, max = 256)
    private String        password1;

    @NotEmpty
    @Length(min = 1, max = 256)
    private String        password2;

    private MultipartFile photoFile;
    // photo file url
    private String        photo;

    // ------------------------------------------------------------------------
    // getters and setters
    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonIgnore
    public MultipartFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(MultipartFile photoFile) {
        this.photoFile = photoFile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @JsonIgnore
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return ("User: " + userName + " Password: " + password1 + " Password2: " + password2
                + " Age: " + age + " Photo: " + photo);
    }

}
