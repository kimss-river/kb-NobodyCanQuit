<%@ page contentType="text/html; charset=utf-8" %>

<!-- 습도 -->
<div id="humidChart" class="wChart"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
function getHumidChart() {

	var humid = {
		animationEnabled: true,
		theme: "light2",
		width: 380,
		height: 150,
		axisY: {
			title: "습도",
			suffix: "%",
			includeZero: false
		},
		/* toolTip:{
			shared:true
		}, */
		data: [{
			type: "column",
			color: "#C0504E",
			name: "습도",
			showInLegend: true,
			yValueFormatString: "#,###%",
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
	$("#humidChart").CanvasJSChart(humid);

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