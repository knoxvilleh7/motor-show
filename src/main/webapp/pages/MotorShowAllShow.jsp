<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pageList" scope="request" class="project.model.Page"/>
<jsp:useBean id="motorShow" scope="request" type="java.util.List"/>
<c:set var="urlMotorShowList" value="motorshows"/>
<c:set var="urlCarList" value="cars"/>
<c:set var="urlCarEdit" value="caredition"/>
<c:set var="urlMotorShowEdit" value="motorshowedition"/>
<c:set var="urlMotorShowCars" value="mscars"/>
<c:set var="urlMotorShowDelete" value="deleteshow"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <title>Motor Shows.</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="responsive-menu">
            <div class="bar-left col-lg-10">
                <form class="form-inline" method="get" action="${urlMotorShowList}">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/">Main page</a></li>
                        <li><a href="${urlCarList}">All cars</a></li>
                        <li><a href="${urlMotorShowList}">All motor shows</a></li>
                        <li><a href="${urlCarEdit}">Create car</a></li>
                        <li><a href="${urlMotorShowEdit}">Create motor Show</a></li>
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
                <form class="form-inline search-ms" method="get" action="${urlMotorShowList}">
                    <input type="text" name="search" placeholder="Search" value="">
                    <Strong>By</Strong>
                    <label>
                        <select name="searchBy" class="select">
                            <option value="name">Motor show name</option>
                            <option value="address">Motor show address</option>
                        </select>
                    </label>
                    <button type="submit" class="btn btn-sm">Search</button>

                </form>
            </div>
        </div>
    </div>
</div>

<div align="center">
    <table class="table_price" cellpadding="4" cellspacing="1">

        <caption><h1>Motor shows</h1></caption>
        <tr>
            <th>Name</th>
            <th>Address</th>
        </tr>
        <c:forEach var="MS" items="${motorShow}">
            <tr>
                <td><c:out value="${MS.name}"/></td>
                <td><c:out value="${MS.address}"/></td>
                <td>
                    <div>
                        <c:url value="${urlMotorShowEdit}" var="edit">
                            <c:param name="motorShowId" value="${MS.id}"/>
                        </c:url>
                        <a href="${edit}">Edit</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="${urlMotorShowDelete}" var="delete">
                            <c:param name="motorShowId" value="${MS.id}"/>
                        </c:url>
                        <a href="${delete}">Delete</a>
                    </div>
                </td>
                <td>
                    <div>
                        <c:url value="${urlMotorShowCars}" var="MotorShowCars">
                            <c:param name="motorShowId" value="${MS.id}"/>
                        </c:url>
                        <a href="${MotorShowCars}">Show cars</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
