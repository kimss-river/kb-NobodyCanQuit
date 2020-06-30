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
body {background: #fff;} 
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

/* header */
header a {
    display: block;
    width: 350px;
    margin: auto; 
    line-height: 65px;
    text-align: center;
    font-size: 40px;
    font-weight: bolder;
    color: #E2D6FB;
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
    color: #263857;
}
footer a {
    color: #263857;
}
footer a:hover {
    text-decoration: underline;
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
	width:100%;
	margin:50px auto;
}
.tab_wrap .btn_tab {
	float:left;
	width:50%;
	height:30px;
	background:#fff;
	text-align:center;
	line-height:30px;
}
.tab_wrap .btn_tab.act {
	background: #E2D6FB;
	font-weight:bold;
}
.tab_wrap .content_area {
	display:none;
	width:100%;
	min-height:200px;
	padding:10px;
	background:#E2D6FB;
	box-sizing:border-box;
}
.tab_wrap .content_area .tab_area {
	margin-bottom: 10px;
}
.tab_wrap .content_area .btn_tab {
	background: #E2D6FB
}
.tab_wrap .content_area .btn_tab.act {
	background: #fff
}
.tab_wrap .content_area .content_area_value {
	background: #fff;
}
.tab_wrap .content_area.act {
	display:block;
}
.tab_wrap .btn_tab[data-depth="1"] {
	width: 25%
}
.tab_wrap .content_area[data-depth="1"] {
	background: #fff
}
.tab_wrap .content_area[data-depth="1"] .content_area_value {
	background: #fff;
}
</style>