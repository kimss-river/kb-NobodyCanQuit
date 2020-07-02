package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.address.*;
import nobodyCanQuit.service.dust.DustAreaAddrService;
import nobodyCanQuit.web.model.address.*;

import java.io.IOException;
import java.util.ArrayList;
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

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private CityListService cityListService;
    @Autowired
    private AddressApiService addressApiService;
    @Autowired
    private DustAreaAddrService dustAreaAddrService;
    @Autowired
    private KMAlistService kmAlistService;

    @GetMapping("/testKim")
    public String get(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);
        addressApiService.getSGIStoken();

        return "test/testKim";
    }

    @PostMapping("/testKim/addressSearch.do")
    public String post(AddressInputCommand addressInputCommand, Model model) throws Exception {

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
                mapper.readValue(addressApiService.getAddressLevel3Url() ,AddressForDongCommand.class);
        model.addAttribute("addressForDongCommand", addressForDongCommand);

        // TODO 테스트 필요
        CoordService coordService = new CoordService();
        List<AddressCommand.Result> test = new ArrayList<>();
        test = coordService.convert(addressCommand.getResultList(), addressCommand.getResultList(),
                CoordService.CoordSystem.UTM, CoordService.CoordSystem.WGS84);

        /*
        * 시군구별 실시간 평균정보 조회
        */
        dustAreaAddrService.setAddressInputCommand(addressInputCommand);

        DustAreaAddr dustAreaAddr = mapper.readValue(dustAreaAddrService.getApiUrl(), DustAreaAddr.class);
        model.addAttribute("dustAreaAddr", dustAreaAddr);

        // areaGradeList : 선택된 도시의 구 전체의 pm10 등급,수치,좌표 리스트
        List<DustArea> listDust = dustAreaAddr.getDustArea();
        List<DustArea> areaGradeList = dustAreaAddrService.dustAreaList(listDust);
        model.addAttribute("areaGradeList", areaGradeList);

        if (! addressInputCommand.getGu().isEmpty()) {
            String guName = addressCommand.getName(addressInputCommand.getGu());
           
            DustArea guNameSelected = dustAreaAddrService.selected(guName, listDust);
            model.addAttribute("guNameSelected", guNameSelected);
        }

        return "test/testKim";
    }

}
