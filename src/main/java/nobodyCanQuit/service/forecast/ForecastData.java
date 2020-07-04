package nobodyCanQuit.service.forecast;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import nobodyCanQuit.web.model.viligefcst.FcstItem;
import nobodyCanQuit.web.model.viligefcst.ViligeFcstStores;

@Component
public class ForecastData {

	@Setter
	private ViligeFcstStores viligeFcstStores;
	@Getter
	private VilageFcstInfoService vilageFcstInfoService;

	public TreeMap<String, String> getValue(ForecastCategory forecastCategory) {

		TreeMap<String, String> valueMap = new TreeMap<>();
		List<FcstItem> items = viligeFcstStores.getFcstItem();

		for (FcstItem f : items) {
			if (f.getCategory().equals(forecastCategory.toString())) {
				if(f.getCategory().equals(ForecastCategory.PTY.toString())) {
					
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
					
				} else if(f.getCategory().equals(ForecastCategory.SKY.toString())) {
					
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
					
				} else if(f.getCategory().equals(ForecastCategory.VEC.toString())) {
									
					int vec = Integer.parseInt(f.getFcstValue());
					vec = (int)((vec + 22.5 * 0.5)/22.5);

					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), String.valueOf(vec));
					
				} else {
					
					valueMap.put(f.getFcstDate() + ":" + f.getFcstTime(), f.getFcstValue());
				
				}
			}
		}
		
		return valueMap;

	}

	public String getRepresentPty() {

		String[] representPty = new String[3];
		int representPtyCnt = 0;

		int rainCnt = 0;
		int snowCnt = 0;
		int showerCnt = 0;
		int rainSnowCnt = 0;
		int noCnt = 0;

		TreeMap<String, String> ptyMap = getValue(ForecastCategory.PTY);
		Iterator<String> ptyKeys = ptyMap.keySet().iterator();
		String oldPtyDate = ptyMap.firstKey().split(":")[0];
		String newPtyDate = "";

		int i = 0;
		while (ptyKeys.hasNext()) {

			String key = ptyKeys.next();
			newPtyDate = key.split(":")[0];

			if (!oldPtyDate.equals(newPtyDate) || !ptyKeys.hasNext()) {

				oldPtyDate = newPtyDate;
				representPtyCnt = 0;
				rainCnt = 0;
				snowCnt = 0;
				showerCnt = 0;
				rainSnowCnt = 0;
				noCnt = 0;
				i++;
			}

			switch (ptyMap.get(key)) {
			case "1":
				rainCnt++;
				if (representPtyCnt < rainCnt) {
					representPty[i] = "1";
					representPtyCnt++;
				}

				break;
			case "2":
				rainSnowCnt++;
				if (representPtyCnt < rainSnowCnt) {
					representPty[i] = "2";
					representPtyCnt++;
				}
				break;
			case "3":
				snowCnt++;
				if (representPtyCnt < snowCnt) {
					representPty[i] = "3";
					representPtyCnt++;
				}
				break;
			case "4":
				showerCnt++;
				if (representPtyCnt < showerCnt) {
					representPty[i] = "4";
					representPtyCnt++;
				}
				break;
			default:
				noCnt++;
				if (representPtyCnt < noCnt) {
					representPty[i] = "아무날도  아님";
					representPtyCnt++;
				}
				break;
			}
		}
		
		return representPty[0] + ":" + representPty[1] + ":" + representPty[2];
	
	}

	public String getRepresentSky() {

		String[] representSky = new String[3];
		int representSkyCnt = 0;

		int sunnyCnt = 0;
		int cloudyCnt = 0;
		int weekCloudyCnt = 0;
		
		TreeMap<String, String> skyMap = getValue(ForecastCategory.SKY);
		Iterator<String> skyKeys = skyMap.keySet().iterator();
		String oldSkyDate = skyMap.firstKey().split(":")[0];
		String newSkyDate = "";

		int i = 0;
		while (skyKeys.hasNext()) {
			
			String key = skyKeys.next();
			newSkyDate = skyMap.get(key).split(":")[0];
			
			if (!oldSkyDate.equals(newSkyDate) || !skyKeys.hasNext()) {

				oldSkyDate = newSkyDate;
				sunnyCnt = 0;
				cloudyCnt = 0;
				weekCloudyCnt = 0;
				i++;
			}
			
			switch (skyMap.get(key)) {
			case "1":
				sunnyCnt++;
				if (representSkyCnt < sunnyCnt) {
					representSky[i] = "1";
				}

				break;
			case "3":
				cloudyCnt++;
				if (representSkyCnt < cloudyCnt) {
					representSky[i] = "3";
				}
				break;
			default:
				if (representSkyCnt < weekCloudyCnt) {
					representSky[i] = "4";
				}
				break;
			}

			
		}

		return representSky[0] + ":" + representSky[1] + ":" + representSky[2];
		
	}

}
