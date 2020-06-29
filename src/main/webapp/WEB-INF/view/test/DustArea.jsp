<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<style>

</style>
<body>

    <!-- 시군구별 실시간 평균정보 조회 조회	 -->
	<h3>미세먼지 일평균 일주일</h3>
	<br />
    도시이름:${dustAreaAddr.dustArea[0].cityName}
<br />
    지역이름:${dustAreaAddr.dustArea[0].sidoName}
<br />
  pm10미세먼지:${dustAreaAddr.dustArea[0].pm10Value}
<br />
 <c:forEach items="${dustAreaAddr.dustArea}" var= "dustArea" varStatus="status">
  ${status.count}.도시이름:${dustArea.cityName}
     <c:if test="${dustArea.cityName eq '강북구'}">
     <!-- 사용자 구 검색 결과  -->
 <h2>검색결과</h2>
<h4> 강북구 인덱스 : ${status.count}
 강북구 미세먼지 : ${dustArea.pm10Value}</h4>
</c:if>
<br />
 </c:forEach>
<br />
<!-- MainController 알고리즘 -->
<h2>BackEnd</h2>
sidoName:${sidoName} cityName:${cityName} pm10:${pm10}
</body>
</html>