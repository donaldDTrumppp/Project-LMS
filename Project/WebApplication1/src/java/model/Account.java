/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class Account {

    private int ID;
    private String user;
    private String pass;
    private int activate;
    private SystemSetting role_id;
    private String fullName;
    private String email;
    private String mobile;

    public Account(String user, String pass, int activate) {
        this.user = user;
        this.pass = pass;
        this.activate = activate;
    }

    public Account(String username, String passowrd, SystemSetting role_id, int status, String fullname, String email, String mobile) {
        this.user = username;
        this.pass = passowrd;
        this.role_id = role_id;
        this.activate = status;
        this.fullName = fullname;
        this.email = email;
        this.mobile = mobile;
    }

    public Account(String user, String pass, int activate, SystemSetting role_id) {
        this.user = user;
        this.pass = pass;
        this.activate = activate;
        this.role_id = role_id;
    }

    public Account(String user, String email, String pass, int activate, SystemSetting role_id, String fullName, String mobile) {
        this.user = user;
        this.pass = pass;
        this.activate = activate;
        this.role_id = role_id;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
    }

    public Account(String username, String password, String email, String mobile, String fullname, SystemSetting role_id, int status) {
        this.user = username;
        this.pass = password;
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullname;
        this.role_id = role_id;
        this.activate = status;
    }

    public Account(String user, int activate, SystemSetting role_id, String fullName) {
        this.user = user;
        this.activate = activate;
        this.role_id = role_id;
        this.fullName = fullName;
    }

    public Account() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public enum Gender {
        Male,
        Female,
        Other
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getActivate() {
        return activate;
    }

    public void setActivate(int activate) {
        this.activate = activate;
    }

    public SystemSetting getRole_id() {
        return role_id;
    }

    public void setRole_id(SystemSetting role_id) {
        this.role_id = role_id;
    }

}
