<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Update Form</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #0F1035;
            color: white;
        }
        .form-card {
            background-color: #11235a55;
            border: 1px solid rgba(0,0,0,.125);
            border-radius: .25rem;
        }
        .home-button {
            background-color: #80ed99; /* Green color */
            color: white;
            border: none;
            border-radius: .25rem;
            padding: 10px 20px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row justify-content-center align-items-center vh-100">
        <div class="col-lg-4">
            <div class="card form-card">
                <div class="card-body">
                    <h5 class="card-title">Update Task ID No : <%=Integer.valueOf(request.getParameter("id")) %></h5>
                    <form action="updatetask?id=<%=Integer.valueOf(request.getParameter("id")) %>" method="post" class="needs-validation" novalidate>
                        <div class="form-group">
                            <label for="id">ID:</label>
                            <input type="text" class="form-control" name="id" id="id" value="<%=Integer.valueOf(request.getParameter("id")) %>" disabled="disabled">
                            <div class="invalid-feedback">Please enter the name.</div>
                        </div>
                        
                       <div class="form-group">
                            <label for="name"> Task Name:</label>
                            <input type="text" class="form-control" name="name" id="name" required>
                            <div class="invalid-feedback">Please enter the Task name.</div>
                        </div>
                        <div class="form-group">
                            <label for="start">Task Start Date:</label>
                            <input type="date" class="form-control" name="start" id="start" required>
                            <div class="invalid-feedback">Please enter the Task Strat Date.</div>
                        </div>
                        <div class="form-group">
                            <label for="end">Task End Date:</label>
                            <input type="date" class="form-control" name="end" id="end" required>
                            <div class="invalid-feedback">Please enter the Task End Date.</div>
                        </div>
                   
                        <div class="text-center"> <!-- Center-aligned buttons -->
                            <button type="submit" class="btn btn-primary" onclick="return confirm('Are you sure you want to Update this Task?')">Update</button>
                            <button type="reset" class="btn btn-secondary">Reset</button>
                            <a href="index.html" class="btn btn-success btn-go-back">Home</a> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Add Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
