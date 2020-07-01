<%@ page contentType="text/html; charset=utf-8" %>

<!-- 날씨 -->
<div id="weatherChart" style="height: 150px; width: 100%;"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
window.onload = function () {
	
	var weather = {
		animationEnabled: true,  
		theme: "light2",
		axisX: {
			
		},
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
			//xValueFormatString: "MMM YYYY",
			yValueFormatString: "#,###°C",
			dataPoints: [
				{ x: 00, y: 26 },
				{ x: 03, y: 27 },
				{ x: 06, y: 29 },
				{ x: 09, y: 28 },
				{ x: 12, y: 30 },
				{ x: 15, y: 32 },
				{ x: 18, y: 31 },
				{ x: 21, y: 27 } 
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
