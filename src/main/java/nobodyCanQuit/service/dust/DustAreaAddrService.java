package nobodyCanQuit.service.dust;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import lombok.Setter;
import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.service.ApiUrlProvider;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import nobodyCanQuit.web.model.viligeDust.DustArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DustAreaAddrService implements ApiUrlProvider {

	@Autowired
	private ApiAuthKeys apiAuthKeys;
	@Autowired
	private CityListService cityListService;
	@Setter
	private AddressInputCommand addressInputCommand;
	private static final String FinedustArea_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?_returnType=json";

	@Override
    public URL getApiUrl() throws IOException {
		final String numOfRows = "30";
		final String pageNo = "1";
		final String searchCondition = "DAILY";
		final String serviceKey = apiAuthKeys.getDUST_API_SERVICE_KEY();
		String chosenCity = cityListService.getShortName(addressInputCommand.getCity());
		String encodeAddress = URLEncoder.encode(chosenCity,"utf-8");

		StringBuilder stringBuilder = new StringBuilder(FinedustArea_Abbr);
		stringBuilder.append("&numOfRows=").append(numOfRows)
				.append("&pageNo=").append(pageNo)
				.append("&searchCondition=").append(searchCondition)
				.append("&serviceKey=").append(serviceKey)
				.append("&sidoName=").append(encodeAddress);

        return new URL(stringBuilder.toString());
	}
	
	public List<DustArea> dustAreaList(List<DustArea> listDust) {
		for(DustArea e : listDust) {
			if(! e.getPm10Value().isEmpty()) {
				e.setPm10Grade(grade(Double.parseDouble(e.getPm10Value()),DustRating.PM10));
			}
		}	 
		return listDust;
	}
	
	public DustArea selected(String guName, List<DustArea> listDust) {
		DustArea guNameSelected = new DustArea();
		boolean b = true;
		try {
			if(guName.contains(" ")){
				guName = guName.substring(0, guName.indexOf(" "));
			}

			for(DustArea e : listDust) {
				if (e.getCityName().equals(guName) && b) {
	            	guNameSelected = e;
	            	b = false;
	
	            	if(e.getPm10Value() != null) 
	            		guNameSelected.setPm10Grade(grade(Double.parseDouble(e.getPm10Value()),DustRating.PM10));
	            	if(e.getPm25Value() != null) 
	            		guNameSelected.setPm25Grade(grade(Double.parseDouble(e.getPm25Value()),DustRating.PM25));
	            	if(e.getSo2Value() != null) 
	                	guNameSelected.setSo2Grade(grade(Double.parseDouble(e.getSo2Value()),DustRating.SO2));
	            	if(e.getCoValue() != null) 
	                	guNameSelected.setCoGrade(grade(Double.parseDouble(e.getCoValue()),DustRating.CO));
	            	if(e.getO3Value() != null) 
	                	guNameSelected.setO3Grade(grade(Double.parseDouble(e.getO3Value()),DustRating.O3));
	            	if(e.getNo2Value() != null) 
	                	guNameSelected.setNo2Grade(grade(Double.parseDouble(e.getNo2Value()),DustRating.NO2));
				}
			}
			return guNameSelected;
		}catch(Exception e) {
			return guNameSelected;
		}
	}

	public String grade(double value, DustRating dArea) {
		if (value >= 0 && value <= dArea.d[0]) {
			return "좋음";
		} else if (value > dArea.d[0] && value <= dArea.d[1]) {
			return"보통";
		} else if (value > dArea.d[1] && value <= dArea.d[2]) {
			return"나쁨";
		} else {
			return "매우 나쁨";
		}
	}
}

