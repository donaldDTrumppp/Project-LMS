<%-- 
    Document   : userMgm
    Created on : Sep 17, 2023, 3:04:41 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Director | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
        <!-- Daterange picker -->
        <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- iCheck for checkboxes and radio inputs -->
        <link href="css/iCheck/all.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }

            .searchArea{
                width: 200px;
                height: 25px;
            }

            .searchArea input{
                width: 100%;
                height: 100%;
            }

            .searchBtn{
                width: 25px;
                border: 1px solid black;
                margin-left: 10px;
                height: 25px;
                cursor: pointer;
            }



            .search{
                margin-bottom: 20px;
                display: flex;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background: #299be4;
                color: #fff;
                padding: 16px 30px;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn {
                color: #566787;
                float: right;
                font-size: 13px;
                background: #fff;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn:hover, .table-title .btn:focus {
                color: #566787;
                background: #f2f2f2;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.settings {
                color: #2196F3;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .status {
                font-size: 30px;
                margin: 2px 2px 0 0;
                display: inline-block;
                vertical-align: middle;
                line-height: 10px;
            }
            .text-success {
                color: #10c469;
            }
            .text-info {
                color: #62c9e8;
            }
            .text-warning {
                color: #FFC107;
            }
            .text-danger {
                color: #ff5b5b;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                background-color: black;
                color: white;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background-color: black;
                color: white;
            }
            .pagination li.active a:hover {
                background-color: black;
                color: white;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }

            .a{
                width: 15px;
                height: 15px;
                margin-right: 3px;
                background-color: black;
            }

            .searchArea{
                width: 200px;
                height: 25px;
                margin-left: 10px;
            }
            .sj{
                margin-left: 20px;
            }

            .searchArea input{
                width: 100%;
                height: 100%;
            }

            .searchText{

            }

            .searchBtn{
                width: 25px;
                border: 1px solid black;
                margin-left: 10px;
                height: 25px;
                cursor: pointer;
            }
            .searchText{
                text-align: left;
            }
            form{
                text-align: left;
            }

            .search{
                margin-top: 20px;
                margin-bottom: 20px;
                display: flex;
                font-size: 20px;
                justify-content: flex-start;
                margin-left: 28px;
                margin-right: 0px;
            }

            .filterArea{
                display: flex;
                margin-bottom: 20px;
                margin-left: 37%;
                font-size: 20px;
            }

            .filterArea div{
                margin-right: 20px;
            }

            .page-item .active {
                background-color: black;
                color: white;
            }

            .ms{
                font-size: 30px;
                text-align: center;
                margin-top: 20px;
            }

            .sjn{
                font-size: 22px;
                font-weight: bold;
                padding-bottom: 10px;
                cursor: pointer;
            }

            .sjn:hover{
                color: blue;
            }

            .nme{
                font-size: 17px;
                padding-bottom: 4px;
                height: 50px;
            }

            .cn{
                font-size: 17px;
                padding-bottom: 4px;
            }

            .dte{
                font-size: 17px;
                padding-bottom: 4px;
            }

            .course{
                border: 1px solid black;
                margin-right: 100px;
                margin-bottom: 50px;
                padding: 10px;
                width: 400px;
                border-radius: 12px;
            }

            .yc{
                display: flex;
                flex-direction: column;
                font-size: 20px;
            }

            .yc div{
                margin-bottom: 10px;
            }
            .footer-main{
                position:fixed;
                bottom:0;
                left: 50%;
            }
            .blk{
                color: black;
                font-weight: bold;
            }

            .ttle{
                font-size: 30px;
                font-weight: bold;
                text-align: center;
                margin-bottom: 20px;
            }

            .sbm{
                text-align: center;
                width: 100px;
                border-radius: 12px;
                margin-left: 45%;
                margin-top: 20px;
            }

            .linkRoad{
                font-size: 25px;
                margin-bottom: 15px;
            }

            .sbm input{
                width: 100%;
                background-color: red;
                color: white;
                text-align: center;
            }

            .ms{
                margin-top: 20px;
            }

            /*table*/
            table{
                margin-top: 20px;
                margin: 0 auto;
                border-radius: 12px;
                border-spacing: 0px;
            }

            tr{
                border-bottom: 2px solid black;
            }

            td{
                padding: 10px;
            }
            th{
                padding: 10px;
                border-bottom: 2px solid black;
            }

            .th{

            }

            .ttr{
                background-color: crimson;
                color: white;
            }

            tr{
                border-bottom: 2px solid black;
            }



            td{
                border-bottom: 1px solid black;
            }

            td a{
                text-decoration: none;
                color: black;
            }



            .rd{
                color: red;
            }


            .body{
                padding-top: 40px;
                padding-left: 90px;
                padding-right: 110px;
            }

            .msAdd{
                color: red;
                margin-right: 20px;
                margin-left: 45%;
            }

            table{
                margin-bottom: 20px;
            }
            .blk{
                color: black;
                font-weight: bold;

                display: inline-block;
                width: 20%;
            }

            .sort{
                width: 20px;
            }

            th:hover{
                background-color: #d4cccb;
                cursor: pointer;
            }

            .searchArea{
                display: flex;
                flex-direction: row;
                align-items: center;
            }
            .imgS{
                width: 35px;
            }

            .imgS:hover{
                cursor: pointer;
            }

            body{
                font-size: 10px;
            }

            .ms{
                color: red;
            }
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0,0,0,0.5);
            }

            .modal-content {
                background-color: #fff;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 91%;
                max-width: 1000px;
            }

            .modal-content {
                padding: 20px;
            }

            .modal-title {
                margin-bottom: 20px;
            }

            /* Định dạng form */
            .form-group {
                margin-bottom: 20px;
            }

            .form-check {
                margin-bottom: 20px;
            }

            /* Định dạng nút */
            .modal-footer {
                margin-top: 20px;
            }

            .btn-primary {
                margin-right: 10px;
            }

            /* Định dạng lỗi */
            .error {
                color: red;
                font-size: 14px;
                margin-top: 5px;
            }

            #snackbar {
                visibility: hidden;
                min-width: 280px;
                margin-left: -125px;
                background-color: #6bb067;
                color: white;
                text-align: center;
                border-radius: 2px;
                padding: 10px 16px 10px 16px;
                position: fixed;
                z-index: 3;
                right: 30px;
                font-size: 20px;
                font-weight: 400;
            }

            #snackbar.show {
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {
                    right: 0;
                    opacity: 0;
                }
                to {
                    right: 30px;
                    opacity: 1;
                }
            }

            @keyframes fadein {
                from {
                    right: 0;
                    opacity: 0;
                }
                to {
                    right: 30px;
                    opacity: 1;
                }
            }

            @-webkit-keyframes fadeout {
                from {
                    right: 30px;
                    opacity: 1;
                }
                to {
                    right: 0;
                    opacity: 0;
                }
            }

            @keyframes fadeout {
                from {
                    right: 30px;
                    opacity: 1;
                }
                to {
                    right: 0;
                    opacity: 0;
                }
            }
        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
          <![endif]-->

        <style type="text/css">

        </style>

    </head>
    <body class="skin-black">
        <%@include file="menu.jsp" %>
        <%@include file="navbarSubjectManager.jsp" %>

        <aside class="left-side sidebar-offcanvas">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="img/26115.jpg" class="img-circle" alt="User Image" />
                    </div>
                    <div class="pull-left info">
                        <p>Hello, ${sessionScope.account.fullName}</p>

                        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                </div>
                <!-- search form -->

                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li>
                        <a href="DashboardController">
                            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-list"></i> <span>Subject Setting</span>
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-list"></i> <span>Question List</span>
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-list"></i> <span>Quiz List</span>
                        </a>
                    </li>

                    <li>
                        <a href="exquizls">
                            <i class="fa fa-list"></i> <span>Lesson List</span>
                        </a>
                    </li>
                    <li>
                        <a href="clist?act=list">
                            <i class="fa fa-list"></i> <span>Class List</span>
                        </a>
                    </li>

                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <aside class="right-side">
            <div class="container-xl">
                <form action = "exquizls" id = "form">
                    <div class = "search">
                        <div class = "sj">
                            Subject: <select name = "subject" onchange = "sbmit()">
                                <option value = "0">All</option>
                                <c:forEach items = "${requestScope.subs}" var = "i">
                                    <option value = "${i.getSubjectID()}">
                                        ${i.getSubjectID()}. ${i.getSubjectCode()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class = "sj">
                            Type: <select name = "chapter" onchange = "sbmit()">
                                <option value = "0">All</option>
                                <c:forEach items = "${requestScope.chaps}" var = "i">
                                    <option value = "${i.chapterID}" }>
                                        ${i.chapterName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type ="hidden" id ="page" name ="page" value ="${requestScope.page}"/>
                        <input type ="hidden" id ="sort" name ="sort" value ="${requestScope.sort}"/>
                        <input type ="hidden" id ="order" name ="order" value ="${requestScope.order}"/>
                        <!--                        <div class="sj">
                                                    Status:&nbsp;&nbsp;&nbsp;
                        <c:if test = "${requestScope.s == 1}">
                            <input type ="radio" onclick="sbmit()" name ="status" value ="-1"/> All  &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" checked="" name ="status" value ="1"/> Active &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" name ="status" value ="0"/> Inactive &nbsp;&nbsp;&nbsp;

                        </c:if>
                        <c:if test = "${requestScope.s == 0}">
                            <input type ="radio" onclick="sbmit()" name ="status" value ="-1"/> All &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" name ="status" value ="1"/> Active &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" checked="" name ="status" value ="0"/> Inactive

                        </c:if>
                        <c:if test = "${requestScope.s == -1}">
                            <input type ="radio" onclick="sbmit()" checked name ="status" value ="-1"/> All &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" name ="status" value ="1"/> Active &nbsp;&nbsp;&nbsp;
                            <input type ="radio" onclick="sbmit()" name ="status" value ="0"/> Inactive &nbsp;&nbsp;&nbsp;

                        </c:if>
                    </div>-->
                    </div>

                </form>
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">

                            <div class="row">
                                <div class="col-sm-4">
                                    <h2><b>Extra Quiz List</b></h2>
                                </div>
                                <div class="col-sm-4">
                                    <form action="exquizls" method="post">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search..." name="search" value="${requestScope.search}">
                                            <div class="input-group-btn">
                                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-sm-4">
                                    <!--                                    <button href="adexquiz" class="btn btn-secondary" id="showAddQuizModal">
                                                                            <i class="material-icons">&#xE147;</i> <span>Add New Extra Quiz</span>
                                                                        </button>-->
                                    <button class="btn" type="button" data-toggle="modal" data-target="#NewExtraQuiz"><i class="material-icons">&#xE147;</i></i>Add an Extra Quiz</button>
                                </div>
                            </div>

                        </div>
                        <div class = "yc">
                            <c:if test = "${requestScope.listL == null}">
                                <div class = "ms">
                                    ${requestScope.ms}
                                </div>
                            </c:if>
                            <c:if test = "${requestScope.ls != null}">

                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Quiz Name</th>
                                            <th>Subject</th>
                                            <th>Chapter</th>
                                            <th>Order</th>
                                            <th>Class</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="q" items="${requestScope.ls}">
                                            <tr>
                                                <td>${q.quizID}</td>
                                                <td>${q.quizName}</td>
                                                <td>${q.subject.subjectCode}</td>
                                                <td>${q.chapter.chapterName}</td>
                                                <td>${q.displayOrder}</td>
                                                <td>${q.cls.className}</td>
                                                <td>
                                                    <c:if test="${q.status == true}">
                                                        <span class="status text-success">&bull;</span> Active
                                                    </c:if>
                                                    <c:if test ="${q.status == false}">
                                                        <span class="status text-warning">&bull;</span> Inactive
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                                <div class="clearfix">
                                    <ul class="pagination">
                                        <li class="page-item"><a href ="exquizls&page=${(page - 1) < 1?(1):(page-1)}">Previous</a></li>
                                            <c:forEach begin = "${1}" end = "${totalPage}" var = "i">
                                            <li class="page-item"><a class ="${i == page ? "active":"noActive"}" href ="exquizls&page=${i}&search=${requestScope.search}">${i}</a></li>
                                            </c:forEach>
                                        <li class="page-item"><a href ="exquizls&page=${(page + 1) > totalPage?(1):(page+1)}">Next</a></li>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>  
        </aside>

        <div id="snackbar" style="display: flex">
            <i class="fa-solid fa-circle-check" style="font-size: 50px;float:left;margin-right: 10px;padding:10px 0 10px 0"></i>
            <div>
                <p style="text-align: left;margin-top: 20px">${txt}</p>
            </div>
        </div>
        <%@include file="AddExtraQuiz.jsp" %>

        <div class="footer-main">
            Copyright &copy Director, 2014
        </div>
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>

        <!-- jQuery UI 1.10.3 -->
        <script src="js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>

        <script src="js/plugins/chart.js" type="text/javascript"></script>

        <!-- datepicker
        <script src="js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>-->
        <!-- Bootstrap WYSIHTML5
        <script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>-->
        <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
        <!-- calendar -->
        <script src="js/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>

        <!-- Director App -->
        <script src="js/Director/app.js" type="text/javascript"></script>

        <!-- Director dashboard demo (This is only for demo purposes) -->
        <script src="js/Director/dashboard.js" type="text/javascript"></script>

        <!-- Director for demo purposes -->
        <script type="text/javascript">
                                $('input').on('ifChecked', function (event) {
                                    // var element = $(this).parent().find('input:checkbox:first');
                                    // element.parent().parent().parent().addClass('highlight');
                                    $(this).parents('li').addClass("task-done");
                                    console.log('ok');
                                });
                                $('input').on('ifUnchecked', function (event) {
                                    // var element = $(this).parent().find('input:checkbox:first');
                                    // element.parent().parent().parent().removeClass('highlight');
                                    $(this).parents('li').removeClass("task-done");
                                    console.log('not');
                                });

        </script>
        <script>
            $('#noti-box').slimScroll({
                height: '400px',
                size: '5px',
                BorderRadius: '5px'
            });

            $('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey').iCheck({
                checkboxClass: 'icheckbox_flat-grey',
                radioClass: 'iradio_flat-grey'
            });
        </script>
        <script type="text/javascript">
            $(function () {
                "use strict";
                //BAR CHART
                var data = {
                    labels: ["January", "February", "March", "April", "May", "June", "July"],
                    datasets: [
                        {
                            label: "My First dataset",
                            fillColor: "rgba(220,220,220,0.2)",
                            strokeColor: "rgba(220,220,220,1)",
                            pointColor: "rgba(220,220,220,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [65, 59, 80, 81, 56, 55, 40]
                        },
                        {
                            label: "My Second dataset",
                            fillColor: "rgba(151,187,205,0.2)",
                            strokeColor: "rgba(151,187,205,1)",
                            pointColor: "rgba(151,187,205,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [28, 48, 40, 19, 86, 27, 90]
                        }
                    ]
                };
                new Chart(document.getElementById("linechart").getContext("2d")).Line(data, {
                    responsive: true,
                    maintainAspectRatio: false,
                });

            });
            // Chart.defaults.global.responsive = true;
        </script>   

        <script type = "text/javascript">
            function sbmit() {
                document.getElementById("form").submit();
            }

            function sort(id) {
                var old = document.getElementById("sort").value;
                if (old === id) {
                    if (Number(document.getElementById("order").value) === 1) {
                        document.getElementById("order").value = 0;
                    } else {
                        document.getElementById("order").value = 1;
                    }
                } else {
                    document.getElementById("sort").value = id;
                    document.getElementById("order").value = 1;
                }

                document.getElementById("form").submit();
            }

            function activate(id, act, page, search, chapter, type, status, sort, order) {
                if (Number(act) === 1) {
                    if (confirm("Bạn có muốn vô hiệu hóa lesson với id = " + id + " ?")) {
                        window.location = "llist?act=act&id=" + id + "&page=" + page + "&search=" + search + "&chapter=" + chapter + "&type=" + type + "&status=" + status + "&sort=" + sort + "&order=" + order;
                    }
                } else {
                    if (confirm("Bạn có muốn kích hoạt lesson với id = " + id + " ?")) {
                        window.location = "llist?act=act&id=" + id + "&page=" + page + "&search=" + search + "&chapter=" + chapter + "&type=" + type + "&status=" + status + "&sort=" + sort + "&order=" + order;
                    }
                }
            }
        </script>

        <script>
            function validateForm() {
                let name = $('#nameInput').val();
                let total = $('#totalInput').val();
                let time = $('#timeInput').val();
                let order = $('#orderInput').val();
                let subject = $('select[name="subject"]').val();
                let chapter = $('select[name="chapter"]').val();
                let error = '';
                // Xóa thông báo lỗi hiện tại
                $('.error').html('');
                if (subject === '') {
                    $('#subjectError').html('Please select a subject!');
                    error = 'Subject is required!';
                }
                if (chapter === '') {
                    $('#chapterError').html('Please select a chapter!');
                    error = 'Chapter is required!';
                }
                if (name === '') {
                    $('#nameError').html('Quiz Name is required!');
                    error = 'Quiz Name is required!';
                } else if (name.length > 100) {
                    $('#nameError').html('Quiz Name must be less than or equal to 100 characters!');
                    error = 'Quiz Name is too long!';
                }
                if ($('input[name="type"]:checked').val() === '0' && (total === '' || !$.isNumeric(total) || parseInt(total) > 20)) {
                    $('#totalError').html('Total questions must be digits and greater than 0 and smaller than 20!');
                    error = 'Total questions is invalid!';
                }
                if (time === '' || !$.isNumeric(time) || parseInt(time) > 120) {
                    $('#timeLimitError').html('Time Limit must be digits and greater than 0 and smaller than 120');
                    error = ' Time Limit is invalid!';
                }
                if ($('input[name="type"]:checked').val() === '0' && (total === '' || !$.isNumeric(order) || parseInt(total) > 5)) {
                    $('#totalError').html('Order Invalid!!');
                    error = 'Total questions is invalid!';
                }

                if (error === '') {
                    $('#addQuizForm').submit();
                } else {
                    event.preventDefault();
                }
            }

            const fixedRadio = document.getElementById('fixedQues');
            const randomRadio = document.getElementById('randomQues');
            const totalInput = document.getElementById('totalInput');

            fixedRadio.addEventListener('click', () => {
                totalInput.disabled = true;
                totalInput.value = 0;
                totalInput.focus();
            });
            randomRadio.addEventListener('click', () => {
                totalInput.disabled = false;
            });

            function showToast(txt) {
                if (txt !== "") {
                    var x = document.getElementById("snackbar");
                    x.className = "show";
                    setTimeout(function () {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                }
            }
            ;

        </script>
    </body>
</html>