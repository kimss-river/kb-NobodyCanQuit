<%@ page contentType="text/html; charset=utf-8" %>

<!-- 3일간 날씨 -->
<table id="table_weather3day">
	<tr height="15" style="font-size: 10px;">
		<th>날짜</th>
		<th>20/07/03</th>
		<th>20/07/04</th>
		<th>20/07/05</th>
	</tr>
	<tr height="40" style="font-size: 10px;">
		<th>날씨</th>
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="35"></th>
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="35"></th>
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="35"></th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최고기온</th>
		<th>00</th>
		<th>03</th>
		<th>06</th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최저기온</th>
		<th>00</th>
		<th>03</th>
		<th>06</th>
	</tr>
</table>