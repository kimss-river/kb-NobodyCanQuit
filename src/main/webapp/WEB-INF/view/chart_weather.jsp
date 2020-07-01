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
				{ label: "00", y: 21 },
				{ label: "03", y: 22 },
				{ label: "06", y: 23 },
				{ label: "09", y: 24 },
				{ label: "12", y: 27 },
				{ label: "15", y: 28 }, 
				{ label: "18", y: 25 }, 
				{ label: "21", y: 29 }
			]
		}]
	};
	$("#weatherChart").CanvasJSChart(weather);
	//클래스 클릭시 수행되는 이벤트.. 참고해서 탭 클릭시 차트 뜨도록 수정해보기
	//$('.content').click(function(){});

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
