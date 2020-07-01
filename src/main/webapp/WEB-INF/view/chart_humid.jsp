<%@ page contentType="text/html; charset=utf-8" %>

<!-- 습도 -->
<div id="humidChart" style="height: 150px; width: 100%;"></div>

<script>
//윈도우 로두 후 차트 관련 탭 클릭시 함수가 작동하도록 아래 코드 변경 필요
window.onload = function () {
	
	var humid = {
		animationEnabled: true,
		theme: "light2",
		axisX: {
			
		},
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
			//마우스를 올렸을 때 뜨는 값의 포맷 적용 안됨
			yValueFormatString: "#,###%",
			dataPoints: [
				{ label: "00", y: 10 },
				{ label: "03", y: 15 },
				{ label: "06", y: 25 },
				{ label: "09", y: 30 },
				{ label: "12", y: 28 },
				{ label: "15", y: 32 }, 
				{ label: "18", y: 31 }, 
				{ label: "21", y: 27 }
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