package dal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Chapter;
import model.Question;
import model.Subject;

/**
 *
 * @author quany
 */
public class QuesDAL extends DBContext {

    public ArrayList<Question> getAll() {
        AccountDAL ad = new AccountDAL();
        ChapterDAO chapterDAO = new ChapterDAO();
        SubjectDAL subjectDAL = new SubjectDAL();
        try {
            String sql = "SELECT * FROM swp_prj.question;";
            ArrayList<Question> list;
            try ( PreparedStatement ps = DBContext().prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Question question = new Question();
                    question.setQuesID(rs.getInt("question_id"));

                    Subject s;
                    s = subjectDAL.getSubjectByID(rs.getInt("subject_id"));
                    question.setSubject(s);

                    Chapter c;
                    c = chapterDAO.getChapterByID(rs.getInt("chapter_id"));
                    question.setChapter(c);

                    question.setTopic(rs.getString("topic"));
                    question.setAnswer(rs.getString("answer"));
                    question.setDisplayOrder(rs.getInt("display_order"));
                    question.setCreatedBy(ad.getAccountByAccID(rs.getInt("created_by")));
                    question.setCreatedAt(rs.getTimestamp("created_at"));
                    question.setUpdatedBy(ad.getAccountByAccID(rs.getInt("updated_by")));
                    question.setUpdatedAt(rs.getTimestamp("updated_at"));
                    question.setStatus(rs.getInt("status"));
                    list.add(question);
                }
                rs.close();
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void add(int status, int displayOrder, String topic, int createdBy, int chapter, String answer, int subject, Timestamp createdAt) {
        try {
            String sql = "INSERT INTO question (status, display_order, topic, created_by, chapter_id, answer, subject_code, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = DBContext().prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, displayOrder);
            ps.setString(3, topic);
            ps.setInt(4, createdBy);
            ps.setInt(5, chapter);
            ps.setString(6, answer);
            ps.setInt(7, subject);
            ps.setTimestamp(8, createdAt);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int quesID) {
        try {
            String sql = "DELETE FROM `swp_prj`.`question` WHERE question_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quesID);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Question getiddisplay(int quesID) {
        AccountDAL ad = new AccountDAL();
        ChapterDAO chapterDAO = new ChapterDAO();
        SubjectDAL subjectDAL = new SubjectDAL();
        try {
            String sql = "SELECT * FROM question WHERE question_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quesID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Question question = new Question();
            question.setQuesID(rs.getInt("question_id"));
            Chapter c;
            c = chapterDAO.getChapterByID(rs.getInt("chapter_id"));
            question.setChapter(c);
            Subject s;
            s = subjectDAL.getSubjectByID(rs.getInt("subject_id"));
            question.setSubject(s);

            question.setTopic(rs.getString("topic"));
            question.setAnswer(rs.getString("answer"));
            question.setDisplayOrder(rs.getInt("display_order"));
            question.setCreatedBy(ad.getAccountByAccID(rs.getInt("created_by")));
            question.setCreatedAt(rs.getTimestamp("created_at"));
//            question.setUpdatedBy(ad.getAccountByAccID(rs.getInt("updated_by")));
//            question.setUpdatedAt(rs.getTimestamp("updated_at"));
            question.setStatus(rs.getInt("status"));
            return question;
        } catch (SQLException ex) {
            Logger.getLogger(QuesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Question question) {
        try {
            String sql = "UPDATE question SET topic = ?, answer = ?, display_order = ?, status = ? WHERE question_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, question.getTopic());
            ps.setString(2, question.getAnswer());
            ps.setInt(3, question.getDisplayOrder());
            ps.setInt(4, question.getStatus());
            ps.setInt(5, question.getQuesID());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
