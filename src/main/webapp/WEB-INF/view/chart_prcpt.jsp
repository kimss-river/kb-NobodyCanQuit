<%@ page contentType="text/html; charset=utf-8" %>

<!-- 강수 -->
<div id="prcptChart" class="wChart"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
function getPrcptChart() {

	var prcpt = {
		animationEnabled: true,  
		theme: "light2",
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
			yValueFormatString: "#,###mm",
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
		},
		{
			type: "spline",
			color: "#C0504E",
			name: "강수확률",
			axisYType: "secondary",
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