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
          center: new kakao.maps.LatLng(35.878044, 128.627612), // 지도의 중심좌표
          level: 10, // 지도의 확대 레벨
          mapTypeId: kakao.maps.MapTypeId.ROADMAP, // 지도종류
        };
      // 지도를 생성한다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      // 마커 클러스터러를 생성합니다
      var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
      });
      var imageSrc = "${pageContext.request.contextPath}/resources/imgs/good.png", // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
        imageOption
      );
      //DustArea
      var markers = [];
      
      <c:forEach items="${areaGradeList}" var="info">
        console.log('${info.y},${info.x}');
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          position: new kakao.maps.LatLng(${info.y},${info.x}),
          image: markerImage,
        });
        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: '<div style="padding:5px;">Hello World!</div>',
        });
        // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
        infowindow.open(map, marker);
        markers.push(marker);
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          makeOverListener(map, marker, infowindow)
        );
        kakao.maps.event.addListener(
          marker,
          "mouseout",
          makeOutListener(infowindow)
        );
      </c:forEach>
      clusterer.addMarkers(markers);
      // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
      function makeOverListener(map, marker, infowindow) {
        return function () {
          infowindow.open(map, marker);
        };
      }
      // 인포윈도우를 닫는 클로저를 만드는 함수입니다
      function makeOutListener(infowindow) {
        return function () {
          infowindow.close();
        };
      }
    </script>
</section>