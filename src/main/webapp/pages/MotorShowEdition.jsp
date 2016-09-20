<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="urlMotorShowSave" value="/motor_show/save"/>
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
    <title>Create or edit motor show</title>
</head>
<body class="motorShowEdit">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <ul class="nav navbar-nav">
            <li><a href="${urlMain}">Main page</a></li>
            <li><a href="${urlCars}">All cars</a></li>
            <li><a href="${urlMotorShows}">All motor shows</a></li>
        </ul>
    </div>
</div>

<div class="motorShowEdition  col-lg-8">
    <form class="form" method="post" action="${urlMotorShowSave}">
        <div class="form-group">
            <label for="name" class="text-right col-sm-3">Motor show name:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="name" id="name" value="${motorShow.name}">
            </div>
        </div>
        <div class="col-sm-offset-4">
            ${errs.name}
        </div>
        <div class="form-group">
            <label for="address" class="text-right col-sm-3">Motor show address:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="address" id="address" value="${motorShow.address}">
            </div>
        </div>
        <div class="col-sm-offset-4">
            ${errs.address}
        </div>
        <div class="col-sm-offset-6">
            <button type="submit" class="btn btn-Edit">Submit</button>
        </div>
        <div>
            <input type="hidden" name="id" value="${motorShow.id}">
        </div>
    </form>
</div>
</body>
</html>
