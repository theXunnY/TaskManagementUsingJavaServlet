<%@page import="edu.jsp.entity.Employee"%>
<%@page import="edu.jsp.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
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
    <% if (controller.getAllEmployees() != null) { %>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Employee ID</th>
                    <th scope="col">Employee Name</th>
                    <th scope="col">Employee Age</th>
                    <th scope="col">Employee Salary</th>
                    <th scope="col">Date Of Joining</th>
                    <th scope="col">Assign to This Emp</th>
                </tr>
            </thead>
            <tbody>
                <% for (Employee employee : controller.getAllEmployees()) { %>
                <tr>
                    <td><%= employee.getId() %></td>
                    <td><%= employee.getName() %></td>
                    <td><%= employee.getAge() %></td>
                    <td><%= employee.getSalary() %></td>
                    <td><%= employee.getDoJ() %></td>
   					<td><a class="btn btn-primary" href="assigntasktoemp?tid=<%=request.getParameter("tid")%>&eid=<%= employee.getId()%>">ASSIGN</a></td>	   
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
