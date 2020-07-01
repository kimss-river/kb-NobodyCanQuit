<%@ page contentType="text/html; charset=utf-8" %>

<!-- 강수 -->
<div id="prcptChart" style="height: 150px; width: 100%;"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
window.onload = function () {

	var prcpt = {
		animationEnabled: true,  
		theme: "light2",
		axisX: {
					
		},
		axisY: {
			title: "강수량",
			suffix: "mm",
			titleFontColor: "#4F81BC",
			lineColor: "#4F81BC",
			labelFontColor: "#4F81BC",
			tickColor: "#4F81BC",
			includeZero: false
		},
		axisY2: {
			title: "강수확률",
			suffix: "%",
			titleFontColor: "#C0504E",
			lineColor: "#C0504E",
			labelFontColor: "#C0504E",
			tickColor: "#C0504E",
			includeZero: false
		},
		toolTip: {
			shared: true
		},
		legend: {
			cursor: "pointer",
			itemclick: toggleDataSeries
		},
		data: [{
			type: "column",
			color: "#4F81BC",
			name: "강수량",
			showInLegend: true,
			//xValueFormatString: "MMM YYYY",
			yValueFormatString: "#,###mm",
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
		},
		{
			type: "spline",
			color: "#C0504E",
			name: "강수확률",
			axisYType: "secondary",
			showInLegend: true,
			//xValueFormatString: "MMM YYYY",
			yValueFormatString: "#,###%",
			dataPoints: [
				{ x: 00, y: 16 },
				{ x: 03, y: 17 },
				{ x: 06, y: 19 },
				{ x: 09, y: 18 },
				{ x: 12, y: 20 },
				{ x: 15, y: 22 },
				{ x: 18, y: 21 },
				{ x: 21, y: 17 } 
			]
		}]
	};
	$("#prcptChart").CanvasJSChart(prcpt);
	
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