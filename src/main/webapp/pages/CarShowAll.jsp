<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="urlCarAdd" value="/car/add"/>
<c:set var="urlMotorShows" value="/motor_show/list"/>
<c:set var="urlCars" value="/car/list"/>
<c:set var="urlMain" value="/main"/>
<c:set var="urlBootstrap" value="/css/bootstrap.min.css"/>
<c:set var="urlStyle" value="/css/style.css"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="${urlBootstrap}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${urlStyle}" rel="stylesheet" type="text/css" media="all"/>
    <title>All cars</title>
</head>
<body class="CarAll">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="bar-left col-lg-10">
            <form class="form-inline" method="get" action="${urlCars}">
                <ul class="nav navbar-nav">
                    <li><a href="${urlMain}">Main page</a></li>
                    <li><a href="${urlCars}">All cars</a></li>
                    <li><a href="${urlMotorShows}">All motor shows</a></li>
                    <li><a href="${urlCarAdd}">Create car</a></li>
                    <li class="menu-bar-page">
                        <button type="submit" <c:if test="${page.toPrev == false}"> disabled="disabled"</c:if>
                                class="btn btn-sm" name="pageNumber" value="${(page.pageNumber)-1}">
                            Previous
                        </button>
                    </li>
                    <li class="menu-bar-count">
                        <label>
                            <input type="text" class="pageCount" disabled="disabled"
                                   value="${page.pageNumber}/${page.pageCount}">
                        </label>
                    </li>
                    <li class="menu-bar">
                        <button type="submit" <c:if test="${page.toNext == false}"> disabled="disabled"</c:if>
                                class="btn btn-sm" name="pageNumber" value="${(page.pageNumber)+1}">Next
                        </button>
                    </li>
                    <li class="menu-bar-beg">
                        <div>
                            <label>
                                <select class="form-control" name="pageSize" size="1">
                                    <option <c:if test="${page.pageSize eq 5}"> selected= "selected"</c:if> value="5">5
                                    </option>
                                    <option <c:if test="${page.pageSize eq 10}"> selected="selected" </c:if> value="10">10
                                    </option>
                                    <option <c:if test="${page.pageSize eq 25}"> selected="selected" </c:if> value="25">25
                                    </option>
                                    <option <c:if test="${page.pageSize eq 35}"> selected="selected" </c:if> value="35">35
                                    </option>
                                </select>
                            </label>
                            <button type="submit" class="btn btn-sm">Apply</button>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
        <div class="search col-lg-2">
            <form class="form-inline" method="get" action="${urlCars}">
                <input type="text" name="searchValue" placeholder="Search" value="${searchValue}">
                <Strong>By</Strong>
                <label>
                    <select name="searchCategory" class="searchSelect">
                        <option value="model">Car model</option>
                        <option value="manufacturer">Car manufacturer</option>
                        <option value="price">Car price</option>
                        <option value="engineVolume">Car engine volume</option>
                        <option value="vinCode">Car VIN code</option>
                    </select>
                </label>
                <button type="submit" class="btn btn-sm">Search</button>
            </form>
        </div>
    </div>
</div>

<div class="m" align="center">
    <table class="table_price" cellpadding="4" cellspacing="1">
        <caption><h1>All cars</h1></caption>
        <tr>
            <th>Model</th>
            <th>Production date</th>
            <th>Manufacturer</th>
            <th>Manufacturer E-mail</th>
            <th>Price</th>
            <th>Engine volume</th>
            <th>VIN code</th>
            <th>Motor Show</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.model}</td>
                <td>${car.productionDate}</td>
                <td>${car.manufacturer}</td>
                <td>${car.manufacturerEmail}</td>
                <td>${car.price} €</td>
                <td>${car.engineVolume}</td>
                <td>${car.vinCode}</td>
                <td>${car.motorShow.name}</td>
                <td>
                    <div>
                        <a href="/car/copy/${car.id}">Copy</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="/car/edit/${car.id}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>

                        <a href="/car/delete/${car.id}/${car.motorShow.id}">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <a href="/motor_show/cars/${car.motorShow.id}">To Motor Show</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty cars && empty searchValue}">
        <div>
            <h2>
                There are no cars in data base. You can <a href="${urlCarAdd}">add it</a>.
            </h2>
        </div>
    </c:if>
    <c:if test="${empty cars && not empty searchValue}">
        <div>
            <h2>
                There are no cars satisfies the search condition: ${searchValue}
            </h2>
        </div>
    </c:if>
</div>
</body>
</html>
