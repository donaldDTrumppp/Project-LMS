/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.GradeDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.GradeItem;
import util.Paging;
import util.ValidInput;

/**
 *
 * @author acer
 */
public class ClassGrade extends HttpServlet {

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
            out.println("<title>Servlet ClassGrade</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassGrade at " + request.getContextPath() + "</h1>");
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
    private String search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String t = request.getParameter("type");
        String key = request.getParameter("search");
        String condition = "";
        if (t == null || t.equals("0") || t.equals("")) {
            if (t != null && t.equals("0")) {
                request.setAttribute("t", t);
            }
            condition += " AND 1 = 1";
        } else {
            request.setAttribute("t", t);
            condition += " AND item_type = '" + t + "'";
        }
        if (key == null) {
            condition += " AND 1 = 1";
        } else {
            request.setAttribute("key", key);
            condition += " AND item_name LIKE '%" + key + "%'";
        }
        return condition;
    }

    private String order(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GradeDAL gd = new GradeDAL();
        String order = "";
        if (request.getParameter("sort") == null || request.getParameter("order") == null) {
            order += " ORDER BY item_id";
        }
        else {
            request.setAttribute("sort", request.getParameter("sort"));
            request.setAttribute("order", request.getParameter("order"));
            order = gd.order(request.getParameter("sort"), request.getParameter("order"));
        }
        return order;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        ValidInput vi = new ValidInput();

        GradeDAL gd = new GradeDAL();
        if (a != null) {

            Paging p = new Paging();
            String page_raw = request.getParameter("page"), class_raw = request.getParameter("class");
            int page = 1, cls = 0;
            if (page_raw != null) {
                page = vi.validInt(page_raw, request, response);
            }
            if(class_raw != null) {
                cls = vi.validInt(class_raw, request, response);
            }  
            String t = request.getParameter("type");
            String key = request.getParameter("search");
            String condition = search(request, response);
            String order = order(request, response);
            List<GradeItem> list = gd.getAllGradeByStudentASearch(a.getID(), cls, condition, order);
            int numPerPage = 5;
            List<String> type = new ArrayList<>();
            type.add("Quiz");
            type.add("Assignment");
            if (!list.isEmpty()) {

                int start = p.getStart(page, list.size(), numPerPage);
                int end = p.getEnd(page, list.size(), numPerPage);
                int totalPage = p.getTotalPage(page, list.size(), numPerPage);

                request.setAttribute("start", start);
                request.setAttribute("end", end);
                request.setAttribute("size", gd.getGradeByItem(list, start, end).size());
                request.setAttribute("totalEntity", list.size());
                request.setAttribute("list", gd.getGradeByItem(list, start, end));
                request.setAttribute("page", page);
                request.setAttribute("totalPage", totalPage);
            } else {
                request.setAttribute("ms", "Dont have any graded item");
            }
            request.setAttribute("cls", cls);
            request.setAttribute("type", type);
            request.getRequestDispatcher("view/ClassGrade.jsp").forward(request, response);
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
        processRequest(request, response);
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
