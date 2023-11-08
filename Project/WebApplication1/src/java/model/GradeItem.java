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
public class GradeItem {
    private int itemID;
    private String itemName;
    private Account student;
    private String itemType;
    private model.Class cls;
    private int count;
    private double grade;
    private String notes;
    private Timestamp dateTaken;
    private double timeTaken;
    private Quiz quiz;
    private Assignment asm;
    private Date date;
    private String dateS;

    public GradeItem() {
    }

    public GradeItem(int itemID, String itemName, Account student, String itemType, int count, double grade, String notes, Timestamp dateTaken, double timeTaken, Quiz quiz, Assignment asm) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.student = student;
        this.itemType = itemType;
        this.count = count;
        this.grade = grade;
        this.notes = notes;
        this.dateTaken = dateTaken;
        this.timeTaken = timeTaken;
        this.quiz = quiz;
        this.asm = asm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateS() {
        return dateS;
    }

    public void setDateS(String dateS) {
        this.dateS = dateS;
    }
    
    

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Account getStudent() {
        return student;
    }

    public void setStudent(Account student) {
        this.student = student;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Timestamp dateTaken) {
        this.dateTaken = dateTaken;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Assignment getAsm() {
        return asm;
    }

    public void setAsm(Assignment asm) {
        this.asm = asm;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }
    
    
}
