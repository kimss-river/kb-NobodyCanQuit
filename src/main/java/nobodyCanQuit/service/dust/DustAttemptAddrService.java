package nobodyCanQuit.service.dust;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.web.model.viligeDust.Division;
import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAttempt;
import nobodyCanQuit.web.model.viligeDust.DustAttemptAddr;

@Component
public class DustAttemptAddrService{
	//지역별 미세먼지 평균 조회
	@Autowired
	private ApiAuthKeys apiAuthKeys;
	static String FinedustArea_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?";
	@Autowired
	DustAreaAddrService dustAreaAddrService;
    
    public URL getApiUrl(DustItemCodes itemCodes) throws IOException {
		String serviceKey = apiAuthKeys.getDUST_API_SERVICE_KEY();
		String numOfRows = "1";
		String pageNo = "1";
		String dataGubun = "HOUR";//시간평균 : HOUR, 일평균 : DAILY
		String searchCondition = "MONTH";//일주일 : WEEK, 한달 : MONTH

		StringBuilder stringBuilder = new StringBuilder(FinedustArea_Abbr);
		stringBuilder.append("&serviceKey=").append(serviceKey)
		        .append("&numOfRows=").append(numOfRows)
				.append("&pageNo=").append(pageNo)
				.append("&itemCode=").append(itemCodes)
				.append("&dataGubun=").append(dataGubun)
				.append("&searchCondition=").append(searchCondition)
				.append("&_returnType=json");

		return new URL(stringBuilder.toString());
	}
    
    //미세먼지 좋음 나쁨 표시
    public Division division(DustItemCodes itemCodes, DustAttemptAddr dustAttempt) {
    	List<DustAttempt> listDustAttempt = dustAttempt.getDustAttempt();
    	double[] arr = new double[17];
    	String[] str = new String[17];
    	Division division = new Division() ;
    	for(DustAttempt e:listDustAttempt) {
    		arr[0] = Double.parseDouble(e.getSeoul());
    		arr[1] = Double.parseDouble(e.getBusan());
    		arr[2] = Double.parseDouble(e.getDaegu());
    		arr[3] = Double.parseDouble(e.getIncheon());
    		arr[4] = Double.parseDouble(e.getGwangju());
    		arr[5] = Double.parseDouble(e.getDaejeon());
    		
    		arr[6] = Double.parseDouble(e.getUlsan());
    		arr[7] = Double.parseDouble(e.getGyeonggi());
    		arr[8] = Double.parseDouble(e.getGangwon());
    		arr[9] = Double.parseDouble(e.getChungbuk());
    		arr[10] = Double.parseDouble(e.getChungnam());
    		arr[11] = Double.parseDouble(e.getJeonbuk());
    		
    		arr[12] = Double.parseDouble(e.getJeonnam());
    		arr[13] = Double.parseDouble(e.getGyeongbuk());
    		arr[14] = Double.parseDouble(e.getGyeongnam());
    		arr[15] = Double.parseDouble(e.getJeju());
    		arr[16] = Double.parseDouble(e.getSejong()); 
    		
    		if (itemCodes.equals(DustItemCodes.PM10)) {
        		for (int i = 0; i <= 16; i++) {
        			str[i] = dustAreaAddrService.grade(arr[i],dustAreaAddrService.dustArea(DustItemCodes.PM10));
        			System.out.println(str[i]+"널이야?!");
        		}
    		arr[12] = Integer.parseInt(e.getJeonnam());
    		arr[13] = Integer.parseInt(e.getGyeongbuk());
    		arr[14] = Integer.parseInt(e.getGyeongnam());
    		arr[15] = Integer.parseInt(e.getJeju());
    		arr[16] = Integer.parseInt(e.getSejong());    		
    	}

    	if (itemCodes.equals(DustItemCodes.PM10)) {
    		for (int i = 0; i <= 16; i++) {
				if (arr[i] >= 0 && arr[i] <= 30) {
					str[i] = "좋음";
				} else if (arr[i] > 30 && arr[i] <= 80){
					str[i] = "보통";
				} else if (arr[i] >= 81 && arr[i] <= 150) {
					str[i] = "나쁨";
				} else {
					str[i] = "매우 나쁨";
				}
    		}
    	}
    	division.setSeoul(str[0]); 
    	division.setBusan(str[1]);
    	division.setDaegu(str[2]);
    	division.setIncheon(str[3]);
    	division.setGwangju(str[4]);
    	division.setDaejeon(str[5]);
		
    	division.setUlsan(str[6]); 
    	division.setGyeonggi(str[7]);
    	division.setGangwon(str[8]);
    	division.setChungbuk(str[9]);
    	division.setChungnam(str[10]);
    	division.setJeonbuk(str[11]);
		
    	division.setJeonnam(str[12]); 
    	division.setGyeongbuk(str[13]);
    	division.setGyeongnam(str[14]);
    	division.setJeju(str[15]);
    	division.setJeju(str[15]);
    	division.setSejong(str[16]);
    	} 
        return division;
    } 
   
}
