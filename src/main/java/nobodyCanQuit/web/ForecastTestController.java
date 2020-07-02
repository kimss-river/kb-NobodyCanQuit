package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.service.address.KMAlistService;
import nobodyCanQuit.service.forecast.ForecastCategory;
import nobodyCanQuit.service.forecast.ForecastData;
import nobodyCanQuit.service.forecast.VilageFcstInfoService;
import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.AddressForDongCommand;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import nobodyCanQuit.web.model.address.FxxxKMAcoord;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForecastTestController {

	private final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private CityListService cityListService;
	@Autowired
	private AddressApiService addressApiService;
	@Autowired
	private KMAlistService kmAlistService;
	@Autowired
	private VilageFcstInfoService vilageFcstInfoService;
	@Autowired
	private ForecastData forecastData;

	@GetMapping("/test")
	public String get(AddressInputCommand addressInputCommand, Model model) throws IOException {

		model.addAttribute("cityList", cityListService);

		addressApiService.buildApi();

		return "test/test";
	}

	@PostMapping("/test/addressSearch.do")
	public String post(AddressInputCommand addressInputCommand, Model model) throws Exception {

		/*
		 * 계층별 주소검색
		 */
		model.addAttribute("cityList", cityListService);
		addressApiService.buildApi();
		addressApiService.setAddressInputCommand(addressInputCommand);
		
		AddressCommand addressCommand = mapper.readValue(addressApiService.getAddressLevel2Url(), AddressCommand.class);
		model.addAttribute("addressCommand", addressCommand);

		AddressForDongCommand addressForDongCommand = mapper.readValue(addressApiService.getAddressLevel3Url(),
				AddressForDongCommand.class);
		model.addAttribute("addressForDongCommand", addressForDongCommand);

		/*
		* 날씨 조회 서비스
		* */
		if (kmAlistService.getKMAcoord(addressCommand, addressInputCommand) != null) {

			FxxxKMAcoord fxxxKMAcoord = kmAlistService.getKMAcoord(addressCommand, addressInputCommand);
			ViligeFcstStores viligeFcstStores =
					mapper.readValue(vilageFcstInfoService.getApiUrl(fxxxKMAcoord), ViligeFcstStores.class);
			
			forecastData.setViligeFcstStores(viligeFcstStores);
			
			//강수확률 강수형태 강수량
			Map<String, String> PopMap =forecastData.getValue(ForecastCategory.POP);
			Map<String, String> PtyeMap =forecastData.getValue(ForecastCategory.PTY);
			Map<String, String> R06Map =forecastData.getValue(ForecastCategory.R06);
			
			//3시간 기온 최저기온 최고기온
			Map<String, String> TH3Map =forecastData.getValue(ForecastCategory.TH3);
			Map<String, String> TMNMap =forecastData.getValue(ForecastCategory.TMN);
			Map<String, String> TMXMap =forecastData.getValue(ForecastCategory.TMX);
			
			//하늘상태 풍향 풍속
			Map<String, String> SkyMap =forecastData.getValue(ForecastCategory.SKY);
			Map<String, String> VecMap =forecastData.getValue(ForecastCategory.VEC);
			Map<String, String> WSDMap =forecastData.getValue(ForecastCategory.WSD);
			
			model.addAttribute("PopMap", PopMap);
			model.addAttribute("vilage", viligeFcstStores);
		}
		return "test/test";
	}
}
