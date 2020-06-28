package nobodyCanQuit.service;


import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class VilageFcstInfoService  {

	private static String Apiaddress 
	="http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"
			+ "?serviceKey=zGuDv3a%2FY%2FxXtJPaZ4x2I09BsyEbbwzdzoZ5xxO6VSba6r%2BrvDH7bOkuE3R0c5oe3hdHkLdeoFAdD6oPk48cxw%3D%3D"
			+ "&dataType=json&numOfRows=10&pageNo=1"
			+ "&base_date=20200628&base_time=0200"
			+ "&nx=55&ny=127";

	String a ="";
	
	
	
	public URL getApiUrl() {
		
	try {
		return new URL(Apiaddress);
	}catch(IOException e) {
		return null;
		}
	}
}
