package nobodyCanQuit.service;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import nobodyCanQuit.web.model.address.FxxxKMAcoord;

@Component
public class VilageFcstInfoService {

	private String Apiaddress;

	public URL getApiUrl(FxxxKMAcoord fxxxKMAcoord) throws IOException {

		//System.out.println(fxxxKMAcoord.getX()+""+fxxxKMAcoord.getY());
		//getTime(Integer.parseInt(base_date[1]));
		//String date = new SimpleDateFormat("yyyyMMdd HH").format((new Date(System.currentTimeMillis())));
		//String[] base_date = date.split(" ");

		Apiaddress = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"
				+ "?serviceKey=zGuDv3a%2FY%2FxXtJPaZ4x2I09BsyEbbwzdzoZ5xxO6VSba6r%2BrvDH7bOkuE3R0c5oe3hdHkLdeoFAdD6oPk48cxw%3D%3D"
				+ "&dataType=json&numOfRows=20&pageNo=1" + "&base_date=" + getDate()
				+ "&base_time=" + getTime() + "&nx=" + fxxxKMAcoord.getX() + "&ny=" + fxxxKMAcoord.getY();

		return new URL(Apiaddress);
	}

	private String getDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	private String getTime() {

		String timeStr = LocalTime.now().format(DateTimeFormatter.ofPattern("HH"));
		int time = Integer.parseInt(timeStr);

		if (time >= 2 && time < 5) {
			return "0200";
		} else if (time >= 5 && time < 8) {
			return "0500";
		} else if (time >= 8 && time < 11) {
			return "0800";
		} else if (time >= 11 && time < 14) {
			return "1100";
		} else if (time >= 14 && time < 17) {
			return "1400";
		} else if (time >= 17 && time < 20) {
			return "1700";
		} else if (time >= 20 && time < 23) {
			return "2000";
		} else {
			return "2300";
		}
	}

}
