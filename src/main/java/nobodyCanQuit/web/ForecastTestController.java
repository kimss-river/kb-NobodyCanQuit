package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.VilageFcstInfoService;
import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.AddressForDongCommand;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAreaAddr;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForecastTestController {

	@Autowired
	private CityListService cityListService;
	@Autowired
	private AddressApiService addressApiService;

	private final ObjectMapper mapper = new ObjectMapper();

//    @RequestMapping("/test")
//    public String weatherForecast(Model model) throws Exception {
//
//        VilageFcstInfoService vilageFcstInfoService = new VilageFcstInfoService();
//        URL url = vilageFcstInfoService.getApiUrl();
//
//        ViligeFcstStores viligeFcstStores =
//                mapper.readValue(url, ViligeFcstStores.class);
//
//        model.addAttribute("vilage", viligeFcstStores);
//
//        return "test/test";
//    }

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

		VilageFcstInfoService vilageFcstInfoService = new VilageFcstInfoService();
		vilageFcstInfoService.setAddressInputCommand(addressInputCommand);
		vilageFcstInfoService.setAddressCommand(addressCommand);
		
		if (!addressInputCommand.getGu().isEmpty()) {
			URL url = vilageFcstInfoService.getApiUrl();

			ViligeFcstStores viligeFcstStores = mapper.readValue(url, ViligeFcstStores.class);

			model.addAttribute("vilage", viligeFcstStores);

		}
		return "test/test";
	}
}
