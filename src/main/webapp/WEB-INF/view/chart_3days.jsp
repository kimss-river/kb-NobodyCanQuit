<%@ page contentType="text/html; charset=utf-8" %>

<!-- 3일간 날씨 -->
<table id="table_weather3day">
	<tr height="15" style="font-size: 10px;">
		<th>날짜</th>
		<th>${listTmn[0].fcstDate}</th>
		<th>${listTmn[1].fcstDate}</th>
	</tr>
	<tr height="40" style="font-size: 10px;">
		<th>날씨</th>		
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/${getRepresent[1]}" width="35"></th>
		<th><img src="${pageContext.request.contextPath}/resources/imgs/weather/${getRepresent[2]}" width="35"></th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최고기온</th>		
		<th>${listTmx[0].fcstValue}</th>
		<th>${listTmx[1].fcstValue}</th>
	</tr>
	<tr height="15" style="font-size: 13px;">
		<th>최저기온</th>
		<th>${listTmn[0].fcstValue}</th>
		<th>${listTmn[1].fcstValue}</th>
	</tr>
</table>