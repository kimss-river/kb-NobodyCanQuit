<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="aside__sWrap">
    <div id="marker">
        <img src="${pageContext.request.contextPath}/resources/imgs/markerWrab.png" width="369" height="100" alt="markerWrab">
    </div>
    <br>
    <div class="serch">
        <h2 style="font-size: 23px; font-weight: bold;">우리 동네 날씨 어때?</h2><br>
<!--         <div id="aside__serch"> -->
				<form:form modelAttribute="addressInputCommand">
					<form:select path="city" onChange="this.form.submit()">
				        <option value=""><spring:message code="search.addressLevel1.title"/></option>
						<form:options items="${cityList.cityName}" />
				    </form:select>
				    <form:select class="aside__serch" path="gu" onChange="this.form.submit()">
				        <option value=""><spring:message code="search.addressLevel2.title"/></option>
				        <c:if test="${! empty addressCommand.resultList}">
							<form:options items="${addressCommand.resultList}" itemLabel="name" itemValue="code" />
						</c:if>
				    </form:select>
				    <form:select path="dong" onChange="this.form.submit()">
				        <option value=""><spring:message code="search.addressLevel3.title"/></option>
				        <c:if test="${! empty addressForDongCommand.resultList}">
							<form:options items="${addressForDongCommand.resultList}" itemLabel="name" itemValue="name" />
						</c:if>
				    </form:select>
				    <button class="serch__button" type="submit"><spring:message code="common.search.title"/></button>
				    <c:if test="${! empty addressInputCommand.dong}">
                		<h4>${addressInputCommand.dong}</h4>
           			</c:if>
				</form:form>
    </div>
</div>
