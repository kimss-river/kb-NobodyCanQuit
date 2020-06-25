package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.web.model.AddressInputCommand;
import nobodyCanQuit.web.model.AddressSearchCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private AddressSearchCommand addressSearchCommand;

    @GetMapping("/")
    public String main(AddressInputCommand addressInputCommand, Model model) {

        model.addAttribute("searchCommand", addressSearchCommand);


        return "index";
    }

    @PostMapping("/")
    public String post(AddressInputCommand addressInputCommand, Model model) {

        model.addAttribute("searchCommand", addressSearchCommand);

        return "index";
    }

}
