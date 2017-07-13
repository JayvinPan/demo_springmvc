package com.pan.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Pan on 2017/7/13.
 */
public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;

    public User() { }
    public User(String username, String password, String nickname, String email) {
        this.setNickname(nickname);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
    }

    @NotEmpty(message = "用户名不能为空")
    public String getUsername() {
        return username;
    }

    @Size(min = 1,max = 10,message = "密码长度在1和10之间")
    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    @Email(message = "邮箱格式不正确")
    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
