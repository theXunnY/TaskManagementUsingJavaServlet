<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Saved Successfully</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #0F1035;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
        }
        .alert {
            background-color: #11235a55;
            color: white;
            border-color: #11235a55;
        }
        .btn {
            color: white;
        }
        .btn-green {
            background-color: green;
            border-color: green;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Task Saved Successfully!</h4>
            <p>The Task record has been saved successfully.</p>
            <hr>
            <button class="btn btn-primary" onclick="location.href='allTask.jsp';">List of Tasks</button>
            <button class="btn btn-primary" onclick="location.href='task.html';">Add Task</button>
            <button class="btn btn-green" onclick="location.href='index.html';">Home</button>
        </div>
    </div>
    <!-- Bootstrap JS (optional) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
