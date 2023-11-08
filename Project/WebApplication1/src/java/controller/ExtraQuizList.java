/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.QuizDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Chapter;
import model.Quiz;
import model.Subject;

/**
 *
 * @author Nguyen Quoc Trumg
 */
public class ExtraQuizList extends HttpServlet {

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
            out.println("<title>Servlet ExtraQuizList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExtraQuizList at " + request.getContextPath() + "</h1>");
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
        List<Quiz> ls = qd.getAllExtraQuiz();
        int defaultPage = 1;
        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = defaultPage;
        }
        int numPerPage = 5;
        int start = (page - 1) * numPerPage;
        int end = Math.min(start + numPerPage, ls.size());
        List<Quiz> pageSettings = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pageSettings.add(ls.get(i));
        }
        int totalPage = (ls.size() % numPerPage == 0) ? (ls.size() / numPerPage) : (ls.size() / numPerPage + 1);
        ArrayList<Chapter> chaps = qd.getAllChapterQuiz();
        ArrayList<Subject> subs = qd.getAllSubject();
        ArrayList<model.Class> clss = qd.getAllClasses();
        request.setAttribute("ls", pageSettings);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("chaps", chaps);
        request.setAttribute("subs", subs);
        request.setAttribute("clss", clss);
        request.getRequestDispatcher("view/ExtraQuizList.jsp").forward(request, response);
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
        QuizDAL qd = new QuizDAL();
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        List<Quiz> quizls = qd.SearchAllExtraQuiz(search);
        int defaultPage = 1;
        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = defaultPage;
        }
        int numPerPage = 5;
        int start = (page - 1) * numPerPage;
        int end = Math.min(start + numPerPage, quizls.size());
        List<Quiz> pageSettings = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pageSettings.add(quizls.get(i));
        }
        int totalPage = (quizls.size() % numPerPage == 0) ? (quizls.size() / numPerPage) : (quizls.size() / numPerPage + 1);
        ArrayList<Chapter> chaps = qd.getAllChapterQuiz();
        ArrayList<Subject> subs = qd.getAllSubject();
        ArrayList<model.Class> clss = qd.getAllClasses();
        request.setAttribute("ls", pageSettings);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("chaps", chaps);
        request.setAttribute("subs", subs);
        request.setAttribute("search", search);
        request.setAttribute("clss", clss);
        request.getRequestDispatcher("view/ExtraQuizList.jsp").forward(request, response);
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
