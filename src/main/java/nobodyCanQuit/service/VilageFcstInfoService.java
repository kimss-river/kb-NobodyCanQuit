package nobodyCanQuit.service;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import nobodyCanQuit.web.model.address.FxxxKMAcoord;

@Component
public class VilageFcstInfoService {

	@Setter
	AddressCommand addressCommand;
	@Setter
	AddressInputCommand addressInputCommand;
	@Setter
	FxxxKMAcoord fxxxKMAcoord;

	

	String date = new SimpleDateFormat("yyyyMMdd HH").format((new Date(System.currentTimeMillis())));
	String[] base_date = date.split(" ");

	private String Apiaddress;

	public URL getApiUrl(FxxxKMAcoord fxxxKMAcoord) throws IOException {

//		String x = addressCommand.getXCoor(addressInputCommand.getGu());
//		String y = addressCommand.getYCoor(addressInputCommand.getGu());
		
		System.out.println(fxxxKMAcoord.getX()+""+fxxxKMAcoord.getY());
		getTime(Integer.parseInt(base_date[1]));

		Apiaddress = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"
				+ "?serviceKey=zGuDv3a%2FY%2FxXtJPaZ4x2I09BsyEbbwzdzoZ5xxO6VSba6r%2BrvDH7bOkuE3R0c5oe3hdHkLdeoFAdD6oPk48cxw%3D%3D"
				+ "&dataType=json&numOfRows=10&pageNo=1" + "&base_date=" + base_date[0]
				+ "&base_time=" + base_date[1] + "&nx=" + fxxxKMAcoord.getX() + "&ny=" + fxxxKMAcoord.getY();

		return new URL(Apiaddress);
	}

	private void getTime(int time) {

		if (time >= 2 && time < 5) {
			base_date[1] = "0200";
		} else if (time >= 5 && time < 8) {
			base_date[1] = "0500";
		} else if (time >= 8 && time < 11) {
			base_date[1] = "0800";
		} else if (time >= 11 && time < 14) {
			base_date[1] = "1100";
		} else if (time >= 14 && time < 17) {
			base_date[1] = "1400";
		} else if (time >= 17 && time < 20) {
			base_date[1] = "1700";
		} else if (time >= 20 && time < 23) {
			base_date[1] = "2000";
		} else if (time >= 23 || time < 2) {
			base_date[1] = "2300";
		}

	}

}
