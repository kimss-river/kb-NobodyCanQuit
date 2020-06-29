package nobodyCanQuit.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class DustAreaAddrService implements ApiUrlProvider {
	private static String serviceKey = "serviceKey=AFt3TjNEJq7jb0QYqGCXr2rMOb4LS%2F11Mv2HqbaHQNsJkT2McS8dfggWVOeac%2FGJFEQRokOtJaEmZSeZKKvqGQ%3D%3D";
	private static final String Finedust_Abbr = 
			"http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?"
			+ serviceKey+"&numOfRows=25&pageNo=1";
	
	@Override
    public URL getApiUrl() throws IOException {
		StringBuilder address = new StringBuilder();
		//addressCommand.setSidoName("서울");
			String encodeAddress =	URLEncoder.encode("서울","utf-8");
        return new URL(Finedust_Abbr + "&sidoName=" + encodeAddress + "&searchCondition=DAILY&_returnType=json");
	}
}
