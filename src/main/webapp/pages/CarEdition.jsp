<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Create or edit car</title>
</head>
<body class="carEdit">
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <ul class="nav navbar-nav">
            <li><a href="${urlMain}">Main page</a></li>
            <li><a href="${urlCars}">All cars</a></li>
            <li><a href="${urlMotorShows}">All motor shows</a></li>
        </ul>
    </div>
</div>

<div align="center" class="carEdition col-lg-8">
    <form:form class="form" modelAttribute="car" method="post" action="/car/save">
        <div class="form-group">

            <form:label for="model" class="text-right col-sm-3" path="model"
                        modelAttribute="car">Car model:</form:label>
            <div class="col-sm-9">
                <form:input type="text" class="form-control" name="model" id="model" placeholder="Model"
                            value="${car.model}" path="model"/>
            </div>
        </div>
        <div class="errs">
                ${errs.model}
        </div>

        <div class="form-group">
            <form:label for="productionDate" class="text-right col-sm-3"
                        path="productionDate">Production date:</form:label>
            <div class="col-sm-9">
                <form:input type="date" class="form-control" name="productionDate" id="productionDate"
                            placeholder="YYYY-MM-DD" value="${car.productionDate}" path="productionDate"/>
            </div>
        </div>
        <div>
                ${errs.productionDate}
        </div>

        <div class="form-group">
            <form:label for="manufacturer" class="text-right col-sm-3" path="manufacturer">Manufacturer:</form:label>
            <div class="col-sm-9">
                <form:input type="text" class="form-control" name="manufacturer" id="manufacturer"
                            placeholder="Enter company name" value="${car.manufacturer}" path="manufacturer"/>
            </div>
        </div>
        <div>
                ${errs.manufacturer}
        </div>

        <div class="form-group">
            <form:label for="manufacturerEmail" class="text-right col-sm-3"
                        path="manufacturerEmail">Manufacturer E-mail:</form:label>
            <div class="col-sm-9">
                <form:input type="email" class="form-control" name="manufacturerEmail" id="manufacturerEmail"
                            placeholder="Enter E-mail" value="${car.manufacturerEmail}" path="manufacturerEmail"/>
            </div>
        </div>
        <div>
                ${errs.manufacturerEmail}
        </div>

        <div class="form-group">
            <form:label for="price" class="text-right col-sm-3" path="price">Price:</form:label>
            <div class="col-sm-9">
                <form:input type="number" step="any" class="form-control" name="price" id="price"
                            placeholder="Enter price"
                            value="${car.price}" path="price"/>
            </div>
        </div>
        <div>
                ${errs.price}
        </div>

        <div class="form-group">
            <form:label for="engineVolume" class="text-right col-sm-3" path="engineVolume">Engine volume:</form:label>
            <div class="col-sm-9">
                <form:input type="number" step="any" class="form-control" name="engineVolume" id="engineVolume"
                            placeholder="Enter volume of engine" value="${car.engineVolume}" path="engineVolume"/>
            </div>
        </div>
        <div>
                ${errs.engineVolume}
        </div>

        <div class="form-group">
            <form:label for="vinCode" path="vinCode" class="text-right col-sm-3">VIN code:</form:label>
            <div class="col-sm-9">
                <form:input type="text" class="form-control" name="vinCode" id="vinCode"
                            placeholder="Enter VIN code" value="${car.vinCode}" path="vinCode"/>
            </div>
        </div>
        <div>
                ${errs.vinCode}
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <label>
                    <select name="motorShow.id" size="1" Class="select"
                            <c:if test="${car.motorShow.id > 0 && id > 0 }">hidden</c:if>>
                        <option value="${car.motorShow.id}" selected="selected" disabled="disabled">Select motor show
                        </option>
                        <c:forEach var="MS" items="${motorShows}">
                            <option value="${MS.id}">${MS.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
        </div>
        <div>
            <form:input type="hidden" name="motorShow.id" value="${car.motorShow.id}" path="motorShow.id"/>
        </div>
        <div>
            <input type="hidden" name="id" value="${car.id}">
        </div>
        <button type="submit" class="btn btn-Edit">Submit</button>
    </form:form>
</div>
</body>
</html>
