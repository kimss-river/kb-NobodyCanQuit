package nobodyCanQuit.service.dust;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import nobodyCanQuit.web.model.dust.DustCityGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.web.model.dust.DustAttempt;
import nobodyCanQuit.web.model.dust.DustAttemptAddr;

@Component
public class DustAttemptAddrService{
	//지역별 미세먼지 평균 조회
	@Autowired
	private ApiAuthKeys apiAuthKeys;
	private static final String FinedustArea_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?";
	@Autowired
	private DustAreaAddrService dustAreaAddrService;

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
    public List<DustCityGrade> division(DustItemCodes dustRating, DustAttemptAddr dustAttempt) {
    	List<DustAttempt> listDustAttempt = dustAttempt.getDustAttempt();
    	double[] arr = new double[17];
    	String[] str = new String[17];
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
		}

		for (int i = 0; i <= 16; i++) {
			str[i] = dustAreaAddrService.grade(arr[i], dustRating);
		}

		List<DustCityGrade> theList = new ArrayList<>(17);
		theList.add(new DustCityGrade("seoul","37.566656", "126.978426"));
		theList.add(new DustCityGrade("busan","35.179787", "129.075014"));
		theList.add(new DustCityGrade("daegu","35.871378", "128.601770"));
		theList.add(new DustCityGrade("incheon","37.455900", "126.705527"));
		theList.add(new DustCityGrade("gwangju","35.160049", "126.851438"));
		theList.add(new DustCityGrade("daejeon","36.350444", "127.384839"));
		theList.add(new DustCityGrade("ulsan","35.539585", "129.311555"));
		theList.add(new DustCityGrade("gyeonggi","37.274988", "127.009410"));
		theList.add(new DustCityGrade("gangwon","37.885343", "127.729790"));
		theList.add(new DustCityGrade("chungbuk","36.635654", "127.491398"));
		theList.add(new DustCityGrade("chungnam","36.659461", "126.673267"));
		theList.add(new DustCityGrade("jeonbuk","35.820322", "127.108732"));
		theList.add(new DustCityGrade("jeonnam","34.816154", "126.462928"));
		theList.add(new DustCityGrade("gyeongbuk","36.575805", "128.505772"));
		theList.add(new DustCityGrade("gyeongnam","35.238252", "128.692409"));
		theList.add(new DustCityGrade("jeju","33.499563", "126.531251"));
		theList.add(new DustCityGrade("sejong","36.478149,", "127.286546"));

		int i = 0;
		for (DustCityGrade dcg : theList) {
			dcg.setGrade(str[i]);
			i++;
		}

        return theList;
    }

}
