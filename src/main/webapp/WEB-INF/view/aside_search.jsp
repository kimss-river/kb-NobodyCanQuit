<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="aside__sWrap">
    <div id="marker">
        <img src="${pageContext.request.contextPath}/resources/imgs/markerWrab.png" width="340" height="100" alt="markerWrab">
    </div>
    <br>
    <div class="serch">
        <h2 style="font-size: 23px; font-weight: bold;">우리 동네 날씨 어때?</h2><br>
        <div id="aside__serch">
            <!-- 시/도, 구/군, 동 옵션 선택으로 변경해야함 -->
<!--             <input class="serch__input" type="text" placeholder="구/군을 입력해주세요">
            <button class="serch__button">검색</button> -->
				<form:form modelAttribute="addressInputCommand">
					<form:select path="city" onChange="this.form.submit()">
				        <option value=""><spring:message code="search.addressLevel1.title"/></option>
						<form:options items="${cityList.cityName}" />
				    </form:select>
				    <button class="serch__button" type="submit"><spring:message code="common.search.title"/></button>
				</form:form>
        </div>
    </div>
</div>
