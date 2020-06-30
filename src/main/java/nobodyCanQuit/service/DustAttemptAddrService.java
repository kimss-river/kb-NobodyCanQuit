package nobodyCanQuit.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.service.address.CityListService;

@Component
public class DustAttemptAddrService{
	//지역별 미세먼지 평균 조회
	@Autowired
	private ApiAuthKeys apiAuthKeys;
	
	CityListService cityListService;
	static String FinedustArea_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?";
    
    public URL getApiUrl(String itemCodes) throws IOException {
		String serviceKey = apiAuthKeys.getDUST_API_SERVICE_KEY();
		String numOfRows = "25";
		String pageNo = "1";
		String itemCode = itemCodes;//측정항목 구분 SO2,CO,O3,NO2,PM10,PM25
		String dataGubun = "HOUR";//시간평균 : HOUR, 일평균 : DAILY
		String searchCondition = "MONTH";//일주일 : WEEK, 한달 : MONTH

		StringBuilder stringBuilder = new StringBuilder(FinedustArea_Abbr);
		stringBuilder.append("&serviceKey=").append(serviceKey)
		        .append("&numOfRows=").append(numOfRows)
				.append("&pageNo=").append(pageNo)
				.append("&itemCode=").append(itemCode)
				.append("&dataGubun=").append(dataGubun)
				.append("&searchCondition=").append(searchCondition)
				.append("&_returnType=json");
				return new URL(stringBuilder.toString());
	}
    
    //미세먼지 좋음 나쁨 표시
    public void divisionPm20(String itemCode,int i) {
    	if("PM10".equals(itemCode)) {
    		if(i>0||i>30) {
    			//좋음
    		}else if(i>31||i>80){
    			//보통
    		}else if(i>81||i>150) {
    			//나쁨
    		}else {
    			//매우 나쁨
    		}
    	}
    	
    	if("PM25".equals(itemCode)) {
    		if(i>=0||i>15) {
    			//좋음
    		}else if(i>=16||i>35){
    			//보통
    		}else if(i>=36||i>75) {
    			//나쁨
    		}else {
    			//매우 나쁨
    		}
    	}
    }
    
}
