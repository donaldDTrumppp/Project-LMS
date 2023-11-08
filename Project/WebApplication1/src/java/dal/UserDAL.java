/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SystemSetting;

/**
 *
 * @author Acer
 */
public class UserDAL extends DBContext {

    public List<Account> getAllAcounts() {
        List<Account> accounts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            String sql = "select username, full_name, enrolment_date, role, status from account";
            stm = DBContext().prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));;
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setActivate(rs.getInt("status"));
                a.setRole_id(ss);
                a.setFullName(rs.getString("full_name"));
                accounts.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Account> getListByPage(int start, int end, List<Account> list) {
        List<Account> list2 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list2.add(list.get(i));
        }
        return list2;
    }

    public void updateUser(String fullname, String role, boolean status, String mobile, String dob, String gender, String enroldate, String username) {
        try {
            String query = "update  account  \n"
                    + "set full_name = ?,\n"
                    + "role = ?,\n"
                    + "status = ?,\n"
                    + "mobile = ?,\n"
                    + "dob = ?',\n"
                    + "gender = ?,\n"
                    + "enrolment_date = ?\n"
                    + "where username = ?';";
            PreparedStatement stm = DBContext().prepareStatement(query);
            stm.setString(1, fullname);
            stm.setString(2, role);
            stm.setBoolean(3, status);
            stm.setString(4, mobile);
            stm.setString(5, dob);
            stm.setString(6, gender);
            stm.setString(7, enroldate);
            stm.setString(9, username);
        } catch (SQLException e) {

        }
    }

    public Account getAccbyUsername(String username) {
        Account acc = null;
        try {
            String query = "SELECT * FROM account WHERE username = ?";
            PreparedStatement stm = DBContext().prepareStatement(query);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                acc = new Account();
                acc.setUser(rs.getString("username"));
                acc.setPass(rs.getString("password"));
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));
                acc.setRole_id(ss);
                acc.setActivate(rs.getInt("status"));
                acc.setFullName(rs.getString("full_name"));
                acc.setEmail(rs.getString("email"));
                acc.setMobile(rs.getString("mobile"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public List<Account> searchByName(String txtSearch) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stm = null;
        List<Account> list = new ArrayList<>();
        try {
            String sql = "select username, full_name, enrolment_date, role, status from account\n"
                    + "where full_name like ?";
            stm = DBContext().prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setActivate(rs.getInt("status"));
                a.setRole_id(ss);
                a.setFullName(rs.getString("full_name"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalAccount() {
        String query = "select count(*) from account";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = new DBContext().DBContext();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Account> pagingAccount(int index) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT username, full_name, enrolment_date, role, status\n"
                + "FROM account\n"
                + "ORDER BY account_id asc LIMIT 5 OFFSET ?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().DBContext();
            stm = conn.prepareStatement(query);
            stm.setInt(1, (index - 1) * 5);
            rs = stm.executeQuery();
            while (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("role"));
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setActivate(rs.getInt("status"));
                a.setRole_id(ss);
                a.setFullName(rs.getString("full_name"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        UserDAL dao = new UserDAL();
        int count = dao.getTotalAccount();
        System.out.println(count);
        List<Account> a = dao.pagingAccount(2);
        for (Account i : a) {
            System.out.println(i);
        }
    }
}
