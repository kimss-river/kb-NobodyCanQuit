<%@ page contentType="text/html; charset=utf-8" %>

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
    <script src="<c:url value="/resources/js/script.js" />"></script>
    
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
</body>
</html>