/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.QuesDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.Question;

/**
 *
 * @author quany
 */
public class QuestionUpdate extends HttpServlet {

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
            out.println("<title>Servlet QuestionUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionUpdate at " + request.getContextPath() + "</h1>");
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

        int quesID = Integer.parseInt(request.getParameter("quesID"));
        int displayOrder = Integer.parseInt(request.getParameter("displayOrder"));

        QuesDAL quesDAL = new QuesDAL();
        Question question = quesDAL.getiddisplay(quesID);
        System.out.println(question);
        request.setAttribute("question", question);
        request.getRequestDispatcher("view/QuestionUpdate.jsp").forward(request, response);
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
        int quesID = Integer.parseInt(request.getParameter("quesID"));
        int displayOrder = Integer.parseInt(request.getParameter("displayOrder"));
        int status = Integer.parseInt(request.getParameter("status"));
        System.out.println("displayorder : " + displayOrder);
        String topic = request.getParameter("topic");
        String answer = request.getParameter("answer");

        Question question = new Question(quesID, displayOrder, status, topic, answer);
        System.out.println("update : " + question);
        QuesDAL quesDAL = new QuesDAL();
        quesDAL.update(question);

        HttpSession session = request.getSession();
        session.setAttribute("msg", "UPDATE SUCCESSFULLY !");

        response.sendRedirect("QuestionList");

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
