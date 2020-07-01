package nobodyCanQuit.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import nobodyCanQuit.service.dust.DustAreaAddrService;
import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.web.model.address.AddressInputCommand;

@Controller
public class MainController {
	
    private final ObjectMapper mapper = new ObjectMapper();
	@Autowired
    private CityListService cityListService;
    @Autowired
    private AddressApiService addressApiService;
    @Autowired
    private DustAreaAddrService dustAreaAddrService;

    @GetMapping("/")
    public String indexget(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);

        addressApiService.buildApi();

        return "index";
    }
    
    @PostMapping("/")
    public String indexpost(AddressInputCommand addressInputCommand, Model model) throws Exception {

        /*
        * 계층별 주소검색
        */
        model.addAttribute("cityList", cityListService);

        addressApiService.buildApi();
        addressApiService.setAddressInputCommand(addressInputCommand);

        return "index";
    }

}
