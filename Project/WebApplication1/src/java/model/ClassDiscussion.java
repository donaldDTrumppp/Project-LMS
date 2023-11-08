/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author acer
 */
public class ClassDiscussion {
    private int discussionID;
    private Account account;
    private model.Class cls;
    private String discussionTopic;
    private String discussionContent;
    private Timestamp discussionDate;
    private boolean status;
    private int noVote;
    private Date d;
    private String dS;
    private int noCom;

    public ClassDiscussion() {
    }

    public ClassDiscussion(int discussionID, Account account, Class cls, String discussionTopic, String discussionContent, Timestamp discussionDate, boolean status, int noVote) {
        this.discussionID = discussionID;
        this.account = account;
        this.cls = cls;
        this.discussionTopic = discussionTopic;
        this.discussionContent = discussionContent;
        this.discussionDate = discussionDate;
        this.status = status;
        this.noVote = noVote;
    }

    public int getDiscussionID() {
        return discussionID;
    }

    public void setDiscussionID(int discussionID) {
        this.discussionID = discussionID;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getdS() {
        return dS;
    }

    public void setdS(String dS) {
        this.dS = dS;
    }
    
    

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public String getDiscussionTopic() {
        return discussionTopic;
    }

    public void setDiscussionTopic(String discussionTopic) {
        this.discussionTopic = discussionTopic;
    }

    public String getDiscussionContent() {
        return discussionContent;
    }

    public void setDiscussionContent(String discussionContent) {
        this.discussionContent = discussionContent;
    }

    public Timestamp getDiscussionDate() {
        return discussionDate;
    }

    public void setDiscussionDate(Timestamp discussionDate) {
        this.discussionDate = discussionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNoVote() {
        return noVote;
    }

    public void setNoVote(int noVote) {
        this.noVote = noVote;
    }

    public int getNoCom() {
        return noCom;
    }

    public void setNoCom(int noCom) {
        this.noCom = noCom;
    }
    
    
}
