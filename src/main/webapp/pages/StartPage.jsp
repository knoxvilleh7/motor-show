<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body class="main">

<div align="center" class="refs">
    <a class="btn-danger btn-lg col-lg-offset-2 col-lg-1" href="${urlMotorShows}" ><Strong>Motor Shows</Strong></a>
    <a class="btn-primary btn-lg col-lg-offset-4 col-lg-1" href="${urlCars}"> <Strong>Cars </Strong></a>
<div class="col-lg-offset-1"></div>
</div>
</body>
</html>
