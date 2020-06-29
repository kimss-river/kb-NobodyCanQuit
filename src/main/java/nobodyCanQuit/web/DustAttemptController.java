package nobodyCanQuit.web;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.DustAreaAddrService;
import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAreaAddr;
import nobodyCanQuit.web.model.viligeDust.DustAttemptAddr;

@Controller
public class DustAttemptController {
	
	private final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private DustAreaAddrService dustAreaAddrService;

	@PostMapping("DustAttempt")
    public String postDustAttempt(Model model) {
		//미세먼지 시도별 	
        return "test/DustAttempt";
    }

	@GetMapping("/DustAttempt")
	public String getDustAttempt(Model model) throws IOException {
		//미세먼지 시도별
		DustAttemptAddr dustAttempt =
				mapper.readValue(dustAreaAddrService.getDustAttemptUrl(), DustAttemptAddr.class);
		model.addAttribute("finedustAddr", dustAttempt);

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
		DustAreaAddr dustAreaAddr = mapper.readValue(dustAreaAddrService.getApiUrl(), DustAreaAddr.class);
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
