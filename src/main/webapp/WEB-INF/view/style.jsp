<%@ page contentType="text/html; charset=utf-8" %>

<style>
@font-face { 
    font-family: 'NanumBarunGothic';
    src: url('/fonts/NanumBarunGothic.eot');
    src: url('/fonts/NanumBarunGothic.eot') format('embedded-opentype'),
    url('/fonts/NanumBarunGothic.woff') format('woff');
}

html { font-size:62.5%; }

/* 반응형 */
#wrap {width: 100%; margin: auto;}
body {background: #fff;} 
header {width: 100%; height: 65px; background: #263857; position:fixed; top:0; left:0; z-index: 10;}
#contents {width: 1200px; margin: auto; margin-top: 85px;}
section {float: left; width: 780px; margin-bottom: 100px;}
#map {width: 95%; height: 700px; margin-right: 5%;}
aside {float: left; width: 420px;  margin-bottom: 100px;}
footer {clear: both; width: 100%; height: 80px; background: #ede5ff; position:fixed; bottom:0; left:0; z-index: 10;}

/* 화면 너비 0 ~ 1200px */
@media (max-width: 1200px){
    #contents {width: 850px;}
    section {width: 430px;}
    aside {width: 420px;}
}
/* 화면 너비 0 ~ 850px */
@media (max-width: 850px){
    #contents {width: 540px;}
    section {width: 540px; margin-bottom: 30px;}
    #map {width: 100%; height: 550px;}
    aside {width: 540px;}
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
    padding-top: 10px;
}
footer ul {
    padding-top: 5px;
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

/* section */


/* aside_table */
#table_weather {
	margin: 10px 10px 0 10px;
	width: 360px;
}
#table_wind {
	margin: 10px 10px 0 15px;
	width: 355px;
}
#table_weather3day {
	width: 100%;
}
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
	margin-top: 40px;
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
	background: #E2D6FB;
}
.tab_wrap .content_area .btn_tab.act {
	background: #fff;
}
#fdust .content_area_value {
	background: #E2D6FB;
}
#weather .content_area_value {
	background: #fff;
}
.tab_wrap .content_area.act {
	display:block;
}
.tab_wrap .btn_tab[data-depth="1"] {
	width: 25%;
}
.tab_wrap .content_area[data-depth="1"] {
	background: #fff;
}
.tab_wrap .content_area[data-depth="1"] .content_area_value {
	background: #fff;
	
}
.content_area_value {
	width: 380px;
	margin: auto;
}
.content_3days {
	box-sizing: border-box;
	width: 400px;
	padding: 8px 5px;
}
.wChart{
	width:380px;
	height: 150px;
}

/* aside table - fdWrab */
.fdWrap {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows : repeat(2, 120px);
  
  grid-gap: 8px 8px;
 
  padding: 5px;
}

/* .fdWrapS {
	display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-template-rows : repeat(1, 120px);
    
    grid-gap: 8px 8px;
 
    padding: 5px;
} */

.item {
  background-color: #fff;
  border: 1px solid #fff;
  font-size: 1.4rem;
  text-align: center;
  border-radius: 8px;
}

.item > h1 {
  font-size: 2rem;
  font-weight: bold;
}

.item_sta {
  font-size: 2.3rem;
}

/* aside search */
#aside__sWrap {
	text-align:center;
	margin: 10px auto;
}

select {
width: 115px;
padding: .8em .5em;
border: 1px solid #999;
font-family: inherit;
border-radius: 0px;
}

select::-ms-expand {
    display: none;
}

.serch__button {
    width: 50px;
    height: 39.5px;
    border: 0px;
    background: #A197C9;
    outline: none;
    margin-left: 5px;
    color: white;
}

.serch__button:hover {
	background: #263857;
}

</style>