<%@ page contentType="text/html; charset=utf-8" %>

<!-- 바람 -->
<div id="windChart" style="height: 150px; width: 100%;"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
window.onload = function () {
	
	var wind = {
		animationEnabled: true,  
		theme: "light2",
		axisX: {
			//값 임의 결정 불가하도록 하는 코드
		}
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
			name: "풍속",
			//xValueFormatString: "MMM YYYY",
			yValueFormatString: "#,###m/s",
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
