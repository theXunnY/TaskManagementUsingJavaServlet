<%@page import="edu.jsp.entity.Task"%>
<%@page import="edu.jsp.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Found!!</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>
    body {
        background-color: #0F1035;
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #11235a55;
        padding: 20px;
        border-radius: 10px;
        text-align: center; /* Center-align text */
    }

    /* Set table styles */
    table {
        width: 100%;
        color:white;
    }

    th, td {
        padding: 8px;
        text-align: left;
        color:white;
    }

    th {color:white;
    }
</style>
</head>
<body>

<%Task task= (Task)session.getAttribute("task"); %>
<div class="container">
    <table class="table">
        <tr>
            <th>task ID</th>
            <td><%= task.getId() %></td>
        </tr>
        <tr>
            <th>Task Name</th>
            <td><%= task.getName() %></td>
        </tr>
        <tr>
            <th>Task Start Date</th>
            <td><%= task.getStartDate() %></td>
        </tr>
        <tr>
            <th>Task Deadline</th>
            <td><%= task.getEndDate()%></td>
        </tr>
        <tr>
            <th></th>
            <td></td>
        </tr>
    </table>
    <div>
        <a href="updateTask.jsp?id=<%=task.getId() %>" class="btn btn-success">UPDATE</a>
        <a href="tdelete?id=<%=task.getId() %>" class="btn btn-danger">DELETE</a>
        <a href="index.html" class="btn btn-primary">Go Back</a>
    </div>
</div>

<!-- Add Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
