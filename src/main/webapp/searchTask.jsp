<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search_Employee</title>
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
            margin: 0;
        }
        .main {
            background-color: #11235a55;
            padding: 20px;
            border-radius: 5px;
            width: 50%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .main form {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }
        .main label {
            margin-right: 10px;
        }
        .btn {
            background-color: #3d348b;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-left: 10px;
        }
        .btn:hover {
            background-color: #1a24e6;
        }
        .go-back-btn {
            width: 20%;
            display: flex;
            justify-content: center;
        }
        input[type="number"] {
            width: 80%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div class="main">
        <form action="searchTask" method="get">
            <input type="number" id="find" name="id" placeholder="Enter Task ID">
            <button type="submit" class="btn">Find</button>
        </form>
        <div class="go-back-btn">
            <a href="index.html" class="btn">Go Back</a>
        </div>
    </div>
</body>
</html>
