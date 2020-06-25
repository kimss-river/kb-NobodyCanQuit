package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("hello", "Hello world! 저 지쳤어요 진짜!!");

        return "main";
    }
}
