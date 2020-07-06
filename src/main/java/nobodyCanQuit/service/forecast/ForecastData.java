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

		String[] representPty = new String[4];
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
			case "비":
				rainCnt++;
				if (representPtyCnt < rainCnt) {
					representPty[i] = "비";
					representPtyCnt=rainCnt;
				}

				break;
			case "비/눈":
				rainSnowCnt++;
				if (representPtyCnt < rainSnowCnt) {
					representPty[i] = "비/눈";
					representPtyCnt=rainSnowCnt;
				}
				break;
			case "눈":
				snowCnt++;
				if (representPtyCnt < snowCnt) {
					representPty[i] = "눈";
					representPtyCnt=snowCnt;
				}
				break;
			case "소나기":
				showerCnt++;
				if (representPtyCnt < showerCnt) {
					representPty[i] = "소나기";
					representPtyCnt=showerCnt;
				}
				break;
			default:
				noCnt++;
				if (representPtyCnt < noCnt) {
					representPty[i] = "0";
					representPtyCnt=noCnt;
				}
				break;
			}

			if(rainCnt>0 || showerCnt>0)
				representPty[i] = "비";
			if(snowCnt>0 || rainSnowCnt>0)
				representPty[i] = "눈";
		}

		return representPty[0] + ":" + representPty[1] + ":" + representPty[2]+":"+representPty[3];

	}

	public String getRepresentSky() {

		String[] representSky = new String[4];
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
			newSkyDate = key.split(":")[0];

			if (!oldSkyDate.equals(newSkyDate) || !skyKeys.hasNext()) {

				representSkyCnt = 0;
				oldSkyDate = newSkyDate;
				sunnyCnt = 0;
				cloudyCnt = 0;
				weekCloudyCnt = 0;
				i++;
			}

			switch (skyMap.get(key)) {
			case "맑음":
				sunnyCnt++;
				if (representSkyCnt < sunnyCnt) {
					representSky[i] = "맑음";
					representSkyCnt=sunnyCnt;
				}

				break;
			case "구름많음":
				cloudyCnt++;
				if (representSkyCnt < cloudyCnt) {
					representSky[i] = "구름많음";
					representSkyCnt=cloudyCnt;
				}
				break;

			default:
				weekCloudyCnt++;
				if (representSkyCnt < weekCloudyCnt) {
					representSky[i] = "흐림";
					representSkyCnt=weekCloudyCnt;
				}
				break;
			}
		}

		return representSky[0] + ":" + representSky[1] + ":" + representSky[2]+":"+representSky[3];
		
	}

}
