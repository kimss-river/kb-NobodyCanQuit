package nobodyCanQuit.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.AddressApiService;
import nobodyCanQuit.service.VilageFcstInfoService;
import nobodyCanQuit.web.model.AddressCommand;
import nobodyCanQuit.web.model.AddressForDongCommand;
import nobodyCanQuit.web.model.AddressInputCommand;
import nobodyCanQuit.web.model.CityListProvider;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
    private CityListProvider cityListProvider;
    @Autowired
    private AddressApiService addressApiService;
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String main(AddressInputCommand addressInputCommand, Model model) {

        model.addAttribute("cityList", cityListProvider);

        return "index";
    }

    @RequestMapping("/addressSearch.do")
    public String post(AddressInputCommand addressInputCommand, Model model) throws Exception {

        model.addAttribute("cityList", cityListProvider);

        addressApiService.buildApi();
        addressApiService.setAddressInputCommand(addressInputCommand);

        AddressCommand addressCommand =
                mapper.readValue(addressApiService.getAddressLevel2Url(), AddressCommand.class);
        model.addAttribute("addressCommand", addressCommand);

        AddressForDongCommand addressForDongCommand =
                mapper.readValue(addressApiService.getAddressLevel3Url() ,AddressForDongCommand.class);
        model.addAttribute("addressForDongCommand", addressForDongCommand);

        
        VilageFcstInfoService vilageFcstInfoService = new VilageFcstInfoService();
        URL url = vilageFcstInfoService.getApiUrl();
        
        ViligeFcstStores viligeFcstStores = 
        		mapper.readValue(url, ViligeFcstStores.class);
        
       
       
        model.addAttribute("vilage", viligeFcstStores);
        
        return "index";
    }

}
