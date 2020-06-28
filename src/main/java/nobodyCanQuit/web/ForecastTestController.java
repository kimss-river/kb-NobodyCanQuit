package nobodyCanQuit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.VilageFcstInfoService;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ForecastTestController {

    private final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/test")
    public String weatherForecast(Model model) throws Exception {

        VilageFcstInfoService vilageFcstInfoService = new VilageFcstInfoService();
        URL url = vilageFcstInfoService.getApiUrl();

        ViligeFcstStores viligeFcstStores =
                mapper.readValue(url, ViligeFcstStores.class);

        model.addAttribute("vilage", viligeFcstStores);

        return "test/test";
    }

}
