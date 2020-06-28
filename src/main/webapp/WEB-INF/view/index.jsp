<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
    	<%@ include file="style.jsp" %>
    	<%@ include file="styleInit.jsp" %>
    </style>
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