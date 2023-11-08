/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GradeItem;

import util.FormatDate;

/**
 *
 * @author acer
 */
public class GradeDAL extends DBContext {

    public List<GradeItem> getAllGradeByStudent(int studentID, int classID) {
        List<GradeItem> list = new ArrayList<>();
        AsmDAL asd = new AsmDAL();
        QuizDAL qd = new QuizDAL();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        
        try {
            String sql = "SELECT * FROM grade_item WHERE student_id = ? AND class_id = ? ORDER BY item_id";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, studentID);
            st.setInt(2, classID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GradeItem gi = new GradeItem();
                gi.setAsm(asd.getAsmByID(rs.getInt("asm_id")));
                gi.setCount(rs.getInt("count"));
                gi.setDateTaken(rs.getTimestamp("date_taken"));
                gi.setItemID(rs.getInt("item_id"));
                gi.setItemName(rs.getString("item_name"));
                gi.setItemType(rs.getString("item_type"));
                gi.setNotes(rs.getString("notes"));
                gi.setQuiz(qd.getQuizByID(rs.getInt("quiz_id")));
                gi.setGrade(rs.getDouble("grade"));
                gi.setStudent(ad.getAccountByAccID(rs.getInt("student_id")));
                gi.setTimeTaken(rs.getDouble("time_taken"));
                gi.setDate(rs.getDate("date_taken"));
                gi.setDateS(fd.formatDateSQL(gi.getDate()));
                list.add(gi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<GradeItem> getAllGradeByStudentASearch(int studentID, int classID, String condition, String o) {
        List<GradeItem> list = new ArrayList<>();
        AsmDAL asd = new AsmDAL();
        QuizDAL qd = new QuizDAL();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        try {
            String sql = "SELECT * FROM grade_item WHERE student_id = ? AND class_id = ?" + condition + o;
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, studentID);
            st.setInt(2, classID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GradeItem gi = new GradeItem();
                gi.setAsm(asd.getAsmByID(rs.getInt("asm_id")));
                gi.setCount(rs.getInt("count"));
                gi.setDateTaken(rs.getTimestamp("date_taken"));
                gi.setItemID(rs.getInt("item_id"));
                gi.setItemName(rs.getString("item_name"));
                gi.setItemType(rs.getString("item_type"));
                gi.setNotes(rs.getString("notes"));
                gi.setQuiz(qd.getQuizByID(rs.getInt("quiz_id")));
                gi.setGrade(rs.getDouble("grade"));
                gi.setStudent(ad.getAccountByAccID(rs.getInt("student_id")));
                gi.setTimeTaken(rs.getDouble("time_taken"));
                gi.setDate(rs.getDate("date_taken"));
                gi.setDateS(fd.formatDateSQL(gi.getDate()));
                list.add(gi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<GradeItem> getGradeByItem(List<GradeItem> list, int start, int end) {
        List<GradeItem> list1 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list1.add(list.get(i));
        }
        return list1;
    }

    public String order(String sort, String order) {
        String o = "";
        switch (sort) {
            case "ID": {
                if(order.equals("0")) {
                    o = " ORDER BY item_id DESC";
                }
                else {
                    o = " ORDER BY item_id ASC";
                }
                break;
            }
            case "Name": {
                if(order.equals("0")) {
                    o = " ORDER BY item_name DESC";
                }
                else {
                    o = " ORDER BY item_name ASC";
                }
                break;
            }
            case "Type": {
                if(order.equals("0")) {
                    o = " ORDER BY item_type DESC";
                }
                else {
                    o = " ORDER BY item_type ASC";
                }
                break;
            }
            case "Taken": {
                if(order.equals("0")) {
                    o = " ORDER BY count DESC";
                }
                else {
                    o = " ORDER BY count ASC";
                }
                break;
            }
            case "Grade": {
                if(order.equals("0")) {
                    o = " ORDER BY grade DESC";
                }
                else {
                    o = " ORDER BY grade ASC";
                }
                break;
            }
            case "Note": {
                if(order.equals("0")) {
                    o = " ORDER BY notes DESC";
                }
                else {
                    o = " ORDER BY notes ASC";
                }
                break;
            }
            case "Time": {
                if(order.equals("0")) {
                    o = " ORDER BY time_taken DESC";
                }
                else {
                    o = " ORDER BY time_taken ASC";
                }
                break;
            }
            case "Date": {
                if(order.equals("0")) {
                    o = " ORDER BY date_taken DESC";
                }
                else {
                    o = " ORDER BY date_taken ASC";
                }
                break;
            }
            default: {
                o = " ORDER BY item_id";
                break;
            }
        }
        return o;
    }
}
