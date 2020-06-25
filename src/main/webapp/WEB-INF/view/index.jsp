<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="style.css?after" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrap">
        <%@ include file="header.jsp" %>
        <div id="contents">
            <%@ include file="section.jsp" %>
            <section></section>
            <%@ include file="aside.jsp" %>
            <aside></aside>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>