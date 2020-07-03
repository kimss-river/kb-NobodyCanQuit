package nobodyCanQuit.service.forecast;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import lombok.Setter;
import nobodyCanQuit.web.model.viligefcst.FcstItem;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

@Component
public class ForecastData {

	@Setter
	private ViligeFcstStores viligeFcstStores;

	public Map<String, String> getValue(ForecastCategory forecastCategory) {

		Map<String, String> valueMap = new TreeMap<>();
		List<FcstItem> items = viligeFcstStores.getFcstItem();

		for (FcstItem f : items) {
			if (f.getCategory().equals(forecastCategory.toString())) {
				if(f.getCategory().equals(forecastCategory.PTY.toString())) {
					
					String pty = "";
					
					switch (f.getFcstValue()) {
						case "1":
							pty = "비";
							break;
						case "2":
							pty = "비/눈";
							break;
						case "3":
							pty = "눈";
							break;
						case "4":
							pty = "소나기";
							break;
						default:
							pty = "없음";
							break;
					}
					
					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), pty);
					
				} else if(f.getCategory().equals(forecastCategory.SKY.toString())) {
					
					String sky = "";
					
					switch (f.getFcstValue()) {
						case "1":
							sky = "맑음";
							break;
						case "3":
							sky = "구름많음";
							break;
						default:
							sky = "흐림";
							break;
					}
					
					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), sky);
					
				} else if(f.getCategory().equals(forecastCategory.VEC.toString())) {
									
					int vec = Integer.parseInt(f.getFcstValue());
					vec = (int)((vec + 22.5 * 0.5)/22.5);
					
					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), vec+"");
					
				} else {
					
					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), f.getFcstValue());
				
				}
			}
		}
		
		return valueMap;
	
	}
}
