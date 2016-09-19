<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Car edition</title>
</head>
<body>
<div align="center">
<form method="post" action="/carsave">
    <div>
        <label>Car model:</label>
        <div>
            <input type="text" name="model" value="${car.model}">
        </div>
    </div>

    <div>
        <label>Production date:</label>
        <div>
            <input type="text" name="productionDate" value="${car.productionDate}">
        </div>
        <div>
            YYYY-MM-DD
        </div>
    </div>
    <div>
        <label>Manufacturer:</label>
        <div>
            <input type="text" name="manufacturer" value="${car.manufacturer}">
        </div>
    </div>
    <div>
        <label>Manufacturer E-mail:</label>
        <div>
            <input type="text" name="manufacturerEmail" value="${car.manufacturerEmail}">
        </div>
    </div>
    <div>
        <label>Price:</label>
        <div>
            <input type="text" name="price" value="${car.price}">
        </div>
    </div>

    <div>
        <label>Engine volume:</label>
        <div>
            <input type="text" name="engineVolume" value="${car.engineVolume}">
        </div>
    </div>
    <div>
        <label>VIN code:</label>
        <div>
            <input type="text" name="vinCode" value="${car.vinCode}">
        </div>
    </div>

    <div>
        <input type="hidden" name="id" value="${car.id}">
    </div>
    <div>
        <input type="submit" name="Send">
    </div>
    <div>
        <a href="/" class="c">Return to main</a><br>
        <a href="/motorshows"class="c">Return to MotorShows</a><br>
        <a href="/cars" class="c">Return to Cars</a><br>
    </div>

</form>
</div>
</body>
</html>
