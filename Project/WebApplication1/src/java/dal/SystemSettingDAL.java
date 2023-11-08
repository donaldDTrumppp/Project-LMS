/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SystemSetting;

/**
 *
 * @author acer
 */
public class SystemSettingDAL extends DBContext {

    public SystemSetting getSettingByID(int id) {
        try {
            String sql = "SELECT * FROM system_setting WHERE setting_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setDisplay_order(rs.getInt("display_order"));
                ss.setSetting_id(rs.getInt("setting_id"));
                ss.setSetting_name(rs.getString("setting_name"));
                ss.setSetting_status(rs.getBoolean("setting_status"));
                ss.setSetting_type(rs.getString("setting_type"));
                return ss;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getIDBySetting(SystemSetting s) {
        try {
            String sql = "SELECT setting_id FROM system_setting WHERE setting_type = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, s.getSetting_type());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("setting_id");
                return id;
            }   
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<String> getAllSemester() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_setting WHERE setting_type = 'Semester'";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("setting_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<SystemSetting> getAllLessonType() {
        List<SystemSetting> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_setting WHERE setting_type = 'Lesson Type'";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("setting_id"));
                ss.setSetting_name(rs.getString("setting_name"));
                ss.setSetting_status(rs.getBoolean("setting_status"));
                ss.setSetting_type(rs.getString("setting_type"));
                ss.setDisplay_order(rs.getInt("display_order"));
                list.add(ss);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
       public boolean checkExistingDimension(String name) {
        try {
            String sql = "SELECT * FROM system_setting WHERE setting_type = 'Dimension Type'";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getString("setting_name").equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("checkExistingDimension:" + e);
        }
        return false;
    }

    public SystemSetting getSettingByName(String name) {
        try {
            String sql = "SELECT * FROM system_setting WHERE LOWER(setting_name) = ? ";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SystemSetting ss = new SystemSetting();
                ss.setSetting_id(rs.getInt("setting_id"));
                ss.setSetting_name(rs.getString("setting_name"));
                ss.setSetting_status(rs.getBoolean("setting_status"));
                ss.setSetting_type(rs.getString("setting_type"));
                return ss;
            }
        } catch (Exception e) {
            System.out.println("getSettingByName:" + e);
        }
        return null;
    }

    public boolean AddNewDimensionSetting(String name) {
        try {
            String sql = "Insert into system_setting (setting_name, setting_type, setting_status) Values (?,'Dimension Type',1);";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, name);
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("AddNewDimensionSetting:" + e);
        }
        return false;
    }

}
