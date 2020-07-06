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
    <style>
    </style>
    <jsp:include page="styleInit.jsp" flush="false" />
    <jsp:include page="style.jsp" flush="false"/>
<%--      <script src="<c:url value="/resources/js/script.js" />"></script> --%>
    
</head>
<body>
    <div id="wrap">
        <%@ include file="header.jsp" %>
        <div id="contents">
            <%@ include file="section.jsp" %>
            <%@ include file="aside.jsp" %>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
    
<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
</body>
</html>