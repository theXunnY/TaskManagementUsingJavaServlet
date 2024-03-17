<!DOCTYPE html>
<%@page import="edu.jsp.controller.Controller"%>
<%@page import="edu.jsp.entity.Employee"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #0F1035;
            color: white;
            padding-top: 20px; /* Add padding to the top */
        }
        .form-card {
            background-color: #11235a55;
            border: 1px solid rgba(0,0,0,.125);
            border-radius: .25rem;
            margin-bottom: 20px; /* Add margin to the bottom */
        }
        .home-button {
            background-color: #80ed99; /* Green color */
            color: white;
            border: none;
            border-radius: .25rem;
            padding: 10px 20px;
            margin-top: 10px;
        }
        /* Sticky form */
        .sticky-form {
            position: sticky;
            top: 20px; /* Adjust top position to leave space for the sticky form */
            width: 100%;
            z-index: 1000; /* Ensure the form is above other content */
            padding: 20px;
        }
        /* Add margin between containers */
        .container {
            margin-top: 20px;
        }
        
        tr td{
        color:white;}
    </style>
</head>
<body>

<!-- Sticky form -->
<div class="sticky-form">
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-lg-4">
                <div class="card form-card">
                    <div class="card-body">
                        <h5 class="card-title">Enter Employee ID To Delete:</h5>
                        <form action="del" method="get" class="needs-validation" novalidate>
                            <div class="form-group">
                                <input type="text" class="form-control" name="id" id="id" placeholder="Enter ID" style="width: 100%;">
                                <div class="invalid-feedback">Please enter the name.</div>
                            </div>
                            <div class="form-group">
                                <a href="index.html" class="btn btn-success btn-home">Home</a> <!-- Home button -->
                                <button type="submit" class="btn btn-primary float-right" onclick="return confirm('Are you sure you want to Delete this employee?')">Delete</button>
                                <button type="reset" class="btn btn-secondary float-right">Reset</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
</div>

<!-- Add Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
