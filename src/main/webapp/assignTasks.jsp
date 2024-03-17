<%@page import="edu.jsp.entity.Task"%>
<%@page import="edu.jsp.entity.Employee"%>
<%@page import="edu.jsp.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assigned Tasks</title>
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

<% Employee employee = (Employee)session.getAttribute("employee"); %>
<div class="container">
    <table class="table">
        <tr>
            <th>Employee ID</th>
            <td><%= employee.getId() %></td>
        </tr>
        <tr>
            <th>Employee Name</th>
            <td><%= employee.getName() %></td>
        </tr>
        <tr>
            <th>Employee Age</th>
            <td><%= employee.getAge() %></td>
        </tr>
        <tr>
            <th>Employee Salary</th>
            <td><%= employee.getSalary() %></td>
        </tr>
        <tr>
            <th>Date of Joining</th>
            <td><%= employee.getDoJ() %></td>
        </tr>

        <tr>
            <th></th>
            <td></td>
        </tr>
    </table>
         
        <div class="container">
    <div class="table-responsive">
        <table class="table table-striped">
            
            <thead class="thead-dark">
            <tr><h3>ASSIGNED TASKS</h3></tr>
                <tr>
                    <th scope="col">Task ID</th>
                    <th scope="col">Task Name</th>
                    <th scope="col">Task Start Date</th>
                    <th scope="col">Task Deadline</th>
                    <th scope="col">DELETE TASK</th>
                                    
                </tr>
            </thead>
            <tbody>
                <% for (Task task : employee.getTasks()){ %>
                <tr>
                    <td><%= task.getId() %></td>
                    <td><%= task.getName() %></td>
                    <td><%= task.getStartDate() %></td>
                    <td><%= task.getEndDate() %></td>
                    
                    <td><a class="btn btn-danger" href="tdelete?id=<%=task.getId() %>" >DELETE</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <div>
        <a href="#" class="btn btn-success">UPDATE</a>
        <a href="#" class="btn btn-danger">DELETE</a>
        <a href="index.html" class="btn btn-primary">Go Back</a>
    </div>
</div>

<!-- Add Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
