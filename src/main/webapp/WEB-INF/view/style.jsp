<%@ page contentType="text/html; charset=utf-8" %>

<style>
@font-face { 
    font-family: 'NanumBarunGothic';
    src: url('/fonts/NanumBarunGothic.eot');
    src: url('/fonts/NanumBarunGothic.eot') format('embedded-opentype'),
    url('/fonts/NanumBarunGothic.woff') format('woff');
}

/* 반응형 */
#wrap {width: 100%; margin: auto;}
body {background: #E2D6FB;} 
header {width: 100%; height: 65px; background: #263857; position:fixed; top:0; left:0;}
#contents {width: 60%; margin: auto; margin-top: 85px;}
section {float: left; width: 65%;}
aside {float: left; width: 35%;}
footer {clear: both; width: 100%; height: 55px; background: #A197C9; position:fixed; bottom:0; left:0}

/* 화면 너비 0 ~ 1200px */
@media (max-width: 1140px){
    #contents {width: 100%;}
}
/* 화면 너비 0 ~ 768px */
@media (max-width: 720px){
    #contents {width: 100%;}
    section {width: 100%;}
    aside {width: 100%;}
}

/* 색상 클래스 */
.bgLight {
    background-color: #E2D6FB;
}
.bgMid {
    background-color: #A197C9;
}
.bgDark {
    background-color: #263857;
}
.txtLight {
    color: #E2D6FB;
}
.txtMid {
    color: #A197C9;
}
.txtDark {
    color: #263857;
}

/* header */
header a {
    display: block;
    margin: auto; 
    line-height: 65px;
    text-align: center;
    font-size: 40px;
    font-weight: bolder;
}

/* footer */
footer > div {
    margin: auto;
}
footer ul {
    padding-top: 10px;
    margin: auto;
    text-align: center;
}
footer li {
    display: inline;
    margin: 0px 1px 0px 1px;
    font-size: 12px;
}
footer a {
    color: #263857;
}

/* aside_table */
.btn {
	padding:0;
	background:transparent;
	border:0;
	outline:0;
}
.clearfix::after {
	display:block;
	content:'';
	clear:both;
}
.tab_wrap {
	width:800px;
	margin:50px auto;
}
.tab_wrap .btn_tab {
	float:left;
	width:120px;
	height:30px;
	background:#E2D6FB;
	text-align:center;
	line-height:30px;
}
.tab_wrap .btn_tab.act {
	background:#A197C9;
	font-weight:bold;
}
.tab_wrap .content_area {
	display:none;
	width:100%;
	min-height:200px;
	padding:10px;
	background:#E2D6FB;
	border-radius:0 0 10px 10px;
	box-sizing:border-box;
}
.tab_wrap .content_area.act {
	display:block;
}
.tab_wrap *[data-depth="1"] {
	
}

</style>