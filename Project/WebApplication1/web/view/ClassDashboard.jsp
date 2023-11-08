<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <style>
            body {
                display: flex;
                flex-direction: column;
            }

            #menu {
                width: 100%;
                z-index: 1;
            }
            #content-container {
                width: 100%;
                margin-top: 25px;

            }
            body {
                font-family: Arial, sans-serif;
            }
            #tabs {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }
            .tab {
                background-color: #ddd;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
                font-size: 17px;
                width: 20%;
            }

            .tabActive{
                background-color: #aaa;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
                font-size: 17px;
                width: 20%;

            }
            .tab:hover {
                background-color: #bbb;
            }
            .tab.active {
                background-color: #aaa;
            }
            #editArea {
                padding: 6px 12px;
                border: 1px solid #ccc;
                border-top: none;
                margin-left: 0px;
                width: 100%;
                text-align: left;
            }
            #tabs{
                margin-left: 20px;
                margin-right: 20px;
            }

            .footer-main{
                left: 0%;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.tab').click(function () {
                    var tabId = $(this).attr('id');
                    var id = '<%=request.getAttribute("id")%>';
                    var url;
                    if (tabId == 'lp') {
                        url = '/prj/cds?class=' + id;
                    } else if (tabId == 'al') {
                        url = '/prj/cds?class=' + id;

                    } else if (tabId == 'ql') {
                        url = '/prj/cds?class=' + id;
                    } else if (tabId == 'cg') {
                        url = '/prj/cg?class=' + id;
                    } else if (tabId == 'dimension') {
                        url = '/prj/cds?class=' + id;
                    }
                    $('.tab').removeClass('active');
                    $(this).addClass('active');
                    $.ajax({
                        url: url,
                        success: function (data) {
                            $('#editArea').html(data);
                        }
                    });
                });
                //$('#general').click(); // Tab "General" sẽ được chọn mặc định
                $(document).on('click', '.pagination a', function (e) {
                    e.preventDefault();
                    var url = $(this).attr('href');
                    console.log(url);
                    $.ajax({
                        url: url,
                        success: function (data) {
                            $('#editArea').html(data);
                        }
                    });
                });
            });

        </script>
    </head>
    <body>

        <%@include file = "menu.jsp" %>
        <div id="content-container">
            <div id="tabs">
                <button class="tab" id="lp">Learning Page</button>
                <button class="tab" id="al">Assignment List</button>
                <button class="tab" id="ql">Quiz List</button>
                <c:if test = "${requestScope.act != 'cg'}">
                    <button class="tab" id="cg">Class Grade</button>
                </c:if>
                <c:if test = "${requestScope.act == 'cg'}">
                    <button class="tabActive" id="cg">Class Grade</button>
                </c:if>
                <button class="tab" id="dimension">Class Discussion</button>
            </div>
            <div id="editArea">
                <c:if test = "${requestScope.act == 'cg'}">
                    <%@include file = "ClassGrade.jsp" %>
                </c:if>
            </div>        
        </div>
        <%@include file = "footer.jsp" %>
        <div class="footer-main">
            Copyright &copy Director, 2014
        </div>
    </body>
</html>
