<%@ page contentType="text/html; charset=utf-8" %>

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

<div class="tab_wrap tab_area">
	<div class="btn_area clearfix">
		<button class="btn btn_tab act" data-depth="0" data-idx="0">날씨</button>
		<button class="btn btn_tab" data-depth="0" data-idx="1">미세먼지</button>
	</div>
	<div class="content_area act" data-depth="0" data-idx="0">
		<p>일간 날씨</p>
		<div class="tab_area">
			<div class="btn_area clearfix">
				<button class="btn btn_tab act" data-depth="1" data-idx="0">날씨</button>
				<button class="btn btn_tab" data-depth="1" data-idx="1">강수</button>
				<button class="btn btn_tab" data-depth="1" data-idx="2">바람</button>
				<button class="btn btn_tab" data-depth="1" data-idx="3">습도</button>
			</div>
	
			<div class="content_area act" data-depth="1" data-idx="0">날씨 상세</div>
			<div class="content_area" data-depth="1" data-idx="1">강수 상세</div>
			<div class="content_area" data-depth="1" data-idx="2">바람 상세</div>
			<div class="content_area" data-depth="1" data-idx="3">습도 상세</div>
		</div>
		<p>주간 날씨</p>
	</div>
	<div class="content_area" data-depth="0" data-idx="1">
		<p>미세먼지 상세</p>
	</div>
</div>
