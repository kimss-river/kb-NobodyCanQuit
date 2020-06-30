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
<style>

</style>
<body>

    <!-- 미세먼지 시도별 실시간 평균정보 조회	 -->
	<h3>미세먼지 일평균 일주일</h3>
	<br />
    서울:${finedustAddr.dustAttempt[0].seoul}
    대구:${finedustAddr.dustAttempt[0].daegu}
     인천:${finedustAddr.dustAttempt[0].incheon}
    광주:${finedustAddr.dustAttempt[0].gwangju}
    대전:${finedustAddr.dustAttempt[0].daejeon}
    울산:${finedustAddr.dustAttempt[0].ulsan}
     경기:${finedustAddr.dustAttempt[0].gyeonggi}
    강원:${finedustAddr.dustAttempt[0].gangwon}
   <h3>미세먼지 표시 PM10</h3>
  ${division} <br />
서울 : ${division.seoul} 
대구 : ${division.daegu}
인천: ${division.incheon}
광주: ${division.gwangju}
대전: ${division.daejeon}
울산: ${division.ulsan}
경기: ${division.gyeonggi}
강원: ${division.gangwon}  

</body>
</html>