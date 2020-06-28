<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
    </style>
    <jsp:include page="style.jsp" flush="false"/>
    <jsp:include page="styleInit.jsp" flush="false" />
    
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