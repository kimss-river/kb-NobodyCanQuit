<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div id="map"></div>

    <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=2f40abcb03a397dc715624e07f39732f&libraries=clusterer"></script>
    <script>
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(36.357041, 127.924168), // 지도의 중심좌표
          level: 13, // 지도의 확대 레벨
          mapTypeId: kakao.maps.MapTypeId.ROADMAP, // 지도종류
        };
      // 지도를 생성한다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      // 마커 클러스터러를 생성합니다
      var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 13, // 클러스터 할 최소 지도 레벨
      });
      var imageBad = "${pageContext.request.contextPath}/resources/imgs/bad.png",
        imageGood = "${pageContext.request.contextPath}/resources/imgs/vgood.png",
        imageError = "${pageContext.request.contextPath}/resources/imgs/error.png",
        imageNormal = "${pageContext.request.contextPath}/resources/imgs/good.png",
        imageSucks = "${pageContext.request.contextPath}/resources/imgs/vbad.png";

      var imageSize = new kakao.maps.Size(44, 48), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
  
      //DustArea
      var markers = [];
      <c:if test="${! empty areaGradeList}">
        <c:forEach items="${areaGradeList}" var="info">
          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            position: new kakao.maps.LatLng(${info.y},${info.x}),
            <c:if test="${info.pm10Grade == '좋음' }" >
            image: new kakao.maps.MarkerImage(
              imageGood,
              imageSize,
              imageOption
            )
            </c:if>
            <c:if test="${info.pm10Grade == '보통' }" >
            image: new kakao.maps.MarkerImage(
              imageNormal,
              imageSize,
              imageOption
            )
            </c:if>
            <c:if test="${info.pm10Grade == '나쁨' }" >
            image: new kakao.maps.MarkerImage(
              imageBad,
              imageSize,
              imageOption
            )
            </c:if>
            <c:if test="${info.pm10Grade == '매우 나쁨' }" >
            image: new kakao.maps.MarkerImage(
              imageSucks,
              imageSize,
              imageOption
            )
            </c:if>
            <c:if test="${empty info.pm10Grade}" >
            image: new kakao.maps.MarkerImage(
              imageError,
              imageSize,
              imageOption
            )
            </c:if>
          });
          markers.push(marker);
          clusterer.addMarkers(markers);
        </c:forEach>
       </c:if>
       <c:if test="${empty areaGradeList}">

       </c:if>
    </script>
</section>