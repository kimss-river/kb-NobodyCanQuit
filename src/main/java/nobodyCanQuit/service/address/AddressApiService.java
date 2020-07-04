package nobodyCanQuit.service.address;

import lombok.Getter;
import lombok.Setter;
import nobodyCanQuit.service.SGIS.AccessTokenProvider;
import nobodyCanQuit.service.SGIS.ApiProviderBySGIS;
import nobodyCanQuit.web.model.address.AddressInputCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class AddressApiService implements ApiProviderBySGIS {

    private static final String ADDRESS_API = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
    @Autowired
    private CityListService cityListService;
    @Autowired
    private AccessTokenProvider accessTokenProvider;
    @Setter
    private AddressInputCommand addressInputCommand;
    private String BUILDED_API;
    private String city = "1";
    @Getter
    private String guStatus;


    public URL getAddressLevel2Url() throws IOException {

        StringBuilder stringBuilder = new StringBuilder(BUILDED_API);

        if (! addressInputCommand.getCity().equals(city)) {
            city = addressInputCommand.getCity();
            guStatus = "reset";
        } else {
            guStatus = "reload";
        }

        stringBuilder.append("&cd=").append(cityListService.getCityCode(city));

        return new URL(stringBuilder.toString());
    }

    public URL getAddressLevel3Url() throws IOException {

        StringBuilder stringBuilder = new StringBuilder(BUILDED_API);

        if (guStatus.equals("reset")) {
            return new URL(stringBuilder.append("&cd=1").toString());
        }

        if (! addressInputCommand.getGu().isEmpty() && guStatus.equals("reload")) {
            stringBuilder.append("&cd=").append(addressInputCommand.getGu());
            return new URL(stringBuilder.toString());
        }

        return new URL(stringBuilder.append("&cd=1").toString());
    }

    @Override
    public void getSGIStoken() throws IOException {
        BUILDED_API = ADDRESS_API + "?accessToken=" + accessTokenProvider.getAccessToken();
    }
}