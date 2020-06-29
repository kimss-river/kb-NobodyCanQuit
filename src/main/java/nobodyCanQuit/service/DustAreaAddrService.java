package nobodyCanQuit.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import lombok.Setter;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DustAreaAddrService implements ApiUrlProvider {

	private static String serviceKey = "AFt3TjNEJq7jb0QYqGCXr2rMOb4LS%2F11Mv2HqbaHQNsJkT2McS8dfggWVOeac%2FGJFEQRokOtJaEmZSeZKKvqGQ%3D%3D";
	private static final String Finedust_Abbr = 
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?serviceKey="
			+ serviceKey+"&numOfRows=25&pageNo=1";
	@Setter
	private AddressInputCommand addressInputCommand;
	@Autowired
	CityListProvider cityListProvider;
	
	@Override
    public URL getApiUrl() throws IOException {
		
		String chosenCity = cityListProvider.getShortName(addressInputCommand.getCity());
		String encodeAddress = URLEncoder.encode(chosenCity,"utf-8");
		
        return new URL(Finedust_Abbr + "&sidoName=" + encodeAddress + "&searchCondition=DAILY&_returnType=json");
	}

	public URL getDustAttemptUrl() throws MalformedURLException {

		return new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey=AFt3TjNEJq7jb0QYqGCXr2rMOb4LS%2F11Mv2HqbaHQNsJkT2McS8dfggWVOeac%2FGJFEQRokOtJaEmZSeZKKvqGQ%3D%3D&numOfRows=10&pageNo=1&itemCode=PM10&dataGubun=HOUR&searchCondition=MONTH&_returnType=json");
	}
}
