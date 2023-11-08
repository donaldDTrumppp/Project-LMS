<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                display: flex;
                flex-direction: column;
            }
            #navbar-container {
                width: 20%;
                z-index: 2;
            }
            #menu {
                width: 100%;
                z-index: 1;
            }
            #content-container {
                width: 80%;
                margin-left: 15%;
                margin-top: 50px;
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
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.tab').click(function () {
                    var tabId = $(this).attr('id');
                    var id = '<%=request.getAttribute("id")%>';
                    var url;
                    if (tabId == 'general') {
                        url = '/prj/SubjectGeneral?id=' + id;
                    } else if (tabId == 'chapters') {
                        url = '/prj/SubjectChapter?id=' + id;
                    } else if (tabId == 'dimensions') {
                        url = '/prj/SubjectDimension?id=' + id;
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

        <div id="navbar-container">
            <%@include file = "navbar.jsp" %>
        </div>
        <div id="menu">
            <%@include file = "menu.jsp" %>
        </div>
        <div id="content-container">
            <div id="tabs">
                <button class="tab" id="general">General</button>
                <button class="tab" id="chapters">Chapters</button>
                <button class="tab" id="dimensions">Dimensions</button>
            </div>
            <div id="editArea">
            </div>        
        </div>
        <%@include file = "footer.jsp" %>
    </body>
</html>
