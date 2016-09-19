<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .c {
        border: 1px solid #333;
        display: inline-block;
        padding: 5px 15px;
        text-decoration: none;
        color: #000;
        background-color: #cdecff;
    }
    .c:hover {
        box-shadow: 0 0 5px rgba(0,0,0,0.3);
        background: linear-gradient(to bottom, #fcfff4, #e9e9ce);
        color: #a00;
    }
</style>
<head>
    <title>Create Motor Show</title>
</head>
<body>
<form method="post" action="/mssave">
    <div>
        <label>Show name:</label>
        <div>
            <input type="text" name="name">
        </div>
    </div>

    <div>
        <label>Show address:</label>
        <div>
            <input type="text" name="address">
        </div>
    </div>
    <div>
        <input type="submit" name="Send">
    </div>
    <div>
        <a href="/" class="c">Return to main</a><br>
        <a href="/motorshows" class="c">Return to MotorShows</a><br>
        <a href="/cars" class="c">Return to Cars</a><br>
    </div>

</form>
</body>
</html>
