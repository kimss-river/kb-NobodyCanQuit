<%@ page contentType="text/html; charset=utf-8" %>

<!-- 날씨 -->
<div id="chartContainer" style="height: 370px; width: 100%;"></div>

<script>
window.onload = function () {

var options = {
	animationEnabled: true,  
	title:{
		text: "Monthly Sales - 2017"
	},
	axisX: {
		valueFormatString: "MMM"
	},
	axisY: {
		title: "Sales (in USD)",
		prefix: "$",
		includeZero: false
	},
	data: [{
		yValueFormatString: "$#,###",
		xValueFormatString: "MMMM",
		type: "spline",
		dataPoints: [
			{ x: 00, y: 28 },
			{ x: 03, y: 27 },
			{ x: 06, y: 29 },
			{ x: 09, y: 35 },
			{ x: 12, y: 31 },
			{ x: 15, y: 24 },
			{ x: 18, y: 32 },
			{ x: 21, y: 35 },
			{ x: 24, y: 26 },
		]
	}]
};
$("#chartContainer").CanvasJSChart(options);

}
</script>

<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>