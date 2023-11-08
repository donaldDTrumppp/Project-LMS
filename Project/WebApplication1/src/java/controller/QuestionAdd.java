/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ChapterDAO;
import dal.QuesDAL;
import dal.SubjectDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Chapter;
import model.Question;
import model.Subject;

/**
 *
 * @author quany
 */
public class QuestionAdd extends HttpServlet {

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
            out.println("<title>Servlet QuestionAdd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionAdd at " + request.getContextPath() + "</h1>");
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

        request.getRequestDispatcher("view/QuestionAdd.jsp").forward(request, response);
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
        try {
            int status = Integer.parseInt(request.getParameter("status"));
            int displayOrder = Integer.parseInt(request.getParameter("displayOrder"));

            String chapterString = request.getParameter("chapter");
            int chapterId = Integer.parseInt(chapterString);
            System.out.println(chapterId);
            ChapterDAO chapterDAO = new ChapterDAO();
            Chapter chapter = chapterDAO.getChapterByID(chapterId);

            String subjectString = request.getParameter("subject");
            int subjectID = Integer.parseInt(subjectString);
            System.out.println(subjectID);
            SubjectDAL subjectDAL = new SubjectDAL();
            Subject subject = subjectDAL.getSubjectByID(subjectID);

            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            System.out.println(account);
            String topic = request.getParameter("topic");
            String answer = request.getParameter("answer");

            String createdAtString = request.getParameter("createdAt");
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm");
            Date parsedDate = dateFormat.parse(createdAtString);
            Timestamp createdAt = new Timestamp(parsedDate.getTime());

            Question question = new Question(displayOrder, status, topic, answer, account, createdAt, chapter, subject);

            System.out.println("Question add" + question);

            QuesDAL quesDAL = new QuesDAL();
            quesDAL.add(status, displayOrder, topic, account.getID(), chapter.getChapterID(), answer, subject.getSubjectID(), createdAt);

            session.setAttribute("msg", "ADD SUCCESSFULLY !");

            response.sendRedirect("QuestionList");
        } catch (ParseException ex) {
            Logger.getLogger(QuestionAdd.class.getName()).log(Level.SEVERE, null, ex);
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
