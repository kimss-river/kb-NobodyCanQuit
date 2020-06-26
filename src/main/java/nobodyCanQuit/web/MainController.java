package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.AddressApiService;
import nobodyCanQuit.web.model.AddressCommand;
import nobodyCanQuit.web.model.AddressForDongCommand;
import nobodyCanQuit.web.model.AddressInputCommand;
import nobodyCanQuit.web.model.CityListProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private CityListProvider cityListProvider;
    @Autowired
    private AddressApiService apiService;

    @GetMapping("/")
    public String main(AddressInputCommand addressInputCommand, Model model) {

        model.addAttribute("cityList", cityListProvider);

        return "index";
    }

    @PostMapping("/")
    public String post(AddressInputCommand addressInputCommand, Model model) throws Exception {

        model.addAttribute("cityList", cityListProvider);

        apiService.buildApi();
        apiService.setAddressInputCommand(addressInputCommand);

        AddressCommand addressCommand = mapper.readValue(apiService.getAddressLevel2Url(), AddressCommand.class);
        model.addAttribute("addressCommand", addressCommand);

        AddressForDongCommand addressForDongCommand =
                mapper.readValue(apiService.getAddressLevel3Url() ,AddressForDongCommand.class);
        model.addAttribute("addressForDongCommand", addressForDongCommand);

        return "index";
    }

}
