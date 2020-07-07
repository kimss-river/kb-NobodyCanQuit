<%@ page contentType="text/html; charset=utf-8" %>

<!-- 미세먼지 -->

<div class="fdWrap">
  <div class="item">
  	<h1>PM 2.5</h1>
  	<p class="item_fdn">초미세먼지</p>
  	<p class="item_fdsh">${guNameSelected.pm25Value}㎍/m³</p>
  	<p class="item_sta">${guNameSelected.pm25Grade}<p>
  </div>
  <div class="item">
    <h1>PM 10</h1>
  	<p class="item_fdn">미세먼지</p>
  	<p class="item_fdsh">${guNameSelected.pm10Value}㎍/m³</p>
  	<p class="item_sta">${guNameSelected.pm10Grade}<p>
  </div>
  <div class="item">
  	<h1>O3</h1>
  	<p class="item_fdn">오존</p>
  	<p class="item_fdsh">${guNameSelected.o3Value}ppm</p>
  	<p class="item_sta">${guNameSelected.o3Grade}<p>
  </div>
  <div class="item">
  	 <h1>NO2</h1>
  	<p class="item_fdn">이산화질소</p>
  	<p class="item_fdsh">${guNameSelected.no2Value}ppm</p>
  	<p class="item_sta">${guNameSelected.no2Grade}<p>
  </div>
  <div class="item">
  	<h1>CO</h1>
  	<p class="item_fdn">일산화탄소</p>
  	<p class="item_fdsh">${guNameSelected.coValue}ppm</p>
  	<p class="item_sta">${guNameSelected.coGrade}<p>
  </div>
  <div class="item">
  	<h1>SO₂</h1>
  	<p class="item_fdn">아황산가스</p>
  	<p class="item_fdsh">${guNameSelected.so2Value}ppm</p>
  	<p class="item_sta">${guNameSelected.so2Grade}<p>
  </div>
 </div>