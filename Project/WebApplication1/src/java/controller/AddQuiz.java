/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.QuizDAL;
import dal.SubjectDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Chapter;
import model.Lesson;
import model.Quiz;
import model.Subject;

/**
 *
 * @author Nguyen Quoc Trumg
 */
public class AddQuiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddQuiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddQuiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuizDAL qd = new QuizDAL();
        SubjectDAL sd = new SubjectDAL();
        List<Subject> subs = sd.getAllSubject();
        ArrayList<Chapter> chaps = qd.getAllChapterQuiz();
        request.setAttribute("chaps", chaps);
        request.setAttribute("subs", subs);
        request.getRequestDispatcher("view/AddQuiz.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        if (a == null) {
            response.sendRedirect("login");
        } else {
            String quizname = request.getParameter("quizName");
            int chap = Integer.parseInt(request.getParameter("chapter"));
            int sub = Integer.parseInt(request.getParameter("subject"));
            int noQ = Integer.parseInt(request.getParameter("noQ"));
            int time = Integer.parseInt(request.getParameter("timeLimit"));
            int status = Integer.parseInt(request.getParameter("status"));
            long currentTimeMillis = System.currentTimeMillis();
            Date date = new Date(currentTimeMillis);
            Timestamp timestamp = new Timestamp(currentTimeMillis);
            Chapter chapter_id = new Chapter();
            chapter_id.setChapterID(chap);
            Subject subject = new Subject();
            subject.setSubjectID(sub);
            Quiz q = new Quiz();
            QuizDAL qd = new QuizDAL();
            q.setQuizName(quizname);
            q.setChapter(chapter_id);
            q.setSubject(subject);
            q.setNoQ(noQ);
            q.setTimeLimit(time);
            q.setCreatedAt(timestamp);
            q.setCreatedBy(a);
            qd.insertQuiz(q);
            request.getRequestDispatcher("quizls").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
