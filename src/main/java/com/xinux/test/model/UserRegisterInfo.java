package com.xinux.test.model;

public class UserRegisterInfo {

    public String userName;

    public String password;

    public String password2;

    public int    age;

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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ("User: " + userName + " Password: " + password + " Password2: " + password2
                + " Age: " + age);
    }

}
