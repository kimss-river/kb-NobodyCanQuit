<%@ page contentType="text/html; charset=utf-8" %>

<div class="tab_wrap tab_area">
	<div class="btn_area clearfix">
		<button class="btn btn_tab act" data-depth="0" data-idx="1">미세먼지</button>
		<button class="btn btn_tab" data-depth="0" data-idx="0" onclick="getWeatherChart()">날씨</button>
	</div>
	<div id="fdust" class="content_area act" data-depth="0" data-idx="1">
		<div class="content_area_value">
			<!-- 미세먼지 -->
			<%@ include file="chart_fdust.jsp" %>
		</div>
	</div>
	<div id="weather" class="content_area" data-depth="0" data-idx="0">
		<div class="tab_area">
			<div class="btn_area clearfix">
				<button class="btn btn_tab act" data-depth="1" data-idx="0" onclick="getWeatherChart()">날씨</button>
				<button class="btn btn_tab" data-depth="1" data-idx="1" onclick="getPrcptChart()">강수</button>
				<button class="btn btn_tab" data-depth="1" data-idx="2" onclick="getWindChart()">바람</button>
				<button class="btn btn_tab" data-depth="1" data-idx="3" onclick="getHumidChart()">습도</button>
			</div>
	
			<div class="content_area act" data-depth="1" data-idx="0">
				<div class="content_area_value">
					<!-- 날씨 -->
					<c:if test="${! empty listPop}">
						<%@ include file="chart_weather.jsp" %>
					</c:if>
					<c:if test="${empty listPop}">
						<%@ include file="aside_nodata.jsp" %>
					</c:if>
				</div>
			</div>
			<div class="content_area" data-depth="1" data-idx="1">
				<div class="content_area_value">
					<!-- 강수 -->
					<c:if test="${! empty listPop}">
						<%@ include file="chart_prcpt.jsp" %>
					</c:if>
					<c:if test="${empty listPop}">
						<%@ include file="aside_nodata.jsp" %>
					</c:if>
				</div>
			</div>
			<div class="content_area" data-depth="1" data-idx="2">
				<div class="content_area_value">
					<!-- 바람 -->
					<c:if test="${! empty listPop}">
						<%@ include file="chart_wind.jsp" %>
					</c:if>
					<c:if test="${empty listPop}">
						<%@ include file="aside_nodata.jsp" %>
					</c:if>
				</div>
			</div>
			<div class="content_area" data-depth="1" data-idx="3">
				<div class="content_area_value">
					<!-- 습도 -->
					<c:if test="${! empty listPop}">
						<%@ include file="chart_humid.jsp" %>
					</c:if>
					<c:if test="${empty listPop}">
						<%@ include file="aside_nodata.jsp" %>
					</c:if>
				</div>
			</div>
		</div>
		<div class="content_area_value content_3days">
			<c:if test="${! empty listPop}">
				<%@ include file="chart_3days.jsp" %>
			</c:if>
			<c:if test="${empty listPop}">
				<%@ include file="aside_nodata.jsp" %>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
	function findParent(el, className){
	  let check = el.parentNode.classList.contains(className);
	  
	  if(check === true){
	     return el.parentNode;
	  }else{
	    return findParent(el.parentNode, className);
	  }
	}

	function bindingTabEvent(wrap){
	  let wrapEl = document.querySelectorAll(wrap);
	  
	  wrapEl.forEach(function(tabArea){
	    let btn = tabArea.querySelectorAll('.btn_tab');
	    
	    btn.forEach(function(item){
	      item.addEventListener('click', function(){
	        let parent = findParent(this, 'tab_area');
	        let idx = this.dataset['idx'];
	        let depth = this.dataset['depth'];
	        let btnArr = parent.querySelectorAll('.btn_tab[data-depth="'+ depth +'"]');
	        let contentArr = parent.querySelectorAll('.content_area[data-depth="'+ depth +'"]');
	        
	        btnArr.forEach(function(btn){ btn.classList.remove('act'); });
	        this.classList.add('act');
	        contentArr.forEach(function(content){ content.classList.remove('act'); });
	        parent.querySelector('.content_area[data-idx="'+ idx +'"][data-depth="'+ depth +'"]').classList.add('act');
	      });
	    });
	  });
	}

	bindingTabEvent('.tab_wrap');
</script>