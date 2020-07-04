<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>testKim</title>
    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-light navbar-light shadow">
        <form:form action="/NobodyCanQuit/testKim/addressSearch.do" modelAttribute="addressInputCommand"
        class="form-inline">
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
                    <form:options items="${addressForDongCommand.resultList}" itemLabel="name" itemValue="name" />
                </c:if>
            </form:select>
            <button class="btn btn-success" type="submit"><spring:message code="common.search.title"/></button>
            <c:if test="${! empty addressInputCommand.dong}">
                <h4>${addressInputCommand.dong}</h4>
            </c:if>
        </form:form>
    </nav>
    <c:if test="${! empty tester}">
        <c:forEach items="${tester}" var="test" varStatus="status">
            ${status.index}: ${test.name}: ${test.x}, ${test.y}<br />
        </c:forEach>
    </c:if>

    <!-- 시군구별 실시간 평균정보 조회 조회	 -->
    <h3>미세먼지 일평균 일주일</h3>
    <br />
    시/군/구 이름:${dustAreaAddr.dustArea[0].cityName}
    <br />
    지역이름:${dustAreaAddr.dustArea[0].sidoName}
    <br />
    pm10미세먼지:${dustAreaAddr.dustArea[0].pm10Value}
    <br />
    <!-- DustAreaAddrService.Selected -->
	<h2>Back End 처리</h2>
		${guNameSelected}<br />
		지역 : ${guNameSelected.sidoName}<br />
		시군구 : ${guNameSelected.cityName}<br />
		미세먼지(PM10) 평균농도 : ${guNameSelected.pm10Value}㎍/㎥ ${guNameSelected.pm10Grade}<br />
		미세먼지(PM2.5) 평균농도 : ${guNameSelected.pm25Value}㎍/㎥ ${guNameSelected.pm25Grade}<br />
		아황산가스 평균농도 : ${guNameSelected.so2Value}ppm ${guNameSelected.so2Grade}<br />
		일산화탄소 평균농도 : ${guNameSelected.coValue}ppm ${guNameSelected.coGrade}<br />
		오존 평균농도 : ${guNameSelected.o3Value}ppm ${guNameSelected.o3Grade}<br />
		이산화질소 평균농도 : ${guNameSelected.no2Value}ppm ${guNameSelected.no2Grade}<br />
	<h3>Gade 처리 결과</h3>
	<c:forEach var="d" items="${areaGradeList}">
        지역 : ${d.cityName}
        시군구 : ${d.cityName}
        미세먼지(PM10) 평균농도 : ${d.pm10Value}㎍/㎥
        미세먼지(PM2.5) 평균농도 : ${d.pm25Value}㎍/㎥
        아황산가스 평균농도 : ${d.so2Value}ppm
        일산화탄소 평균농도 : ${d.coValue}ppm
        오존 평균농도 : ${d.o3Value}ppm
        이산화질소 평균농도 : ${d.no2Value}ppm<br />
	</c:forEach>
    <h5>검색결과</h5>
    <c:forEach items="${dustAreaAddr.dustArea}" var= "dustArea" varStatus="status">
        ${status.count}.시/군/구 이름:${dustArea.cityName}
        <c:if test="${! empty dustArea.cityName}">
            <!-- 사용자 구 검색 결과  -->
            <h5>
                인덱스 : ${status.count}
                pm10 : ${dustArea.pm10Value}
                pm25 : ${dustArea.pm25Value}
            </h5>
        </c:if>
    </c:forEach>

</body>
</html>