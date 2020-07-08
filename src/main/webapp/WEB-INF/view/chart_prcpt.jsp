<%@ page contentType="text/html; charset=utf-8" %>

<!-- 강수 -->
<div id="prcptChart" class="wChart"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
function getPrcptChart() {

	var prcpt = {
		animationEnabled: true,  
		theme: "light2",
		width: 380,
		height: 150,
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
				{ label: ${listR06[0].fcstTime}+"시", y: ${listR06[0].fcstValue} },
				{ label: ${listR06[1].fcstTime}+"시", y: ${listR06[1].fcstValue} },
				{ label: ${listR06[2].fcstTime}+"시", y: ${listR06[2].fcstValue} },
				{ label: ${listR06[3].fcstTime}+"시", y: ${listR06[3].fcstValue} },
				{ label: ${listR06[4].fcstTime}+"시", y: ${listR06[4].fcstValue} },
				{ label: ${listR06[5].fcstTime}+"시", y: ${listR06[5].fcstValue} }, 
				{ label: ${listR06[6].fcstTime}+"시", y: ${listR06[6].fcstValue} }, 
				{ label: ${listR06[7].fcstTime}+"시", y: ${listR06[7].fcstValue} }
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
				{ label: ${listPop[0].fcstTime}+"시", y: ${listPop[0].fcstValue} },
				{ label: ${listPop[1].fcstTime}+"시", y: ${listPop[1].fcstValue} },
				{ label: ${listPop[2].fcstTime}+"시", y: ${listPop[2].fcstValue} },
				{ label: ${listPop[3].fcstTime}+"시", y: ${listPop[3].fcstValue} },
				{ label: ${listPop[4].fcstTime}+"시", y: ${listPop[4].fcstValue} },
				{ label: ${listPop[5].fcstTime}+"시", y: ${listPop[5].fcstValue} }, 
				{ label: ${listPop[6].fcstTime}+"시", y: ${listPop[6].fcstValue} }, 
				{ label: ${listPop[7].fcstTime}+"시", y: ${listPop[7].fcstValue} }
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