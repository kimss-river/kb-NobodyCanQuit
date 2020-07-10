package nobodyCanQuit.web;

import java.io.IOException;
import java.util.List;

import nobodyCanQuit.service.dust.DustAttemptAddrService;
import nobodyCanQuit.service.dust.DustItemCodes;
import nobodyCanQuit.service.forecast.ForecastData;
import nobodyCanQuit.service.forecast.VilageFcstInfoService;
import nobodyCanQuit.web.model.dust.DustAttemptAddr;
import nobodyCanQuit.web.model.dust.DustCityGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import nobodyCanQuit.service.dust.DustAreaAddrService;
import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.service.address.DustAreaCoordService;
import nobodyCanQuit.service.address.KMAlistService;
import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.AddressForDongCommand;
import nobodyCanQuit.web.model.address.AddressInputCommand;

@Controller
public class AaTestController {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private CityListService cityListService;
    @Autowired
    private AddressApiService addressApiService;
    @Autowired
    private DustAreaAddrService dustAreaAddrService;
    @Autowired
    private KMAlistService kmAlistService;
    @Autowired
    private DustAreaCoordService dustAreaCoordService;
    @Autowired
    private VilageFcstInfoService vilageFcstInfoService;
    @Autowired
    private ForecastData forecastData;
    @Autowired
    private DustAttemptAddrService dustAttemptAddrService;

    @GetMapping("/aa")
    public String indexget(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);
        addressApiService.getSGIStoken();

        DustAttemptAddr dustAttempt =
                mapper.readValue(dustAttemptAddrService.getApiUrl(DustItemCodes.PM10), DustAttemptAddr.class);
        List<DustCityGrade> dustCityList = dustAttemptAddrService.division(DustItemCodes.PM10, dustAttempt);
        model.addAttribute("dustCityList", dustCityList);

        model.addAttribute("test34", dustCityList);

        return "test/aa";
    }

    @PostMapping("/aa")
    public String indexpost(AddressInputCommand addressInputCommand, Model model) throws Exception {
        model.addAttribute("test33", "asddddd");
        /*
         * 계층별 주소검색
         */
        model.addAttribute("cityList", cityListService);

        addressApiService.getSGIStoken();
        addressApiService.setAddressInputCommand(addressInputCommand);

        AddressCommand addressCommand =
                mapper.readValue(addressApiService.getAddressLevel2Url(), AddressCommand.class);
        model.addAttribute("addressCommand", addressCommand);

        AddressForDongCommand addressForDongCommand =
                mapper.readValue(addressApiService.getAddressLevel3Url(), AddressForDongCommand.class);
        model.addAttribute("addressForDongCommand", addressForDongCommand);

        return "test/aa";
    }

}