/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ClassDAL;
import dal.DiscussionDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import model.Account;
import model.Week;
import util.FormatDate;
import util.GetAllWeekBetween2Date;
import util.Paging;

/**
 *
 * @author acer
 */
public class ClassDiscussion extends HttpServlet {

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
            out.println("<title>Servlet ClassDiscussion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassDiscussion at " + request.getContextPath() + "</h1>");
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
    protected String order(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String order = "";
        if (request.getParameter("order") == null || request.getParameter("order").equals("")) {
            order = "";
            request.setAttribute("order", 0);
        } else {
            if (request.getParameter("order").equals("0")) {
                order = "";
                request.setAttribute("order", 0);
            } else if (request.getParameter("order").equals("1")) {
                order = " ORDER BY discussion_date DESC";
                request.setAttribute("order", 1);
            } else if (request.getParameter("order").equals("2")) {
                order = " ORDER BY noVote DESC";
                request.setAttribute("order", 2);
            } else {
                order = "";
                request.setAttribute("order", 0);
            }
        }
        return order;
    }

    private String searchByKey(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String condition = "";
        if (request.getParameter("search") == null
                || request.getParameter("search").equals("")) {
            condition = "";
        } else {
            condition = " AND discussion_topic LIKE '%" + request.getParameter("search") + "%'";
            request.setAttribute("key", request.getParameter("search"));
        }
        return condition;
    }
    
    private String searchByWeek(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DiscussionDAL dd = new DiscussionDAL();
        String condition = "";
        if(request.getParameter("w") == null
                || request.getParameter("w").equals("")
                || request.getParameter("w").equals("0")) {
            condition = "";
        }
        else {
            try {
                FormatDate fd = new FormatDate();
                Date d = fd.formatStringToDateSQL(request.getParameter("w"));
                request.setAttribute("d", d);
                Date e = dd.getSundayByMonday(d);
                condition = " AND discussion_date BETWEEN '" + d + "' AND '" + e + "'";
            } catch (Exception e) {
                System.out.println(e);
                condition = "";
            }
        }
        return condition;
    }

    private String searchByFilterQ(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String condition = "";
        if (request.getParameter("q") == null
                || request.getParameter("q").equals("")) {
            condition = "";
            request.setAttribute("q", 0);
        } else {
            if (request.getParameter("q").equals("0")) {
                condition = "";
                request.setAttribute("q", 0);
            } else if (request.getParameter("q").equals("1")) {
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("account");
                if (a != null) {
                    condition = " AND account_id =" + a.getID();
                    request.setAttribute("q", 1);
                }
            } else if (request.getParameter("q").equals("2")) {
                condition += " AND noC = 0";
                request.setAttribute("q", 2);
            } else {
                condition = "";
                request.setAttribute("q", 0);
            }
        }
        return condition;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String class_raw = request.getParameter("class");
        DiscussionDAL dd = new DiscussionDAL();
        ClassDAL cd = new ClassDAL();
        Paging p = new Paging();
        int classID = 0, page = 1;
        try {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (class_raw != null) {
                classID = Integer.parseInt(class_raw);
            }
        } catch (Exception e) {
            System.out.println(e);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
        String condition = "", order = "";
        LocalDate startDate = LocalDate.of(2023, 10, 26);

        // Ngày kết thúc
        LocalDate endDate = LocalDate.of(2023, 11, 25);
      
     
        condition += searchByKey(request, response);
        condition += searchByFilterQ(request, response);
        condition += searchByWeek(request, response);
        order += order(request, response);
        List<model.ClassDiscussion> list = dd.getAllDiscussionByClassASearch(classID, condition, order);
        List<Week> listW = getAllWeekBetweenClassDate(cd.getClassByID(classID).getStartDate(), cd.getClassByID(classID).getEndDate());
        if (!list.isEmpty()) {
            int numPerPage = 5;
            int start = p.getStart(page, list.size(), numPerPage);
            int end = p.getEnd(page, list.size(), numPerPage);
            int totalPage = p.getTotalPage(page, list.size(), numPerPage);
            request.setAttribute("listW", listW);
            request.setAttribute("cls", classID);
            request.setAttribute("start", start);
            request.setAttribute("end", end);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("totalEntity", list.size());
            request.setAttribute("size", dd.getCDByPage(list, start, end).size());
            request.setAttribute("page", page);
            request.setAttribute("list", dd.getCDByPage(list, start, end));
            request.getRequestDispatcher("view/ClassDiscussion.jsp").forward(request, response);
        }
        else {
            request.setAttribute("ms", "Don't have any discussion");
            request.setAttribute("cls", classID);
            request.setAttribute("listW", listW);
            request.getRequestDispatcher("view/ClassDiscussion.jsp").forward(request, response);
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
    
    private List<Week> getAllWeekBetweenClassDate(Date start, Date end) {
        LocalDate s = start.toLocalDate();
        LocalDate e = end.toLocalDate();
   

        GetAllWeekBetween2Date g = new GetAllWeekBetween2Date();
        return g.getAllWeeksBetweenTwoDates(s, e);
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
