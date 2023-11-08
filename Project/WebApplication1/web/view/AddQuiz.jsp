<%-- 
    Document   : AddSysSetting
    Created on : Sep 24, 2023, 1:31:27 PM
    Author     : Nguyen Quoc Trumg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Subject Manager | Dashboard</title>
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
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
          <![endif]-->

        <style type="text/css">
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
                border: 2px solid black;
                border-radius: 12px;
                border-spacing: 0px;
            }

            tr{
                border-bottom: 2px solid black;
            }

            td{
                padding: 20px;
            }
            th{
                padding: 20px;
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

            .ms{
                text-align: center;
                color: red;
                margin-right: 20px;
                margin-left: 40%;
            }
            .content {
                padding: 20px; /* Khoảng cách giữa nội dung và khung */
            }

            .yc {
                margin: 0 auto;
                max-width: 600px; /* Điều chỉnh độ rộng của form */
                padding: 20px;
                background-color: #f5f5f5; /* Màu nền */
                border: 1px solid #ddd; /* Đường viền xung quanh form */
                border-radius: 5px;
            }

            .yc > div {
                margin-bottom: 10px;
            }

            .yc label {
                font-weight: bold;
                display: block;
            }

            .yc .input-field {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .yc select.input-field {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                background-color: #fff;
            }

            .yc .radio {
                display: flex;
                justify-content: space-between;
                margin-top: 10px;
            }

            .yc .ms {
                color: #d9534f; /* Màu chữ cho thông báo lỗi */
                font-weight: bold;
            }

            .yc .sbm {
                text-align: right;
            }

            /* CSS for the Submit Button */
            .sbm input[type="submit"] {
                padding: 10px 20px;
                background-color: #428bca;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .sbm input[type="submit"]:hover {
                background-color: #357ebd;
            }

            .footer-main{
                position:fixed;
                bottom:0;
            }
            .question-type {
                display: flex;
                align-items: center;
                gap: 10px; /* Khoảng cách giữa các phần tử con */
            }

        </style>
    </head>
    <body class="skin-black">
        <!-- header logo: style can be found in header.less -->
        <%@include file="menu.jsp" %>
        <%@include file="navbarSubjectManager.jsp" %>

        <aside class="right-side">


            <!-- Main content -->
            <section class="content">
                <div class="linkRoad">
                    <a href = "home">Home </a> / <span><a href = "syssetls">Setting List</a></span> / <span><a href = "addsset">Update Setting</a></span>
                </div>
                <div class="ttle">
                    Add New Quiz
                </div>
                <form action="addquiz" method="post">
                    <div class="yc">
                        <div>
                            <label class="blk">Quiz Name:</label>
                            <input type="text" name="quizName" class="input-field"/>
                        </div>
                        <div>
                            <label class="blk">Subject:</label>
                            <select name="subject" class="input-field">
                                <c:forEach var="i" items="${requestScope.subs}">
                                    <option value="${i.subjectID}">${i.subjectName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label class="blk">Chapter:</label>
                            <select name="chapter" class="input-field">
                                <c:forEach var="c" items="${requestScope.chaps}"> 
                                    <option value="${c.chapterID}">${c.chapterName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label class="blk">Question Type:</label>
                            <div>
                                <input type="radio" name="questionType" value="random" id="randomOption" class="input-field" />
                                <label for="randomOption">Random Question</label>
                            </div>
                            <div>
                                <input type="radio" name="questionType" value="fixed" id="fixedOption" class="input-field" />
                                <label for="fixedOption">Fixed Question</label>
                            </div>
                            <label class="blk">NoQ:</label>
                            <input type="text" name="noQ" class="input-field"/>
                        </div>
                        <div>
                            <label class="blk">Time Limit:</label>
                            <input type="text" name="timeLimit" class="input-field"/>
                        </div>
                        <div style="display: flex; align-items: center;">
                            <label class="blk" style="margin-right: 80px;">Status:</label>
                            <div style="display: flex; align-items: center;">
                                <input type="radio" name="status" value="1" class="input-field" style="margin-right: 5px;"> Activate
                                <input type="radio" checked name="status" value="0" class="input-field" style="margin-left: 50px;"> Deactivate
                            </div>
                        </div>

                        <div class="ms">
                            ${requestScope.ms}
                        </div>
                        <c:if test="${requestScope.ls != null}">
                            <table>
                                <tr>
                                    <th class="first">Setting Name</th>
                                    <th>Setting Type</th>
                                    <th>Status</th>
                                    <th class="last">Action</th>
                                </tr>
                                <c:forEach items="${requestScope.ls}" var="setting">
                                    <tr>
                                        <td>${setting.setting_name}</td>
                                        <td>${setting.setting_type}</td>
                                        <td>${setting.setting_status}</td>
                                        <td>Action Buttons</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <div class="sbm">
                            <input type="submit" value="Add"/>
                        </div>
                    </div>

                </form>

                <!-- row end -->
            </section><!-- /.content -->

        </aside><!-- /.right-side -->
    </div><!-- ./wrapper -->
    <%@include file="footer.jsp" %>


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
    <script type ="text/javascript">
        function ttle(subjectID, classID) {
            window.location = "course?id=" + subjectID + "&class=" + classID;
        }
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
</body>
</html>
