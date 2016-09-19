<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pageList" scope="request" class="project.model.Page"/>
<jsp:useBean id="cars" scope="request" type="java.util.List"/>
<c:set var="urlMotorShowList" value="motorshows"/>
<c:set var="urlCarList" value="cars"/>
<c:set var="urlCarEdit" value="caredition"/>
<c:set var="urlCarDelete" value="deletecar"/>
<c:set var="urlMotorShowCars" value="mscars"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <title>All cars</title>

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="responsive-menu">
            <div class="bar-left col-lg-10">
                <form class="form-inline" method="get" action="${urlCarList}">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/">Main page</a></li>
                        <li><a href="${urlMotorShowList}">All motor shows</a></li>
                        <li><a href="${urlCarEdit}">Create car</a></li>
                        <li class="menu-bar-page">
                            <button type="submit" <c:if test="${pageList.toPrev == false}"> disabled="disabled"</c:if>
                                    class="btn btn-sm" name="pageNumber" value="${(pageList.pageNumber)-1}">
                                Previous
                            </button>
                        </li>
                        <li class="menu-bar-count">
                            <label>
                                <input type="text" class="pageCount" disabled="disabled"
                                       value="${pageList.pageNumber}/${pageList.pageCount}">
                            </label>
                        </li>
                        <li class="menu-bar">
                            <button type="submit" <c:if test="${pageList.toNext == false}"> disabled="disabled"</c:if>
                                    class="btn btn-sm" name="pageNumber" value="${(pageList.pageNumber)+1}">Next
                            </button>
                        </li>
                        <li class="menu-bar-beg">
                            <div>
                                <label>
                                    <select class="form-control" name="pageSize" size="1">
                                        <option <c:if test="${pageList.pageSize eq 5}"> selected="selected" </c:if> value="5">5
                                        </option>
                                        <option <c:if test="${pageList.pageSize eq 10}"> selected="selected" </c:if> value="10">10
                                        </option>
                                        <option <c:if test="${pageList.pageSize eq 25}"> selected="selected" </c:if> value="25">25
                                        </option>
                                        <option <c:if test="${pageList.pageSize eq 35}"> selected="selected" </c:if> value="35">35
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
                <form class="form-inline" method="get" action="${urlCarList}">
                    <input type="text" name="search" placeholder="Search" value="">
                    <Strong>By</Strong>
                    <label>
                        <select name="searchBy" class="select">
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
</div>

<div class="zlp1" align="center">
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
                <td>${car.model}</td>
                <td>${car.productionDate}</td>
                <td>${car.manufacturer}</td>
                <td>${car.manufacturerEmail}</td>
                <td>${car.price}</td>
                <td>${car.engineVolume}</td>
                <td>${car.vinCode}</td>
                <td>
                    <div>
                        <c:url value="${urlCarEdit}" var="edit">
                            <c:param name="car" value="${car.id}"/>
                            <c:param name="motorShowId" value="${car.motorShowId}"/>
                        </c:url>
                        <a href="${edit}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="${urlCarDelete}" var="delete">
                            <c:param name="car" value="${car.id}"/>
                            <c:param name="motorShowId" value="${car.motorShowId}"/>
                        </c:url>
                        <a href="${delete}">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="${urlMotorShowCars}" var="MotorShowCarsList">
                            <c:param name="motorShowId" value="${car.motorShowId}"/>
                        </c:url>
                        <a href="${MotorShowCarsList}">To Motor Show</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
