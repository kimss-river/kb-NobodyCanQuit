package nobodyCanQuit.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import lombok.Setter;
import nobodyCanQuit.config.auth.ApiAuthKeys;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DustAreaAddrService implements ApiUrlProvider {

	@Autowired
	private ApiAuthKeys apiAuthKeys;
	@Autowired
	CityListService cityListService;
	@Setter
	private AddressInputCommand addressInputCommand;
	private static final String Finedust_Abbr =
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?_returnType=json";

	@Override
    public URL getApiUrl() throws IOException {

		final String numOfRows = "25";
		final String pageNo = "1";
		final String searchCondition = "DAILY";
		final String serviceKey = apiAuthKeys.getDUST_API_SERVICE_KEY();
		String chosenCity = cityListService.getShortName(addressInputCommand.getCity());
		String encodeAddress = URLEncoder.encode(chosenCity,"utf-8");

		StringBuilder stringBuilder = new StringBuilder(Finedust_Abbr);
		stringBuilder.append("&numOfRows=").append(numOfRows)
				.append("&pageNo=").append(pageNo)
				.append("&searchCondition=").append(searchCondition)
				.append("&serviceKey=").append(serviceKey)
				.append("&sidoName=").append(encodeAddress);

        return new URL(stringBuilder.toString());
	}

	public URL getDustAttemptUrl() throws MalformedURLException {

		final String serviceKey = apiAuthKeys.getDUST_API_SERVICE_KEY();

		return new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey=" +
				serviceKey +
				"&numOfRows=10&pageNo=1&itemCode=PM10&dataGubun=HOUR&searchCondition=MONTH&_returnType=json");
	}
}
