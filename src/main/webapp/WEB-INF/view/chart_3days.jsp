<%@ page contentType="text/html; charset=utf-8" %>

<!-- 3일간 날씨 -->
<table id="table_weather3day">
	<tr height="15" style="font-size: 10px;">
		<th>날짜</th>
		<th>${listF[0][0]}</th>
		<th>${listF[1][0]}</th>
	</tr>
	<tr height="40" style="font-size: 10px;">
		<th>날씨</th>		
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/${getRepresent[1]}" width="35"></th>
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/${getRepresent[2]}" width="35"></th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최고기온</th>
		<th>${listF[0][1]}</th>
		<th>${listF[1][1]}</th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최저기온</th>
		
		<th>${listF[0][2]}</th>
		<th>${listF[1][2]}</th>
	</tr>
</table>