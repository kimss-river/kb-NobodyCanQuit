package nobodyCanQuit.service.address;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CityListService {

    private final Map<String, String> cityMap;
    @Getter
    private final List<String> cityName;

    public CityListService() {
        this.cityMap = new HashMap<>();
        initCityList();
        this.cityName = new ArrayList<>(cityMap.keySet());
    }

    private void initCityList() {
        cityMap.put("서울특별시", "11");
        cityMap.put("부산광역시", "21");
        cityMap.put("대구광역시", "22");
        cityMap.put("인천광역시", "23");
        cityMap.put("광주광역시", "24");
        cityMap.put("대전광역시", "25");
        cityMap.put("울산광역시", "26");
        cityMap.put("세종특별자치시", "29");
        cityMap.put("경기도", "31");
        cityMap.put("강원도", "32");
        cityMap.put("충청북도", "33");
        cityMap.put("충청남도", "34");
        cityMap.put("전라북도", "35");
        cityMap.put("전라남도", "36");
        cityMap.put("경상북도", "37");
        cityMap.put("경상남도", "38");
        cityMap.put("제주특별자치도", "39");
    }

    public String getCityCode(String cityName) {
        return cityMap.get(cityName);
    }

    public String getShortName(String cityName) {

        int code = Integer.parseInt(getCityCode(cityName));
        StringBuilder stringBuilder = new StringBuilder(cityName);

        if (code >= 33 && code <= 38) {
            return stringBuilder.deleteCharAt(1).deleteCharAt(2).toString();
        }

        return stringBuilder.substring(0,2);
    }
}
