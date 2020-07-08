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
				{ label: ${listReh[0].fcstTime}+"시", y: ${listReh[0].fcstValue} },
				{ label: ${listReh[1].fcstTime}+"시", y: ${listReh[1].fcstValue} },
				{ label: ${listReh[2].fcstTime}+"시", y: ${listReh[2].fcstValue} },
				{ label: ${listReh[3].fcstTime}+"시", y: ${listReh[3].fcstValue} },
				{ label: ${listReh[4].fcstTime}+"시", y: ${listReh[4].fcstValue} },
				{ label: ${listReh[5].fcstTime}+"시", y: ${listReh[5].fcstValue} }, 
				{ label: ${listReh[6].fcstTime}+"시", y: ${listReh[6].fcstValue} }, 
				{ label: ${listReh[7].fcstTime}+"시", y: ${listReh[7].fcstValue} }
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