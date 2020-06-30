package nobodyCanQuit.service;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nobodyCanQuit.web.model.address.AddressCommand;

@Component
public class VilageFcstInfoService  {

	/*
	 * @Autowired AddressCommand adc;
	 */
	
	String date = new SimpleDateFormat("yyyyMMdd HH").format((new Date(System.currentTimeMillis())));
	String[] base_date = date.split(" ");
	
	private String Apiaddress;
		
	public URL getApiUrl() throws IOException{
		
		/* String x = adc.getXCoor() */
		
		getTime(Integer.parseInt(base_date[1]));
		
		Apiaddress ="http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"
				+ "?serviceKey=zGuDv3a%2FY%2FxXtJPaZ4x2I09BsyEbbwzdzoZ5xxO6VSba6r%2BrvDH7bOkuE3R0c5oe3hdHkLdeoFAdD6oPk48cxw%3D%3D"
				+ "&dataType=json&numOfRows=10&pageNo=1&fcstDate=20200701"
				+ "&base_date="+base_date[0]+"&base_time="+base_date[1]
				+ "&nx=55&ny=127";
			
		return new URL(Apiaddress);
	}
	
	private void getTime(int time) {
		
		if(time>=2&& time <5) {
			base_date[1] = "0200";
		}else if(time>= 5&& time <8) {
			base_date[1] = "0500";
		}else if(time>=8 && time <11) {
			base_date[1] = "0800";
		}else if(time>=11 && time < 14) {
			base_date[1] = "1100";
		}else if(time>=14 && time <17) {
			base_date[1] = "1400";
		}else if(time>=17 && time < 20) {
			base_date[1] = "1700";
		}else if(time>=20 && time <23) {
			base_date[1] = "2000";
		}else if(time>=23 || time <2) {
			base_date[1] = "2300";
		}
		
		
	}

}

