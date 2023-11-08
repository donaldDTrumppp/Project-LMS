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
public class DiscussionComment {
    private ClassDiscussion cd;
    private Account account;
    private String comment;
    private Account reply;
    private Timestamp date;
    private int noVote;
    private Date d;
    private String dS;

    public DiscussionComment() {
    }

    public DiscussionComment(ClassDiscussion cd, Account account, String comment, Account reply, Timestamp date, int noVote) {
        this.cd = cd;
        this.account = account;
        this.comment = comment;
        this.reply = reply;
        this.date = date;
        this.noVote = noVote;
    }
    
    

    public ClassDiscussion getCd() {
        return cd;
    }

    public void setCd(ClassDiscussion cd) {
        this.cd = cd;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getReply() {
        return reply;
    }

    public void setReply(Account reply) {
        this.reply = reply;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getNoVote() {
        return noVote;
    }

    public void setNoVote(int noVote) {
        this.noVote = noVote;
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
    
    
}
