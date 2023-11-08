<%-- 
    Document   : ClassDiscussion
    Created on : Oct 24, 2023, 5:49:20 PM
    Author     : acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            .footer-main{
                left: 0%;
            }

            .ttle{
                font-size: 25px;
                font-weight: bold;
                margin-left: 50px;
                margin-top: 20px;
            }

            .content{
                margin-left: 70px;
                margin-top: 20px;
            }

            .in4{
                display: flex;
                flex-direction: row;
                align-items: flex-start;
                width: 100%;
            }

            .im{
                width: 100%;
                height: 100%;
            }

            .img{
                width: 40px;
                height: 40px;
            }
            .otherIN4{
                margin-left: 10px;
                display: flex;
                flex-direction: column;
                font-size: 18px;
            }

            .topic{
                font-weight: bold;
                margin-bottom: 10px;
                display: flex;
                flex-direction: row;
            }


            .topicN {
                width: 600px;
            }
            .dcontent{
                width:550px;
                text-overflow: ellipsis;
                white-space: nowrap;
                overflow: hidden;
            }

            .in4{
                margin-bottom: 20px;
                padding: 20px;
            }

            .uIN4{
                display: flex;
                flex-direction: row;
            }

            .uname{
                margin-right: 25px;
            }

            .blk{
                font-weight: bold;
            }

            .topicO{
                display: flex;
                flex-direction: row;
                text-align: right;
            }

            .com{
                display: flex;
                flex-direction: row;
                margin-right: 25px;
            }

            .rate{
                display: flex;
                flex-direction: row;
            }

            .oIN4Img{
                width: 25px;
                margin-right: 10px;
            }

            .topicN{
                margin-right: 300px;
            }

            .in4:hover{
                cursor: pointer;
            }

            .clearfix{
                display: flex;
                flex-direction: row;
                align-items: center;
            }

            .pagination{
                margin-left: 1000px;
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
            .page-item .active {
                background-color: black;
                color: white;
            }

            .search{
                margin-top: 20px;
                margin-left: 50px;
                font-size: 18px;
                display: flex;
                flex-direction: column;
            }

            .imgS{
                width: 35px;
                filter: drop-shadow(0px 1000px 0 white);
                transform: translateY(-1000px);
            }

            .searchArea{
                display: flex;
                flex-direction: row;
                align-items: center;
            }
            #search{
                width: 1100px;
                height: 50px;
                padding: 20px;
            }

            .IM{
                border: 1px solid black;
                height: 50px;
                padding: 10px;
                background-color: black;
                color: white;
            }

            .filter{
                display: flex;
                flex-direction: row;
                margin-top: 10px;
            }

            .week{
                display: flex;
                flex-direction: column;
                margin-right: 20px;
            }
            .text{
                font-weight: bold;
            }

            select{
                margin-top: 10px;
                padding: 10px;
            }

            select:hover{
                cursor: pointer;
            }

            .w{
                width: 300px;
            }

            .o{
                width: 450px;
            }

            .q{
                width: 312px;
            }

            .ms{
                color: red;
            }
            .ms{
                margin-top: 20px;
                font-size: 30px;
                text-align: center;
                margin-top: 20px;
                margin-bottom: 20px;
            }
        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body class="skin-black"> 
        <form action = "cds" id = "form">
            <div class = "search">

                <input type ="hidden" name ="class" value ="${requestScope.cls}"/>
                <div class = "searchArea">
                    <div>
                        <input type ="text" name ="search" id = "search" placeholder = "Tìm kiếm tất cả các câu hỏi trong lớp" value = "${requestScope.key}"/>
                    </div>
                    <div class = "IM">
                        <img class ="imgS" src ="img/searchIcon.png" onclick = "sbmit()"/>
                    </div>
                </div>  
                <div class = "filter">
                    <div class = "week">
                        <div class = "text">
                            Tuần:
                        </div>
                        <div class = "fweek">
                            <select name = "w" class = "w" onchange="sbmit()">
                                <option value = "0">Tất cả các tuần</option>
                                <c:forEach var="i" items="${requestScope.listW}" varStatus="loop">
                                    <option ${requestScope.d.toString().equals(i.getStartDate().toString())?"selected":""} value = "${i.getDateS()}">${i.getDateS()} to ${i.getDateE()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class = "week">
                        <div class = "text">
                            Sắp xếp theo:
                        </div>
                        <div class = "forder">
                            <select onchange ="sbmit()" name = "order" class = "o">
                                <option value = "0" ${requestScope.order == 0?"selected":""}>Sắp xếp theo thứ tự đề xuất</option>
                                <option value = "1" ${requestScope.order == 1?"selected":""}>Sắp xếp theo thứ tự gần đây nhất</option>
                                <option value = "2" ${requestScope.order == 2?"selected":""}>Sắp xếp theo thứ tự có nhiều người tán thành nhất</option>
                            </select>
                        </div>
                    </div>
                    <div class = "week">
                        <div class = "text">
                            Câu hỏi:
                        </div>
                        <div class = "fq">
                            <select onchange ="sbmit()" name = "q" class = "q">
                                <option value = "0" ${requestScope.q == 0?"selected":""}>Tất cả các câu hỏi</option>
                                <option value = "1" ${requestScope.q == 1?"selected":""}>Câu hỏi tôi đã hỏi</option>
                                <option value = "2" ${requestScope.q == 2?"selected":""}>Câu hỏi không có câu trả lời</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

        </form>
        <c:if test = "${requestScope.list == null}">
            <div class = "ms">
                ${requestScope.ms}
            </div>
        </c:if>
        <c:if test = "${requestScope.list != null}">
            <div class = "ttle">All questions in this class (${requestScope.totalEntity})</div>
            <div class = "content">
                <c:forEach var="i" items="${requestScope.list}" varStatus="loop">
                    <div class = "in4" onclick = "go(${i.getDiscussionID()})">
                        <div class = "img">
                            <img class ="im" src ="img/userIcon.png" />
                        </div>
                        <div class = "otherIN4">
                            <div class = "topic">
                                <div class = "topicN">
                                    ${i.getDiscussionTopic()}
                                </div>
                                <div class = "topicO">
                                    <div class = "com">
                                        <div class = "cImg">
                                            <img class ="oIN4Img" src ="img/commentIcon.png"/>
                                        </div>
                                        <div class = "cN">
                                            ${i.getNoCom()}
                                        </div>
                                    </div>
                                    <div class = "rate">
                                        <div class = "rImg">
                                            <img class ="oIN4Img" src ="img/voteIcon.png"/>
                                        </div>
                                        <div class = "rN">
                                            ${i.getNoVote()}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class = "dcontent">
                                ${i.getDiscussionContent()}
                            </div>
                            <div class = "uIN4">
                                <c:if test = "${sessionScope.account.getID() == i.getAccount().getID()}">
                                    <div class = "uname">
                                        <span class = "blk">Author:</span> ${i.getAccount().getFullName()} (me)
                                    </div>
                                </c:if>
                                <c:if test = "${sessionScope.account.getID() != i.getAccount().getID()}">
                                    <div class = "uname">
                                        <span class = "blk">Author:</span> ${i.getAccount().getFullName()}
                                    </div>
                                </c:if>
                                <div class = "udate">
                                    <span class = "blk">Date:</span> ${i.getdS()}
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>${requestScope.size}</b> out of <b>${requestScope.totalEntity}</b> entries</div>
                    <ul class="pagination">

                        <li class="page-item"><a href ="cds?page=${(page - 1) < 1?(1):(page-1)}&class=${requestScope.cls}&search=${requestScope.key}&w=${requestScope.d}&order=${requestScope.order}&q=${requestScope.q}">Previous</a></li>
                            <c:forEach begin = "${1}" end = "${totalPage}" var = "i">
                            <li class="page-item"><a class ="${i == page ? "active":"noActive"}" href ="cds?page=${i}&class=${requestScope.cls}&search=${requestScope.key}&w=${requestScope.d}&order=${requestScope.order}&q=${requestScope.q}">${i}</a></li>
                            </c:forEach>
                        <li class="page-item"><a href ="cds?page=${(page + 1) > totalPage?(1):(page+1)}&class=${requestScope.cls}&search=${requestScope.key}&w=${requestScope.d}&order=${requestScope.order}&q=${requestScope.q}">Next</a></li>
                    </ul>
                </div>
            </div>
        </c:if>
        <div class="footer-main">
            Copyright &copy Director, 2014
        </div>        <!-- jQuery 2.0.2 -->
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
            function go(id) {
                window.location = "dd?id=" + id;
            }

            function sbmit() {
                document.getElementById("form").submit();
            }

        </script>
    </body>
</html>
