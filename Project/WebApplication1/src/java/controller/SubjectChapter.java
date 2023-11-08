/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ChapterDAO;
import dal.SubjectDAL;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Chapter;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class SubjectChapter extends HttpServlet {

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
            out.println("<title>Servlet SubjectChapter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectChapter at " + request.getContextPath() + "</h1>");
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
        String idStr = request.getParameter("id");
        String pageStr = request.getParameter("page");
        int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
        int recordsPerPage = 5;
        try {
            int id = Integer.parseInt(idStr);
            ChapterDAO cd = new ChapterDAO();
            ArrayList<Chapter> listChapter = cd.getChapterBySubjectID(id, (page - 1) * recordsPerPage, recordsPerPage);
            int noOfRecords = cd.getNoOfRecords(id);
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("subjectID", id);
            request.setAttribute("listChap", listChapter);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/SubjectChapter.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/error.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SubjectChapter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            try {
                SubjectDAL sd = new SubjectDAL();
                String SubjectIdStr = request.getParameter("subjectID");
                String orderStr = request.getParameter("order");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String statusSTR = request.getParameter("status");
                if (name == null || SubjectIdStr == null || orderStr == null || description == null || statusSTR == null) {
                    response.getWriter().write("Các trường không được để trống");
                    return;
                }
                int status;
                if (statusSTR.equals("active")) {
                    status = 1;
                } else {
                    status = 0;
                }
                int SubjectId = Integer.parseInt(SubjectIdStr);
                int order = Integer.parseInt(orderStr);
                Subject s = sd.getSubjectByID(SubjectId);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("account");
                Chapter c = new Chapter();
                c.setChapterName(name);
                c.setCreatedAt(timestamp);
                c.setCreatedBy(a);
                c.setDisplayOrder(order);
                c.setSubject(s);
                c.setDescription(description);
                c.setStatus(status);
                ChapterDAO cd = new ChapterDAO();
                boolean isAdded = cd.addNewChapter(c);
                if (!isAdded) {
                    response.getWriter().write("Thêm mới không thành công");
                } else {
                    response.getWriter().write("true");
                }
            } catch (NumberFormatException e) {
                response.getWriter().write("Nhập sai định dạng các trường");
            } catch (Exception e) {
                System.out.println("SubjectChapterServletAdd:" + e);
                response.getWriter().write("Có lỗi xảy ra trong quá trình thêm mới");
            }
        } else if ("edit".equals(action)) {
            try {
                String idStr = request.getParameter("id");
                String orderStr = request.getParameter("order");

                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String statusSTR = request.getParameter("status");
                if (idStr == null || name == null || orderStr == null || description == null || statusSTR == null) {
                    response.getWriter().write("Các trường không được để trống");
                    return;
                }
                int id = Integer.parseInt(idStr);
                int order = Integer.parseInt(orderStr);
                int status;
                if (statusSTR.equals("active")) {
                    status = 1;
                } else {
                    status = 0;
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("account");
                Chapter c = new Chapter();
                c.setChapterID(id);
                c.setChapterName(name);
                c.setDescription(description);
                c.setDisplayOrder(order);
                c.setUpdatedBy(a);
                c.setUpdatedAt(timestamp);
                c.setStatus(status);

                ChapterDAO cd = new ChapterDAO();
                boolean isUpdated = cd.updateChapterByID(c);
                if (!isUpdated) {
                    response.getWriter().write("Cập nhật không thành công");
                } else {
                    response.getWriter().write("true");
                }
                //response.getWriter().write("true");
            } catch (NumberFormatException e) {
                response.getWriter().write("Nhập sai định dạng các trường");
            } catch (Exception e) {
                System.out.println("SubjectChapterServletUpdate:" + e);
                response.getWriter().write("Có lỗi xảy ra trong quá trình cập nhật");
            }
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
