package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.DustAreaAddrService;
import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.AddressForDongCommand;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import nobodyCanQuit.service.address.CityListService;

import java.io.IOException;
import java.util.List;

import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAreaAddr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressTestController {

    @Autowired
    private CityListService cityListService;
    @Autowired
    private AddressApiService addressApiService;
    @Autowired
    private DustAreaAddrService dustAreaAddrService;
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/testKim")
    public String get(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);

        return "test/testKim";
    }

    @PostMapping("/testKim/addressSearch.do")
    public String post(AddressInputCommand addressInputCommand, Model model) throws Exception {

        /*
        * 계층별 주소검색
        */
        model.addAttribute("cityList", cityListService);

        addressApiService.buildApi();
        addressApiService.setAddressInputCommand(addressInputCommand);

        AddressCommand addressCommand =
                mapper.readValue(addressApiService.getAddressLevel2Url(), AddressCommand.class);
        model.addAttribute("addressCommand", addressCommand);

        AddressForDongCommand addressForDongCommand =
                mapper.readValue(addressApiService.getAddressLevel3Url() ,AddressForDongCommand.class);
        model.addAttribute("addressForDongCommand", addressForDongCommand);

        /*
        * 시군구별 실시간 평균정보 조회
        */
        dustAreaAddrService.setAddressInputCommand(addressInputCommand);

        DustAreaAddr dustAreaAddr = mapper.readValue(dustAreaAddrService.getApiUrl(), DustAreaAddr.class);
        model.addAttribute("dustAreaAddr", dustAreaAddr);

        //TODO revision
        if (! addressInputCommand.getGu().isEmpty()) {
            String guName = addressCommand.getGuName(addressInputCommand.getGu());

            List<DustArea> listDust = dustAreaAddr.getDustArea();
            String pm10 = "";
            String sidoName = "";
            String cityName = "";
            for (DustArea e : listDust) {
                if (e.getCityName().equals(guName)) {
                    pm10 = e.getPm10Value();
                    sidoName = e.getSidoName();
                    cityName = e.getCityName();
                }
            }
            model.addAttribute("pm10", pm10);
            model.addAttribute("sidoName", sidoName);
            model.addAttribute("cityName", cityName);
        }

        return "test/testKim";
    }

}
