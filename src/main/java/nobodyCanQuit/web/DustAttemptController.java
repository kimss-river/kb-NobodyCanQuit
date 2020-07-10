package nobodyCanQuit.web;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import nobodyCanQuit.service.dust.DustItemCodes;

import nobodyCanQuit.web.model.dust.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.dust.DustAttemptAddrService;

@Controller
public class DustAttemptController {
	
	private final ObjectMapper mapper = new ObjectMapper();
	//@Autowired
	//private DustAreaAddrService dustAreaAddrService;
	@Autowired
	private DustAttemptAddrService dustAttemptAddrService;

	@PostMapping("/DustAttempt")
    public String postDustAttempt(Model model) {
		//미세먼지 시도별 	
        return "test/DustAttempt";
    }

	@GetMapping("/DustAttempt")
	public String getDustAttempt(Model model) throws IOException {
		//미세먼지 지역별
		//측정항목 구분 SO2,CO,O3,NO2,PM10,PM25
		URL url = dustAttemptAddrService.getApiUrl(DustItemCodes.PM10);
		DustAttemptAddr dustAttempt = mapper.readValue(url, DustAttemptAddr.class);
		List<DustCityGrade> dustAttempGrade = dustAttemptAddrService.division(DustItemCodes.PM10, dustAttempt);
		
		model.addAttribute("finedustAddr", dustAttempt);
		model.addAttribute("dustAttempGrade", dustAttempGrade);
		
		return "test/DustAttempt";
	}
	
	@PostMapping("/DustArea")
	public String postDutArea(Model model) {
		//시군구별 실시간 평균정보 조회
		return "test/DustArea";
	}
		
	@GetMapping("/DustArea")
	public String getDutArea(Model model) throws IOException {
		//시군구별 실시간 평균정보 조회 
		DustAreaAddr dustAreaAddr = mapper.readValue(new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?serviceKey=AFt3TjNEJq7jb0QYqGCXr2rMOb4LS%2F11Mv2HqbaHQNsJkT2McS8dfggWVOeac%2FGJFEQRokOtJaEmZSeZKKvqGQ%3D%3D&numOfRows=24&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&searchCondition=DAILY&_returnType=json")
				, DustAreaAddr.class);
		model.addAttribute("dustAreaAddr", dustAreaAddr);
		
		List<DustArea> listDust = dustAreaAddr.getDustArea();
		String pm10 = "";
		String sidoName = "";
		String cityName = "";
		for (DustArea e : listDust) {
			if(e.getCityName().equals("강북구")) {
				pm10 = e.getPm10Value();
				sidoName = e.getSidoName();
				cityName = e.getCityName();
			}
		}
		model.addAttribute("pm10", pm10);
		model.addAttribute("sidoName", sidoName);
		model.addAttribute("cityName", cityName);
		return "test/DustArea";
	}
}
