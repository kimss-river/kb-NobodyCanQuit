<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aside_serch</title>
</head>
<body>
    <div id="aside__sWrap">
        <div id="marker">
            <img src="/imgs/markerWrab.png" alt="markerWrab">
        </div>
        <div class="serch">
            <h2 style="font-size: 23px; font-weight: bold;">우리 동네 날씨 어때?</h2><br>
            <div id="aside__serch">
                <!-- 시/도, 구/군, 동 옵션 선택으로 변경해야함 -->
                <input class="serch__input" type="text" placeholder="구/군을 입력해주세요">
                <button class="serch__button">검색</button>
            </div>
        </div>
        <div class="search-test">
            <h5>${accessToken}</h5>
            <c:if test="${! empty addressInputCommand}">
                <h4>${addressInputCommand.city}</h4>
            </c:if>
            <form:form modelAttribute="addressInputCommand">
                <form:select path="city" items="${searchCommand.cityName}"/>
                <button type="submit">Search</button>
            </form:form>
        </div>
    </div>
</body>
</html>