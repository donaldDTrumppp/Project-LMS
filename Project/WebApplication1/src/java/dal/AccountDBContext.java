/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.SystemSetting;
import util.Encrypt;

/**
 *
 * @author Nguyen Quoc Trumg
 */
public class AccountDBContext extends DBContext {

    public Account check(String u, String p) {
        SystemSettingDAL ssd = new SystemSettingDAL();
        try {
            String sql = "SELECT * FROM account\n"
                    + " JOIN system_setting ON account.role = setting_id "
                    + "WHERE (email = ? OR mobile = ?) AND password = ? AND status = 1;";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, u); // Sử dụng giá trị u cho cả email và SĐT
            st.setString(3, p);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setActivate(rs.getInt("status"));
                a.setFullName(rs.getString("full_name"));
                a.setEmail(rs.getString("email"));
                a.setMobile(rs.getString("mobile"));
                a.setID(rs.getInt("account_id"));
                a.setRole_id(ssd.getSettingByID(rs.getInt("role")));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account checkByEmail(String email) {
        try {
            String sql = "Select * from account JOIN system_setting on account.role = system_setting.setting_id\n"
                    + "WHERE email = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setID(rs.getInt("account_id"));
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("setting_id"));
                a.setRole_id(ss);
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setActivate(rs.getInt("status"));
                a.setFullName(rs.getString("full_name"));
                a.setEmail(rs.getString("email"));
                a.setMobile(rs.getString("mobile"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertAccount(String username, String email, String pass, int role, int status, String full_name, String mobile) {
        try {
            String sql = "INSERT INTO Account(username,email,password,role,status,full_name,mobile)"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, email);
            st.setString(3, pass);
            st.setInt(4, role);
            st.setInt(5, status);
            st.setString(6, full_name);
            st.setString(7, mobile);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account checkExistAccount(Account a) {
        try {
            String sql = "SELECT * FROM account";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a.setUser(rs.getString("username"));
                a.setEmail(rs.getString("email"));
                a.setPass(rs.getString("password"));
                a.setActivate(rs.getInt("status"));
                a.setID(rs.getInt("role"));
                a.setFullName(rs.getString("full_name"));
                a.setMobile(rs.getString("mobile"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateAccountStatus(String mobile) {
        try {
            String sql = "UPDATE account\n"
                    + "SET\n"
                    + "status = 1\n"
                    + "WHERE mobile = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, mobile);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account checkByPhone(String mobile) {
        try {
            String sql = "SELECT *\n"
                    + "FROM account\n"
                    + "WHERE mobile = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, mobile);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setID(rs.getInt("account_id"));
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setActivate(rs.getInt("status"));
                a.setFullName(rs.getString("full_name"));
                a.setEmail(rs.getString("email"));
                a.setMobile(rs.getString("mobile"));
                a.setMobile(mobile);
                return a;
//                return sql;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDBContext ad = new AccountDBContext();
        String email = "chivqhe176029@fpt.edu.vn";
        System.out.println(ad.checkByEmail(email));
        String phone = "0394672294";
        System.out.println(ad.checkByPhone(phone));
//        System.out.println(p);
//        System.out.println(ss.getSetting_id());

    }
}
