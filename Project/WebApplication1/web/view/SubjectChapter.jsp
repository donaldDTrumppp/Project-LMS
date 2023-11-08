
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Chapter"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Chapter List</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            th {
                background-color: #4CAF50;
                color: white;
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
                background-color: rgba(0,0,0,0.4);
            }

            .modal-content {
                background-color: #fefefe;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
            }
            .modal-content {
                background-color: #fefefe;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 40%;
            }

            .modal-content form {
                display: flex;
                flex-direction: column;
            }

            .modal-content label {
                margin-top: 10px;
            }

            .modal-content input[type="text"],
            .modal-content input[type="number"] {
                padding: 5px;
                margin-top: 5px;
            }

            .modal-content textarea {
                padding: 5px;
                margin-top: 5px;
                height: 100px;
            }


            .modal-content .radio-group {
                display: flex;
                align-items: center;
            }
            .modal-content input[type="submit"] {
                margin-top: 10px;
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }

            .modal-content input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <h1>Chapter List</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Display Order</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listChap}" var="chapter">
                <tr>
                    <td class="id">${chapter.getChapterID()}</td>
                    <td class="name">${chapter.getChapterName()}</td>
                    <td class="description">${chapter.getDescription()}</td>
                    <td class="order">${chapter.getDisplayOrder()}</td>
                    <td class="status">
                        <c:choose>
                            <c:when test="${chapter.getStatus() == 1}">Active</c:when>
                            <c:otherwise>Inactive</c:otherwise>
                        </c:choose>
                    </td>
                    <td><button id ="editButton" class="editButton" data-id="${chapter.getChapterID()}">Edit</button></td>
                </tr>
            </c:forEach>
            <div class="pagination" style="text-align: center; margin-top: 20px;">
                <a href="SubjectChapter?id=${subjectID}&page=${currentPage - 1}">«</a>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <span class="active">${i}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="SubjectChapter?id=${subjectID}&page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <a href="SubjectChapter?id=${subjectID}&page=${currentPage + 1}">»</a>
            </div>

        </table>
        <button id="addButton">Add chapter</button>

        <!--        <div id="editChapterDialog" title="Edit Chapter" style="display: none;">
                    <form id="editChapterForm">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="subjectID" value="${subjectID}">
                        <label for="id">Id:</label><br>
                        <input type="text" id="id" name="id" readonly><br>
                        <label for="name">Name:</label><br>
                        <input type="text" id="name" name="name"><br>
                        <label for="order">Order:</label><br>
                        <input type="number" id="order" name="order"><br>
                        <label for="description">Description:</label><br>
                        <input type="text" id="description" name="description"><br>
                        <label for="status">Status:</label><br>
                        <input type="radio" id="active" name="status" value="active">
                        <label for="active">Active</label><br>
                        <input type="radio" id="inactive" name="status" value="inactive">
                        <label for="inactive">Inactive</label><br>
                        <input type="submit" value="Submit">
                    </form>
                </div>-->
        <div id="editChapterDialog" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <div title="Edit Chapter">
                    <form id="editChapterForm">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="subjectID" value="${subjectID}">
                        <label for="id">Id:</label><br>
                        <input type="text" id="id" name="id" readonly><br>
                        <label for="name">Name:</label><br>
                        <input type="text" id="name" name="name"><br>
                        <label for="order">Order:</label><br>
                        <input type="number" id="order" name="order"><br>
                        <label for="description">Description:</label><br>
                        <textarea id="description" name="description"></textarea><br>
                        <!--                        <input type="text" id="description" name="description"><br>-->
                        <label for="status">Status:</label><br><!--
                        <input type="radio" id="active" name="status" value="active">
                        <label for="active">Active</label>
                        <input type="radio" id="inactive" name="status" value="inactive">
                        <label for="inactive">Inactive</label><br>-->
                        <div class="radio-group"> <!-- Nhóm các radio button vào cùng một div -->
                            <input type="radio" id="active" name="status" value="active">
                            <label for="active">Active</label>
                            <input type="radio" id="inactive" name="status" value="inactive">
                            <label for="inactive">Inactive</label>
                        </div> 
                        <input type="submit" value="Submit">
                    </form>
                </div>
            </div>
        </div>
        <!--        <div id="addChapterDialog" title="Thêm Chapter mới" style="display: none;">
                    <form id="addChapterForm">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="subjectID" value="${subjectID}">
                        <label for="name">Name:</label><br>
                        <input type="text" id="name" name="name"><br>
                        <label for="order">Order:</label><br>
                        <input type="number" id="order" name="order"><br>
                        <label for="description">Description:</label><br>
                        <input type="text" id="description" name="description"><br>
                        <label for="status">Status:</label><br>
                        <input type="radio" id="active" name="status" value="active">
                        <label for="active">Active</label><br>
                        <input type="radio" id="inactive" name="status" value="inactive">
                        <label for="inactive">Inactive</label><br>
                        <input type="submit" value="Submit">
                    </form>
                </div>-->
        <div id="addChapterDialog" class="modal">
            <div class="modal-content">
                <span class="close">×</span>
                <div title="Thêm Chapter mới">
                    <form id="addChapterForm">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="subjectID" value="${subjectID}">
                        <label for="name">Name:</label><br>
                        <input type="text" id="name" name="name"><br>
                        <label for="order">Order:</label><br>
                        <input type="number" id="order" name="order"><br>
                        <label for="description">Description:</label><br>
                        <input type="text" id="description" name="description"><br>
                        <label for="status">Status:</label><br>
                        <input type="radio" id="active" name="status" value="active">
                        <label for="active">Active</label><br>
                        <input type="radio" id="inactive" name="status" value="inactive">
                        <label for="inactive">Inactive</label><br>
                        <input type="submit" value="Submit">
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

        <script>
            $(document).ready(function () {

//                $("#editChapterDialog, #addChapterDialog").dialog({
//                    autoOpen: false,
//                    modal: true,
//                    buttons: {
//                        "Close": function () {
//                            $(this).dialog("close");
//                        }
//                    }
//                });

                $(document).on('click', '.editButton', function () {
                    var row = $(this).closest("tr");
                    var id = $(this).data("id");
                    var name = row.find(".name").text();
                    var orderText = row.find(".order").text();
                    var description = row.find(".description").text();
                    var status = row.find(".status").text().trim();
                    var order = parseInt(orderText);
                    if (isNaN(order)) {
                        alert("Order phải là một số.");
                        return;
                    }
                    $("#editChapterForm #id").val(id);
                    $("#editChapterForm #name").val(name);
                    $("#editChapterForm #order").val(order);
                    $("#editChapterForm #description").val(description);

                    if (status === "Active") {
                        $("#editChapterForm #active").prop("checked", true);
                    } else if (status === "Inactive") {
                        $("#editChapterForm #inactive").prop("checked", true);
                    }
                    $("#editChapterDialog").css("display", "block");
                });
                $(document).on('click', '.close', function () {
                    $("#editChapterDialog").css("display", "none");
                });
                $(document).on('submit', '#editChapterForm', function (event) {
                    event.preventDefault();
                    var formData = $(this).serialize();
                    $.ajax({
                        type: "POST",
                        url: "/prj/SubjectChapter",
                        data: formData,
                        success: function (response) {
                            if (response == "true" || response == "truetrue") {
                                location.reload();
                                alert("Update successful");
                            } else {
                                alert(response);
                            }
                            $("#editChapterDialog").css("display", "none");
                        },
                        error: function () {
                            alert("Update failed");
                        }
                    });
                });
                $(document).on('click', '#addButton', function () {
                    $("#addChapterForm input[type='text'], #addChapterForm input[type='number']").val("");
                    $("#addChapterForm input[type='radio']").prop("checked", false);
                    $("#addChapterDialog").css("display", "block");
                });
                $(document).on('click', '.close', function () {
                    $("#addChapterDialog").css("display", "none");
                });
                $(document).on('submit', '#addChapterForm', function (event) {
                    event.preventDefault();
                    var formData = $(this).serialize();
                    $.ajax({
                        type: "POST",
                        url: "/prj/SubjectChapter",
                        data: formData,
                        success: function (response) {
                            if (response == "true" || response == "truetrue") {
                                location.reload();
                                alert("Add successful");
                            } else {
                                alert(response);
                            }
                            $("#addChapterDialog").css("display", "none");
                        },
                        error: function () {
                            alert("Add failed");
                        }
                    });
                });
            });
        </script>
    </body>
</html>

