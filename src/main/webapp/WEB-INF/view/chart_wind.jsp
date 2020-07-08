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
				{ label: ${listWsd[0].fcstTime}+"시", y: ${listWsd[0].fcstValue} },
				{ label: ${listWsd[1].fcstTime}+"시", y: ${listWsd[1].fcstValue} },
				{ label: ${listWsd[2].fcstTime}+"시", y: ${listWsd[2].fcstValue} },
				{ label: ${listWsd[3].fcstTime}+"시", y: ${listWsd[3].fcstValue} },
				{ label: ${listWsd[4].fcstTime}+"시", y: ${listWsd[4].fcstValue} },
				{ label: ${listWsd[5].fcstTime}+"시", y: ${listWsd[5].fcstValue} }, 
				{ label: ${listWsd[6].fcstTime}+"시", y: ${listWsd[6].fcstValue} }, 
				{ label: ${listWsd[7].fcstTime}+"시", y: ${listWsd[7].fcstValue} }
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
