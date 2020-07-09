package nobodyCanQuit.web.model.dust;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties({"_returnType","dataGubun","dataTerm","dataTime","itemCode",
	"numOfRows","pageNo","resultCode","resultMsg","searchCondition","serviceKey","totalCount",})
@Data
public class DustAttempt {
    @JsonProperty("seoul")//서울
    private String seoul;
    @JsonProperty("busan")//부산
    private String busan;
    @JsonProperty("daegu")//대구
    private String daegu;
    @JsonProperty("incheon")//인천
    private String incheon;
    @JsonProperty("gwangju")//광주
    private String gwangju;
    @JsonProperty("daejeon")//대전
    private String daejeon;
    @JsonProperty("ulsan")//울산
    private String ulsan;
    @JsonProperty("gyeonggi")//경기
    private String gyeonggi;
    @JsonProperty("gangwon")//강원
    private String gangwon;
    @JsonProperty("chungbuk")//충북
    private String chungbuk;
    @JsonProperty("chungnam")//충남
    private String chungnam;
    @JsonProperty("jeonbuk")//전북
    private String jeonbuk;
    @JsonProperty("jeonnam")//전남
    private String jeonnam;
    @JsonProperty("gyeongbuk")//경북
    private String gyeongbuk;
    @JsonProperty("gyeongnam")//경남
    private String gyeongnam;
    @JsonProperty("jeju")//제주
    private String jeju;
    @JsonProperty("sejong")//세종
    private String sejong;
//    //  <!--  <c:forEach items="finedust" var="{finedustAddr.finedustList}" varStatus="status">
//    
//    // </c:forEach> -->
}
