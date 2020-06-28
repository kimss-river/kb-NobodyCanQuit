<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aside_serch</title>
    <!-- Bootstrap 4 -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
        <nav class="navbar navbar-expand-sm bg-light navbar-light shadow">
            <form:form modelAttribute="addressInputCommand" class="form-inline">
                <form:select path="city" onChange="this.form.submit()" class="form-control mr-sm-3">
                    <option value=""><spring:message code="search.addressLevel1.title"/></option>
                    <form:options items="${cityList.cityName}" />
                </form:select>
                <form:select path="gu" onChange="this.form.submit()" class="form-control mr-sm-3">
                    <option value=""><spring:message code="search.addressLevel2.title"/></option>
                    <c:if test="${! empty addressCommand.resultList}">
                        <form:options items="${addressCommand.resultList}" itemLabel="name" itemValue="code" />
                    </c:if>
                </form:select>
                <form:select path="dong"  class="form-control mr-sm-3">
                    <option value=""><spring:message code="search.addressLevel3.title"/></option>
                    <c:if test="${! empty addressForDongCommand.resultList}">
                        <form:options items="${addressForDongCommand.resultList}" itemLabel="name" itemValue="code" />
                    </c:if>
                </form:select>
                <button class="btn btn-success" type="submit"><spring:message code="common.search.title"/></button>
                <c:if test="${! empty addressInputCommand.dong}">
                    <h4>${addressInputCommand.dong}</h4>
                </c:if>
            </form:form>
        </nav>
    </div>
</body>
</html>