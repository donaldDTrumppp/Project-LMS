<%-- 
    Document   : SubjectGeneral
    Created on : Oct 14, 2023, 3:40:57 AM
    Author     : ADMIN
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Subject"%>
<!DOCTYPE html>
<html>
    <head>
        <title>General Information</title>
    </head>
    <body>
        <%
            Subject subject = (Subject) request.getAttribute("subject");
        %>
        <form id="generalForm">
            <label for="id">ID:</label>
            <span id="id">${subject.getSubjectID()}</span><br>
            <input type="hidden" name="id" value="${subject.getSubjectID()}">
            <label for="name">Tên:</label><br>
            <input type="text" id="name" name="name" value="${subject.getSubjectName()}"><br>
            <label for="code">Mã môn:</label><br>
            <input type="text" id="code" name="code" value="${subject.getSubjectCode()}"><br>
            <label for="description">Mô tả:</label><br>
            <textarea id="description" name="description">${subject.getSubjectDescription()}</textarea><br>
            <label for="status">Trạng thái:</label><br>
            <input type="radio" id="active" name="status" value=1
                   ${subject.getStatus() == 1 ? 'checked' : ''}> Active<br>
            <input type="radio" id="inactive" name="status" value=0
                   ${subject.getStatus() == 0 ? 'checked' : ''}> Inactive<br>
            <input type="submit" value="Cập nhật">
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $('#generalForm').submit(function (event) {
                event.preventDefault(); // Ngăn chặn hành vi mặc định của form
                $.ajax({
                    type: 'POST',
                    url: '/prj/SubjectGeneral',
                    data: $(this).serialize(), // Lấy dữ liệu từ form
                    success: function (data) {
                        location.reload();
                        alert('Cập nhật thành công!');
                        $('#editArea').html(data); // Cập nhật khu vực chỉnh sửa với HTML được trả về
                    }
                });
            });
        </script>

    </body>
</html>
