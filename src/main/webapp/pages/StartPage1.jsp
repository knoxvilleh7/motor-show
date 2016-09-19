<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="urlMotorShowList" value="motorshows"/>
<c:set var="urlCarList" value="cars"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <style type="text/css">
        body {
            background-image: url("/img/lol.jpg");
        }
    </style>
</head>
<body>
<div align="center" class="refs">
    <a class="btn-danger btn-lg col-lg-offset-2 col-lg-1" href="${urlMotorShowList}" ><Strong>Motor Shows</Strong></a>
    <a class="btn-primary btn-lg col-lg-offset-4 col-lg-1" href="${urlCarList}"> <Strong>Cars </Strong></a>
<div class="col-lg-offset-1"></div>
</div>
</body>
</html>
