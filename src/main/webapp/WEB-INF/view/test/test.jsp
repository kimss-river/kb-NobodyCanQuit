<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>test</title>
<!-- Bootstrap 4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-light navbar-light shadow">
		<form:form action="/NobodyCanQuit/test/addressSearch.do"
			modelAttribute="addressInputCommand" class="form-inline">
			<form:select path="city" onChange="this.form.submit()"
				class="form-control mr-sm-3">
				<option value=""><spring:message
						code="search.addressLevel1.title" /></option>
				<form:options items="${cityList.cityName}" />
			</form:select>
			<form:select path="gu" onChange="this.form.submit()"
				class="form-control mr-sm-3">
				<option value=""><spring:message
						code="search.addressLevel2.title" /></option>
				<c:if test="${! empty addressCommand.resultList}">
					<form:options items="${addressCommand.resultList}" itemLabel="name"
						itemValue="code" />
				</c:if>
			</form:select>
			<form:select path="dong" class="form-control mr-sm-3">
				<option value=""><spring:message
						code="search.addressLevel3.title" /></option>
				<c:if test="${! empty addressForDongCommand.resultList}">
					<form:options items="${addressForDongCommand.resultList}"
						itemLabel="name" itemValue="name" />
				</c:if>
			</form:select>
			<button class="btn btn-success" type="submit">
				<spring:message code="common.search.title" />
			</button>
			<c:if test="${! empty addressInputCommand.gu}">
				<h4>${addressInputCommand.gu}</h4>
			</c:if>
		</form:form>
	</nav>

	<%-- <hr>
	<c:forEach items="${R06Map}" var="R06Map">
			${R06Map.key} : ${R06Map.value}<br/>
	</c:forEach>
	<hr>
	<c:forEach items="${TMNMap}" var="TMNMap">
			${TMNMap.key} : ${TMNMap.value}<br/>
	</c:forEach>
	<hr>
	<c:forEach items="${TMXMap}" var="TMXMap">
			${TMXMap.key} : ${TMXMap.value}<br/>
	</c:forEach>
	<hr>
	<c:forEach items="${PtyMap}" var="PtyMap">
			${PtyMap.key} : ${PtyMap.value}<br/>
	</c:forEach>
	<hr>
	<c:forEach items="${SkyMap}" var="SkyMap">
			${SkyMap.key} : ${SkyMap.value}<br/>
	</c:forEach>
	<hr>
	<c:forEach items="${VecMap}" var="VecMap">
			${VecMap.key} : ${VecMap.value}<br/>
	</c:forEach> --%>


나와 ? ${rePty} <br/>
하늘상태? ${reSky}


	<%-- ${vilage.response.body.items.fsctItems} --%>

	<!-- TMX(낮 최고기온)는 11시에 나옴 -->
	<!-- TMN(아침 최저기온)는 02시에 나옴 -->
	<table class="table table-hover">
		
	
		<c:forEach items="${vilage.response.body.items.fsctItems}"
			var="fsctItem">
                <tr>
                    <td width=150>예보일자</td>
                    <td width=150>${fsctItem.fcstDate}</td>
                    <td width=150>예보시각</td>
                    <td width=150>${fsctItem.fcstTime}</td>
                </tr>
			<tr>
				<td width=150>자료구분문자</td>
				<td width=150><c:if test="${fsctItem.category eq 'POP'}">
						<c:out value="강수확률" />
					</c:if> <c:if test="${fsctItem.category eq 'PTY'}">
						<c:out value="강수형태" />
					</c:if> <c:if test="${fsctItem.category eq 'R06'}">
						<c:out value="6시간 강수량" />
					</c:if> <c:if test="${fsctItem.category eq 'S06'}">
						<c:out value="6시간 신적설" />
					</c:if> <c:if test="${fsctItem.category eq 'REH'}">
						<c:out value="습도" />
					</c:if> <c:if test="${fsctItem.category eq 'SKY'}">
						<c:out value="하늘상태" />
					</c:if> <c:if test="${fsctItem.category eq 'T3H'}">
						<c:out value="3시간기온" />
					</c:if> <c:if test="${fsctItem.category eq 'TMN'}">
						<c:out value="아침 최저 기온" />
					</c:if> <c:if test="${fsctItem.category eq 'TMX'}">
						<c:out value="낮 최고 기온" />
					</c:if> <c:if test="${fsctItem.category eq 'UUU'}">
						<c:out value="풍속(동서)" />
					</c:if> <c:if test="${fsctItem.category eq 'VVV'}">
						<c:out value="풍속(남북)" />
					</c:if> <c:if test="${fsctItem.category eq 'VEC'}">
						<c:out value="풍향" />
					</c:if> <c:if test="${fsctItem.category eq 'WSD'}">
						<c:out value="풍속" />
					</c:if></td>
				<td width=150>예보 값</td>
				<td width=150><c:if
						test="${fsctItem.category eq 'POP' || fsctItem.category eq 'REH'}">
						<c:out value="${fsctItem.fcstValue}%" />
					</c:if> <c:if test="${fsctItem.category eq 'PTY'}">
						<c:choose>
							<c:when test="${fsctItem.fcstValue ==0}">
	           			없음
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==1}">
	           			비
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==2}">
	           			비/눈
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==3}">
	           			눈
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==4}">
	           			소나기
	           		</c:when>
						</c:choose>
					</c:if> <c:if test="${fsctItem.category eq 'SKY'}">
						<c:choose>
							<c:when test="${fsctItem.fcstValue ==1}">
	           			맑음
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==3}">
	           			구름많음
	           		</c:when>
							<c:when test="${fsctItem.fcstValue ==4}">
	           			흐림
	           		</c:when>
						</c:choose>
					</c:if> <c:if
						test="${fsctItem.category eq 'T3H' || fsctItem.category eq 'TMX' || fsctItem.category eq 'TMN'}">
						<c:out value="${fsctItem.fcstValue}℃" />
					</c:if> <c:if
						test="${fsctItem.category eq 'UUU' || fsctItem.category eq 'VVV' || fsctItem.category eq 'VEC' || fsctItem.category eq 'WSD' }">
						<c:out value="${fsctItem.fcstValue} m/s" />
					</c:if></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>