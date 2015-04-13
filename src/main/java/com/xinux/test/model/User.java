package com.xinux.test.model;

import java.io.Serializable;

/**
 * 用户Model
 * 
 * @author hanlin.xx
 * @version $Id: User.java, v 0.1 2015-4-9 下午2:21:10 hanlin.xx Exp $
 */
public class User implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    public int                id;

    public String             userName;

    public String             password;

    public int                age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ("User: " + userName + " ID: " + id + " Password: " + password + " Age: " + age);
    }
}
