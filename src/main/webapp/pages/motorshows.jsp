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
    <title>Motor Shows.</title>
</head>
<body>
<div align="center">
    <table class="table_price" cellpadding="4" cellspacing="1">

        <caption><h1>Motor Shows</h1></caption>
        <tr>
            <th>Name</th>
            <th>Address</th>
        </tr>
        <c:forEach var="MS" items="${show}">
            <tr>
                <td><c:out value="${MS.name}"/></td>
                <td><c:out value="${MS.address}"/></td>
                <td>
                    <div>
                        <c:url value="/editthisshow" var="edit">
                            <c:param name="MS" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${edit}"/>" id="editlink">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="/deleteshow" var="delete">
                            <c:param name="MS" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${delete}"/>" id="deletelink">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="/mscars" var="mscars">
                            <c:param name="MS" value="${MS.id}"/>
                        </c:url>
                        <a href=" <c:out value="${mscars}"/>" id="mscarslink">Show cars</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/" class="c">Return to main</a>
    <a href="/createshow" class="c">Create Motor Show</a>
    <a href="/createcar" class="c">Create Car</a>
    <a href="/cars" class="c">Return to Cars</a><br>
</div>
</body>
</html>
