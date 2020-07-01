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
				{ label: "00", y: 21 },
				{ label: "03", y: 22 },
				{ label: "06", y: 23 },
				{ label: "09", y: 24 },
				{ label: "12", y: 27 },
				{ label: "15", y: 28 }, 
				{ label: "18", y: 25 }, 
				{ label: "21", y: 29 }
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
				{ label: "00", y: 16 },
				{ label: "03", y: 17 },
				{ label: "06", y: 18 },
				{ label: "09", y: 19 },
				{ label: "12", y: 21 },
				{ label: "15", y: 22 }, 
				{ label: "18", y: 20 }, 
				{ label: "21", y: 23 }
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