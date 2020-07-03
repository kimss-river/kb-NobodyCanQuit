<%@ page contentType="text/html; charset=utf-8" %>

<!-- 바람 -->
<div id="windChart" class="wChart"></div>

<table id="table_wind">
  <tr>
    <th width="41">풍향&nbsp;</th>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
    <td><img src="${pageContext.request.contextPath}/resources/imgs/weather/sun.png" width="30"></td>
  </tr>
</table>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
function getWindChart() {
	
	var wind = {
		animationEnabled: true,
		theme: "light2",
		width: 380,
		height: 150,
		axisY: {
			title: "풍속",
	      	suffix: "m/s",
			includeZero: false
		},
		toolTip:{
			shared:true
		},
		data: [{
			type: "spline",
			color: "#C0504E",
			name: "풍속 (아이콘)풍향",
			showInLegend: true,
			yValueFormatString: "#,###.#m/s",
			dataPoints: [
				{ label: "00시", y: 21 },
				{ label: "03시", y: 22 },
				{ label: "06시", y: 23 },
				{ label: "09시", y: 24 },
				{ label: "12시", y: 27 },
				{ label: "15시", y: 28 }, 
				{ label: "18시", y: 25 }, 
				{ label: "21시", y: 29 }
			]
		}]
	};
	$("#windChart").CanvasJSChart(wind);

	function toggleDataSeries(e) {
		if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
			e.dataSeries.visible = false;
		} else {
			e.dataSeries.visible = true;
		}
		e.chart.render();
	}
}
</script>
