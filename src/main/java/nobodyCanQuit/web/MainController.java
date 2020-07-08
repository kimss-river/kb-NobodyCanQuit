package nobodyCanQuit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import nobodyCanQuit.service.forecast.ForecastCategory;
import nobodyCanQuit.service.forecast.ForecastData;
import nobodyCanQuit.service.forecast.VilageFcstInfoService;
import nobodyCanQuit.web.model.address.FxxxKMAcoord;
import nobodyCanQuit.web.model.viligefcst.FcstItem;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;
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
import nobodyCanQuit.web.model.viligeDust.DustArea;
import nobodyCanQuit.web.model.viligeDust.DustAreaAddr;

@Controller
public class MainController {

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

    @GetMapping("/")
    public String indexget(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);

        addressApiService.getSGIStoken();

        return "index";
    }

    @PostMapping("/")
    public String indexpost(AddressInputCommand addressInputCommand, Model model) throws Exception {

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

        /*
         * 시군구별 실시간 평균정보 조회
         */
        dustAreaAddrService.setAddressInputCommand(addressInputCommand);

        DustAreaAddr dustAreaAddr = mapper.readValue(dustAreaAddrService.getApiUrl(), DustAreaAddr.class);
        model.addAttribute("dustAreaAddr", dustAreaAddr);

        // areaGradeList : 선택된 도시의 구 전체의 pm10 등급,수치,좌표 리스트
        List<DustArea> listDust= dustAreaAddr.getDustArea();
        HashSet<DustArea> listD = new HashSet<>(listDust);
        listDust = new ArrayList<>(listD);
        List<DustArea> areaGradeList = dustAreaAddrService.dustAreaList(listDust);
        //좌표 삽입
        areaGradeList = dustAreaCoordService.getConvertedList(addressCommand, areaGradeList);

        model.addAttribute("areaGradeList", areaGradeList);

        if (! addressInputCommand.getGu().isEmpty() && addressApiService.getGuStatus().equals("reload")) {
            String guName = addressCommand.getName(addressInputCommand.getGu());

            DustArea guNameSelected = dustAreaAddrService.selected(guName, listDust);
            model.addAttribute("guNameSelected", guNameSelected);
        }

        /*
        * 날씨 조회 서비스
        * */
        if (kmAlistService.getKMAcoord(addressCommand, addressInputCommand) != null) {

            FxxxKMAcoord fxxxKMAcoord = kmAlistService.getKMAcoord(addressCommand, addressInputCommand);
            ViligeFcstStores viligeFcstStores =
                    mapper.readValue(vilageFcstInfoService.getApiUrl(fxxxKMAcoord), ViligeFcstStores.class);

            forecastData.setViligeFcstStores(viligeFcstStores);

            //강수확률, 강수형태, 강수량
            Map<String, String> PopMap = forecastData.getValue(ForecastCategory.POP);
            Map<String, String> PtyMap = forecastData.getValue(ForecastCategory.PTY);
            Map<String, String> R06Map = forecastData.getValue(ForecastCategory.R06);

            //3시간 기온, 최저기온, 최고기온
            Map<String, String> T3HMap = forecastData.getValue(ForecastCategory.T3H);
            Map<String, String> TMNMap = forecastData.getValue(ForecastCategory.TMN);
            Map<String, String> TMXMap = forecastData.getValue(ForecastCategory.TMX);

            //하늘상태, 풍향, 풍속
            Map<String, String> SkyMap = forecastData.getValue(ForecastCategory.SKY);
            Map<String, String> VecMap = forecastData.getValue(ForecastCategory.VEC);
            Map<String, String> WSDMap = forecastData.getValue(ForecastCategory.WSD);

            String rePty = forecastData.getRepresentPty();
            String reSky = forecastData.getRepresentSky();

            model.addAttribute("rePty",rePty);
            model.addAttribute("reSky",reSky);

            model.addAttribute("wthr3day",T3HMap);
            model.addAttribute("R06Map", R06Map);
            model.addAttribute("TMNMap", TMNMap);
            model.addAttribute("TMXMap", TMXMap);
            model.addAttribute("PtyMap", PtyMap);
            model.addAttribute("SkyMap", SkyMap);
            model.addAttribute("VecMap", VecMap);
            model.addAttribute("vilage", viligeFcstStores);

            //TODO test delete
            List<FcstItem> testlist = forecastData.getList(ForecastCategory.T3H);
            
            model.addAttribute("test2", testlist);
        }

        return "index";
    }

}