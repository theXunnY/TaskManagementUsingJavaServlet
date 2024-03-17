<%@page import="edu.jsp.entity.Task"%>
<%@page import="edu.jsp.entity.Employee"%>
<%@page import="edu.jsp.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Tasks</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #0F1035;
        color: white;
    }
    .form-container {
        background-color: #11235a55;
        padding: 20px;
        border-radius: 10px;
        margin-top: 20px;
    }
    .table th,
    .table td {
        color: white;
        text-align: center;
        font-weight: bold; /* Increased font weight */
    }
    .table-responsive {
        margin-top: 20px;
    }
    .btn-go-back {
        margin-top: 20px;
        display: block;
        width: fit-content;
        margin-left: auto;
        margin-right: auto;
        font-weight: bold;
    }
</style>
</head>
<body>

<div class="container">
    <% Controller controller = new Controller(); %>
    <% if (controller.getAllTasks() != null) { %>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Task ID</th>
                    <th scope="col">Task Name</th>
                    <th scope="col">Task Start Date</th>
                    <th scope="col">Task Deadline</th>
                    <th scope="col">UPDATE TASK</th>
                    <th scope="col">DELETE TASK</th>
					<th scope="col">ASSIGN TASK</th>                    
                </tr>
            </thead>
            <tbody>
                <% for (Task task : controller.getAllTasks()) { %>
                <tr>
                    <td><%= task.getId() %></td>
                    <td><%= task.getName() %></td>
                    <td><%= task.getStartDate() %></td>
                    <td><%= task.getEndDate() %></td>
                    
                    <td><a class="btn btn-primary" href="#">UPDATE</a></td>
                    <td><a class="btn btn-danger" href="tdelete?id=<%=task.getId() %>" >DELETE</a></td>
                    <td><a class="btn btn-primary" href="assignTask?id=<%= task.getId()%>">ASSIGN</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
    <div class="form-container">
        <!-- Your form content goes here -->
    </div>
    <a href="index.html" class="btn btn-secondary btn-go-back">Go Back</a>
</div>

<!-- Add Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>
