package com.nkpdqz.webfluxdemo.pojo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class User {

    @NotNull(message = "用户id不能为空")
    private Long id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 6,max = 15,message = "账号长度要在6-15个字符")
    private String username;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6,max = 15,message = "密码长度要在6-15个字符")
    private String password;

    @NotNull(message = "Email不能为空")
    @javax.validation.constraints.Email(message = "邮箱格式不正确")
    private String Email;

    public User() {
    }

    public User(@NotNull(message = "用户id不能为空") Long id, @NotNull(message = "用户名不能为空") @Size(min = 6, max = 15, message = "账号长度要在6-15个字符") String username, @NotNull(message = "用户密码不能为空") @Size(min = 6, max = 15, message = "密码长度要在6-15个字符") String password, @NotNull(message = "Email不能为空") @javax.validation.constraints.Email(message = "邮箱格式不正确") String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
