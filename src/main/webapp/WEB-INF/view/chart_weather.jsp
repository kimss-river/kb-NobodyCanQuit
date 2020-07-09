<%@ page contentType="text/html; charset=utf-8" %>

<!-- 날씨 -->
<div id="weatherChart" class="wChart"></div>
<table id="table_weather">
  <tr>
   
    <th width="39">날씨&nbsp;</th>
<!-- index는 7까지 나와야됌  -->

    <td> ${listPty[0].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[0]}" width="30"></td>
    
    <td>${listPty[1].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[1]}" width="30"></td>
    <td>${listPty[2].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[2]}" width="30"></td>
    <td>${listPty[3].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[3]}" width="30"></td>
    <td>${listPty[4].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[4]}" width="30"></td>
    <td>${listPty[5].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[5]}" width="30"></td>
    <td>${listPty[6].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[6]}" width="30"></td>
    <td>${listPty[7].fcstTime}시<img src="${pageContext.request.contextPath}/resources/imgs/weather/${listImg[7]}" width="30"></td>
  </tr>
</table>
<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
function getWeatherChart() {

	var weather = {
		animationEnabled: true,  
		theme: "light2",
		width: 380,
		height: 150,
		axisY: {
			title: "기온",
	      	suffix: "°C",
			includeZero: false
		},
		toolTip:{
			shared:true
		},
		data: [{
			type: "spline",
			color: "#C0504E",
			name: "기온",
			showInLegend: true,
			yValueFormatString: "#,###°C",
			dataPoints: [
				{ label: ${test2[0].fcstTime}+"시", y: ${test2[0].fcstValue} },
				{ label: ${test2[1].fcstTime}+"시", y: ${test2[1].fcstValue} },
				{ label: ${test2[2].fcstTime}+"시", y: ${test2[2].fcstValue} },
				{ label: ${test2[3].fcstTime}+"시", y: ${test2[3].fcstValue} },
				{ label: ${test2[4].fcstTime}+"시", y: ${test2[4].fcstValue} },
				{ label: ${test2[5].fcstTime}+"시", y: ${test2[5].fcstValue} }, 
				{ label: ${test2[6].fcstTime}+"시", y: ${test2[6].fcstValue} }, 
				{ label: ${test2[7].fcstTime}+"시", y: ${test2[7].fcstValue} }
			]
		}]
	};
	$("#weatherChart").CanvasJSChart(weather);

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
