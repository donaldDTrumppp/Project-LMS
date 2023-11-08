/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ClassDiscussion;
import model.DiscussionComment;
import util.FormatDate;

/**
 *
 * @author acer
 */
public class DiscussionDAL extends DBContext {

    public List<ClassDiscussion> getAllDiscussionByClass(int classID) {
        ClassDAL cd = new ClassDAL();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        List<ClassDiscussion> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM class_discussion \n"
                    + "					JOIN\n"
                    + "                    (SELECT class_discussion.discussion_id, COUNT(discussion_comment.discussion_id) AS noC FROM class_discussion \n"
                    + "					LEFT JOIN discussion_comment \n"
                    + "                    ON class_discussion.discussion_id = discussion_comment.discussion_id\n"
                    + "                    GROUP BY class_discussion.discussion_id)\n"
                    + "                    AS C\n"
                    + "                    ON class_discussion.discussion_id = C.discussion_id"
                    + " WHERE class_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, classID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassDiscussion cds = new ClassDiscussion();
                cds.setAccount(ad.getAccountByAccID(rs.getInt("account_id")));
                cds.setCls(cd.getClassByID(rs.getInt("class_id")));
                cds.setDiscussionContent(rs.getString("discussion_content"));
                cds.setDiscussionDate(rs.getTimestamp("discussion_date"));
                cds.setDiscussionID(rs.getInt("discussion_id"));
                cds.setDiscussionTopic(rs.getString("discussion_topic"));
                cds.setNoVote(rs.getInt("noVote"));
                cds.setStatus(rs.getBoolean("status"));
                cds.setD(rs.getDate("discussion_date"));
                cds.setdS(fd.formatDateSQL(cds.getD()));
                cds.setNoCom(rs.getInt("noC"));
                list.add(cds);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ClassDiscussion getDiscussionByID(int discussionID) {
        ClassDAL cd = new ClassDAL();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        try {
            String sql = "SELECT * FROM class_discussion \n"
                    + "					JOIN\n"
                    + "                    (SELECT class_discussion.discussion_id, COUNT(discussion_comment.discussion_id) AS noC FROM class_discussion \n"
                    + "					LEFT JOIN discussion_comment \n"
                    + "                    ON class_discussion.discussion_id = discussion_comment.discussion_id\n"
                    + "                    GROUP BY class_discussion.discussion_id)\n"
                    + "                    AS C\n"
                    + "                    ON class_discussion.discussion_id = C.discussion_id"
                    + " WHERE class_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, discussionID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassDiscussion cds = new ClassDiscussion();
                cds.setAccount(ad.getAccountByAccID(rs.getInt("account_id")));
                cds.setCls(cd.getClassByID(rs.getInt("class_id")));
                cds.setDiscussionContent(rs.getString("discussion_content"));
                cds.setDiscussionDate(rs.getTimestamp("discussion_date"));
                cds.setDiscussionID(rs.getInt("discussion_id"));
                cds.setDiscussionTopic(rs.getString("discussion_topic"));
                cds.setNoVote(rs.getInt("noVote"));
                cds.setStatus(rs.getBoolean("status"));
                cds.setD(rs.getDate("discussion_date"));
                cds.setdS(fd.formatDateSQL(cds.getD()));
                cds.setNoCom(rs.getInt("noC"));
                return cds;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<DiscussionComment> getAllDiscussionComByDID(int discussionID) {
        List<DiscussionComment> list = new ArrayList<>();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        try {
            String sql = "SELECT * FROM discussion_comment WHERE discussion_id = ?";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, discussionID);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                DiscussionComment dc = new DiscussionComment();
                dc.setAccount(ad.getAccountByAccID(rs.getInt("account_id")));
                dc.setCd(getDiscussionByID(rs.getInt("discussion_id")));
                dc.setComment(rs.getString("comment"));
                dc.setD(rs.getDate("comment_date"));
                dc.setDate(rs.getTimestamp("comment_date"));
                dc.setNoVote(rs.getInt("noVote"));
                dc.setReply(ad.getAccountByAccID(rs.getInt("reply")));
                dc.setdS(fd.formatDateSQL(dc.getD()));
                list.add(dc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ClassDiscussion> getAllDiscussionByClassASearch(int classID, String condition, String order) {
        ClassDAL cd = new ClassDAL();
        AccountDAL ad = new AccountDAL();
        FormatDate fd = new FormatDate();
        List<ClassDiscussion> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM class_discussion \n"
                    + "					JOIN\n"
                    + "                    (SELECT class_discussion.discussion_id, COUNT(discussion_comment.discussion_id) AS noC FROM class_discussion \n"
                    + "					LEFT JOIN discussion_comment \n"
                    + "                    ON class_discussion.discussion_id = discussion_comment.discussion_id\n"
                    + "                    GROUP BY class_discussion.discussion_id)\n"
                    + "                    AS C\n"
                    + "                    ON class_discussion.discussion_id = C.discussion_id"
                    + " WHERE class_id = ?" + condition + order;
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setInt(1, classID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassDiscussion cds = new ClassDiscussion();
                cds.setAccount(ad.getAccountByAccID(rs.getInt("account_id")));
                cds.setCls(cd.getClassByID(rs.getInt("class_id")));
                cds.setDiscussionContent(rs.getString("discussion_content"));
                cds.setDiscussionDate(rs.getTimestamp("discussion_date"));
                cds.setDiscussionID(rs.getInt("discussion_id"));
                cds.setDiscussionTopic(rs.getString("discussion_topic"));
                cds.setNoVote(rs.getInt("noVote"));
                cds.setStatus(rs.getBoolean("status"));
                cds.setD(rs.getDate("discussion_date"));
                cds.setdS(fd.formatDateSQL(cds.getD()));
                cds.setNoCom(rs.getInt("noC"));
                list.add(cds);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Date getSundayByMonday(Date d) {
        try {
            String sql = "SELECT\n"
                    + "  DATE_ADD(?, INTERVAL 6 DAY) AS sunday\n"
                    + "FROM\n"
                    + "  (\n"
                    + "    SELECT\n"
                    + "      ?\n"
                    + "  ) AS t";
            PreparedStatement st = DBContext().prepareStatement(sql);
            st.setDate(1, d);
            st.setDate(2, d);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getDate("sunday");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ClassDiscussion> getCDByPage(List<ClassDiscussion> list, int start, int end) {
        List<ClassDiscussion> list1 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list1.add(list.get(i));
        }
        return list1;
    }
}
