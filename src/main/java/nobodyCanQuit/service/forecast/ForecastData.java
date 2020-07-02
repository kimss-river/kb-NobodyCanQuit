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
				valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), f.getFcstValue());
			}
		}
		return valueMap;
	}
	
}
