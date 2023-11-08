/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Chapter;
import model.GradeItem;
import model.Class;
import model.Quiz;
import model.Subject;

/**
 *
 * @author acer
 */
public class QuizDAL extends DBContext {

    public Quiz getQuizByID(int quiz) {
        SubjectSettingDAL ssd = new SubjectSettingDAL();
        AccountDAL ad = new AccountDAL();
        try {
            String sql = "SELECT * FROM quiz WHERE quiz_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, quiz);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                q.setChapter(ssd.getChapterByID(rs.getInt("chapter_id")));
                q.setCreatedAt((rs.getTimestamp("created_at")));
                q.setCreatedBy(ad.getAccountByAccID(rs.getInt("created_by")));
                q.setUpdatedAt((rs.getTimestamp("updated_at")));
                q.setUpdatedBy(ad.getAccountByAccID(rs.getInt("updated_by")));
                q.setDisplayOrder(rs.getInt("display_order"));
                q.setNoQ(rs.getInt("noQ"));
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                q.setTimeLimit(rs.getDouble("time_limit"));
                q.setDescription(rs.getString("description"));
                return q;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Quiz getQuizByLessonID(int lesson) {
        SubjectSettingDAL ssd = new SubjectSettingDAL();
        AccountDAL ad = new AccountDAL();
        try {
            String sql = "SELECT * FROM quiz WHERE lesson_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, lesson);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                q.setChapter(ssd.getChapterByID(rs.getInt("chapter_id")));
                q.setCreatedAt((rs.getTimestamp("created_at")));
                q.setCreatedBy(ad.getAccountByAccID(rs.getInt("created_by")));
                q.setUpdatedAt((rs.getTimestamp("updated_at")));
                q.setUpdatedBy(ad.getAccountByAccID(rs.getInt("updated_by")));
                q.setDisplayOrder(rs.getInt("display_order"));
                q.setNoQ(rs.getInt("noQ"));
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                q.setTimeLimit(rs.getDouble("time_limit"));
                q.setDescription(rs.getString("description"));
                return q;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<GradeItem> getQuizGradeByAccAQuiz(int accID, int quizID) {
        List<GradeItem> list = new ArrayList<>();
        AccountDAL ad = new AccountDAL();
        AsmDAL asd = new AsmDAL();
        QuizDAL qd = new QuizDAL();
        try {
            String sql = "SELECT * FROM grade_item WHERE student_id = ? AND quiz_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, accID);
            st.setInt(2, quizID);
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
                list.add(gi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Quiz> getAllQuiz() {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT  quiz_id,quiz_name,chapter_id,subject_id,class_id,noQ,time_limit,display_order,full_name,quiz.status\n"
                    + "FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "WHERE class_id IS NULL";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();

                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("chapter_id"));
                q.setChapter(c);
                Subject sub = new Subject();
                sub.setSubjectID(rs.getInt("subject_id"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public ArrayList<Quiz> searchQuizByName(String quiz_name) {
        ArrayList<Quiz> quizls = new ArrayList<>();
        try {
            String sql = "select * from quiz where quiz_name LIKE ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, "%" + quiz_name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("chapter_id"));
                q.setChapter(c);
                Subject sub = new Subject();
                sub.setSubjectID(rs.getInt("subject_id"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                Account updated_by = new Account();
                a.setUser(rs.getString("created_by"));
                updated_by.setUser(rs.getString("updated_at"));
                q.setCreatedBy(a);
                q.setCreatedAt(rs.getTimestamp("created_at"));
                q.setUpdatedBy(updated_by);
                q.setUpdatedAt(rs.getTimestamp("updated_at"));
                q.setStatus(rs.getBoolean("status"));
                quizls.add(q);
            }
        } catch (Exception e) {
        }
        return quizls;
    }

    public void insertQuiz(Quiz q) {
        try {
            String sql = "INSERT INTO quiz\n"
                    + "(quiz_name,\n"
                    + "chapter_id,\n"
                    + "lesson_id,\n"
                    + "noQ,\n"
                    + "time_limit,\n"
                    + "display_order,\n"
                    + "created_by,\n"
                    + "created_at,\n"
                    + "status)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?);";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, q.getQuizName());
            st.setInt(2, q.getChapter().getChapterID());
            st.setInt(3, q.getSubject().getSubjectID());
            st.setInt(4, q.getNoQ());
            st.setDouble(5, q.getTimeLimit());
            st.setInt(6, q.getDisplayOrder());
            st.setInt(7, q.getCreatedBy().getID());
            st.setTimestamp(8, q.getCreatedAt());
            st.setBoolean(9, q.isStatus());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Chapter> getAllChapterQuiz() {
        ArrayList<Chapter> chaps = new ArrayList<>();
        try {
            String sql = "SELECT setting_id,setting_name FROM subject_setting";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("setting_id"));
                c.setChapterName(rs.getString("setting_name"));
                chaps.add(c);
            }
        } catch (Exception e) {
        }
        return chaps;
    }

    public ArrayList<Subject> getAllSubject() {
        ArrayList<Subject> subs = new ArrayList<>();
        try {
            String sql = "Select subject_id,subject_code from subject";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setSubjectID(rs.getInt("subject_id"));
                sub.setSubjectCode(rs.getString("subject_code"));
                subs.add(sub);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subs;
    }

    public ArrayList<Quiz> getAllExtraQuiz() {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT quiz_id,quiz_name,setting_name,subject_code,class.class_name,noQ,time_limit,quiz.display_order,full_name,quiz.status\n"
                    + "FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "JOIN subject on quiz.subject_id = subject.subject_id\n"
                    + "JOIN subject_setting on quiz.chapter_id = subject_setting.setting_id\n"
                    + "JOIN class on quiz.class_id = class.class_id\n"
                    + "WHERE quiz.class_id IS NOT NULL";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterName(rs.getString("setting_name"));
                q.setChapter(c);
                Subject sub = new Subject();
                Class clas = new Class();
                clas.setClassName(rs.getString("class_name"));
                q.setCls(clas);
                sub.setSubjectCode(rs.getString("subject_code"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public ArrayList<Quiz> getAllExtraQuizByClass(int class_id) {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT  quiz_id,quiz_name,chapter_id,subject_id,class_id,noQ,time_limit,display_order,full_name,quiz.status\n"
                    + "FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "WHERE class_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, class_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("chapter_id"));
                q.setChapter(c);
                Subject sub = new Subject();
                Class clas = new Class();
                clas.setClassID(rs.getInt("class_id"));
                q.setCls(clas);
                sub.setSubjectID(rs.getInt("subject_id"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public ArrayList<Quiz> SearchAllExtraQuiz(String search) {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT quiz_id,quiz_name,setting_name,subject_code,class.class_name,noQ,time_limit,quiz.display_order,full_name,quiz.status\n"
                    + "                    FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "                    JOIN subject on quiz.subject_id = subject.subject_id\n"
                    + "                    JOIN subject_setting on quiz.chapter_id = subject_setting.setting_id\n"
                    + "                    JOIN class on quiz.class_id = class.class_id\n"
                    + "                    WHERE quiz.class_id IS NOT NULL AND quiz_name LIKE ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterName(rs.getString("setting_name"));
                q.setChapter(c);
                Subject sub = new Subject();
                Class clas = new Class();
                clas.setClassName(rs.getString("class_name"));
                q.setCls(clas);
                sub.setSubjectCode(rs.getString("subject_code"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public ArrayList<Quiz> GetAllQuizByChap(int chapter_id) {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT  quiz_id,quiz_name,chapter_id,subject_id,class_id,noQ,time_limit,display_order,full_name,quiz.status\n"
                    + "FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "WHERE chapter_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, chapter_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("chapter_id"));
                q.setChapter(c);
                Subject sub = new Subject();
                Class clas = new Class();
                clas.setClassID(rs.getInt("class_id"));
                q.setCls(clas);
                sub.setSubjectID(rs.getInt("subject_id"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public ArrayList<Quiz> getAllQuizBySub(int subject_id) {
        ArrayList<Quiz> quizs = new ArrayList<>();
        try {
            String sql = "SELECT  quiz_id,quiz_name,chapter_id,subject_id,class_id,noQ,time_limit,display_order,full_name,quiz.status\n"
                    + "FROM quiz join account on quiz.created_by = account.account_id\n"
                    + "WHERE subject_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, subject_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                Chapter c = new Chapter();
                c.setChapterID(rs.getInt("chapter_id"));
                q.setChapter(c);
                Subject sub = new Subject();
                Class clas = new Class();
                clas.setClassID(rs.getInt("class_id"));
                q.setCls(clas);
                sub.setSubjectID(rs.getInt("subject_id"));
                q.setSubject(sub);
                q.setNoQ(rs.getInt("noQ"));
                q.setTimeLimit(rs.getInt("time_limit"));
                q.setDisplayOrder(rs.getInt("display_order"));
                Account a = new Account();
                a.setFullName(rs.getString("full_name"));
                q.setCreatedBy(a);
                q.setStatus(rs.getBoolean("status"));
                quizs.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizs;
    }

    public void insertExtraQuiz(Quiz q){
        try {
            String sql = "INSERT INTO quiz\n"
                    + "(quiz_name,\n"
                    + "chapter_id,\n"
                    + "subject_id,\n"
                    + "quiz_type,\n"
                    + "noQ,\n"
                    + "class_id,\n"
                    + "time_limit,\n"
                    + "display_order,\n"
                    + "created_by,\n"
                    + "created_at,\n"
                    + "status)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?,\n"
                    + "?);";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setString(1, q.getQuizName());
            st.setInt(2, q.getChapter().getChapterID());
            st.setInt(3, q.getSubject().getSubjectID());
            st.setString(4, q.getType());
            st.setInt(5, q.getNoQ());
            st.setInt(6, q.getCls().getClassID());
            st.setDouble(7, q.getTimeLimit());
            st.setInt(8, q.getDisplayOrder());
            st.setInt(9, q.getCreatedBy().getID());
            st.setTimestamp(10, q.getCreatedAt());
            st.setBoolean(11, q.isStatus());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Class> getAllClasses() {
        ArrayList<Class> clss = new ArrayList<>();
        try {
            String sql = "SELECT class_id,class_name FROM class";
            PreparedStatement st = DBContext().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setClassID(rs.getInt("class_id"));
                c.setClassName(rs.getString("class_name"));
                clss.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clss;
    }

    public static void main(String[] args) {
        QuizDAL qd = new QuizDAL();
        System.out.println(qd.getAllQuiz());
//        Quiz q = new Quiz();
//        String quizName = "Iteration 6 Quiz";
//        Chapter c = new Chapter();
//        c.setChapterID(1);
//        Subject s = new Subject();
//        s.setSubjectID(1);
//        q.setChapter(c);
//        q.setSubject(s);
//        q.setType(2);
//        q.setNoQ(10);
//        Class cls = new Class();
//        cls.setClassID(1);
//        q.setCls(cls);
//        q.setTimeLimit(90);
//        q.setDisplayOrder(2);
//        Account a = new Account();
//        a.setID(1);
//        q.setCreatedBy(a);
//        long currentTimeMillis = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(currentTimeMillis);
//        q.setCreatedAt(timestamp); // Đặt thời gian sử dụng Timestamp
//        q.setStatus(true);
//        q.setQuizName(quizName);
//        qd.insertExtraQuiz(q);
    }
}
