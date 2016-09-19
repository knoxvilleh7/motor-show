<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .table_price {
        border-collapse: collapse;
        border-left: 3px solid white;
        border-right: 3px solid white;
        border-bottom: 3px solid white;
        font-family: "Lucida Grande", sans-serif;
    }
    .table_price caption {
        background: white;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        padding: 10px;
        color: #000000;
        font-family: "Roboto Slab",serif;
        font-style: normal;
        font-size: 26px;
        text-align: center;
        margin: 0;
    }
    .table_price td, .table_price th {
        padding: 10px;
    }
    .table_price th {
        text-align: left;
        font-size: 18px;
    }
    .table_price tr:nth-child(2n) {
        background: #E5E5E5;
    }
    .table_price td:last-of-type {
        text-align: center;
    }
    .table_price a {
        display: inline-block;
        padding: 5px 10px;
        background: #F79361;
        box-shadow: 2px 2px 0 0 #a22800;
        position: relative;
    }
    .table_price a:hover {
        box-shadow: none;
        top: 2px;
        left: 2px;
    }
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
    <title>All cars</title>
</head>
<body>
<div align="center">
    <table class="table_price" cellpadding="4" cellspacing="1">
        <caption><h1>Cars</h1></caption>
        <tr>
            <th>Model</th>
            <th>Production date</th>
            <th>Manufacturer</th>
            <th>Manufacturer E-mail</th>
            <th>Price</th>
            <th>Engine volume</th>
            <th>VIN code</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td><c:out value="${car.model}"/></td>
                <td><c:out value="${car.productionDate}"/></td>
                <td><c:out value="${car.manufacturer}"/></td>
                <td><c:out value="${car.manufacturerEmail}"/></td>
                <td><c:out value="${car.price}"/></td>
                <td><c:out value="${car.engineVolume}"/></td>
                <td><c:out value="${car.vinCode}"/></td>
                <td>
                    <div>
                        <c:url value="/editthiscar" var="edit">
                            <c:param name="car" value="${car.id}"/>
                        </c:url>
                        <a href=" <c:out value="${edit}"/>" id="editlink">Edit</a>
                    </div>
                </td>
                <td>
                <div>
                    <c:url value="/deletecar" var="delete">
                        <c:param name="car" value="${car.id}"/>
                    </c:url>
                    <a href=" <c:out value="${delete}"/>" id="deletelink">Delete</a>
                </div>
            </td>
                <td>
                    <div>
                        <c:url value="/mscars?MS=${car.motorShowId}" var="mshow">
                            <c:param name="car" value="${car.id}"/>
                        </c:url>
                        <a href=" <c:out value="${mshow}"/>" id="mslink">To Motor Show</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/" class="c">Return to main</a>
</div>
</body>
</html>
