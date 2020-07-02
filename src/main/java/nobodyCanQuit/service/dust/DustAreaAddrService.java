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
import nobodyCanQuit.web.model.viligeDust.GuNameSelected;
import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAreaAddr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DustAreaAddrService implements ApiUrlProvider {

	@Autowired
	private ApiAuthKeys apiAuthKeys;
	@Autowired
	CityListService cityListService;
	
	@Setter
	private AddressInputCommand addressInputCommand;
	private static final String FinedustArea_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?_returnType=json";

	@Override
    public URL getApiUrl() throws IOException {
		final String numOfRows = "35";
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

	public DustArea Selected(String guName, List<DustArea> listDust) {
		DustArea guNameSelected =new DustArea();
		boolean b = true;
		
		for(DustArea e : listDust) {
			if (e.getCityName().equals(guName) && b) {
            	guNameSelected.setSidoName(e.getSidoName());
            	guNameSelected.setCityName(e.getCityName());
            	guNameSelected.setPm25Value(e.getPm25Value());
            	guNameSelected.setPm10Value(e.getPm10Value());
            	guNameSelected.setSo2Value(e.getSo2Value());
            	guNameSelected.setCoValue(e.getCoValue());
            	guNameSelected.setO3Value(e.getO3Value());
            	guNameSelected.setNo2Value(e.getNo2Value());

            	b=false;
            	if(e.getPm10Value() != null) 
            		guNameSelected.setPm10Grade(Grade(Double.parseDouble(e.getPm10Value()),0,30,31,80,81,150));
            	if(e.getPm25Value() != null) 
            		guNameSelected.setPm25Grade(Grade(Double.parseDouble(e.getPm25Value()),0,15,16,35,36,75));
            	if(e.getSo2Value() != null) 
                	guNameSelected.setSo2Grade(Grade(Double.parseDouble(e.getSo2Value()),0,0.03,0.031,0.06,0.061,2));
            	if(e.getCoValue() != null) 
                	guNameSelected.setCoGrade(Grade(Double.parseDouble(e.getCoValue()),0,2,2.01,9,9.01,15));
            	if(e.getO3Value() != null) 
                	guNameSelected.setO3Grade(Grade(Double.parseDouble(e.getO3Value()),0,0.030,0.031,0.090,0.091,0.150));
            	if(e.getNo2Value() != null) 
                	guNameSelected.setNo2Grade(Grade(Double.parseDouble(e.getNo2Value()),0,0.02,0.021,0.05,0.051,15));
				}
			System.out.println(e.getPm25Value()+e.getPm10Value()+e.getCoGrade()+e.getO3Grade()+e.getNo2Grade());
			 }
		return guNameSelected;
	}
			
	public String  Grade(double value, double a,double b, double c, double d, double e, double f){
		String str = "";
		
		if (value >= a && value <= b) {
			str="좋음";
		}else if (value >= c && value <= d){
			str="보통";
		} else if (value >= e && value <= f) {
			str="나쁨";
		} else {
			str="매우 나쁨";
		}
		return str;
	}
}

