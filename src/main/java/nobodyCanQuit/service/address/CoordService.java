package nobodyCanQuit.service.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import nobodyCanQuit.service.SGIS.AccessTokenProvider;
import nobodyCanQuit.service.SGIS.ApiProviderBySGIS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public  class CoordService implements ApiProviderBySGIS {

    private static final String COORD_API = "https://sgisapi.kostat.go.kr/OpenAPI3/transformation/transcoord.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private String BUILDED_API;
    @Autowired
    private AccessTokenProvider accessTokenProvider;

    public <T extends Coordinates> T convert(
            T target, T destination,  CoordSystem targetSys, CoordSystem dstSys) throws IOException {

        ConvertedCoord convertedCoord = getConvertedCoord(target.getX(), target.getY(), targetSys, dstSys);
        destination.setNewX(convertedCoord.getX());
        destination.setNewY(convertedCoord.getY());

        return destination;
    }

    public <T extends Coordinates> List<T> convert(
            List<T> target, List<T> destination, CoordSystem targetSys, CoordSystem dstSys) throws IOException {

        ConvertedCoord convertedCoord;
        int i = 0;
        for (T t: target) {
            convertedCoord = getConvertedCoord(t.getX(), t.getY(), targetSys, targetSys);
            destination.get(i).setNewX(convertedCoord.getX());
            destination.get(i).setNewY(convertedCoord.getY());
            i++;
        }

        return destination;
    }

    private ConvertedCoord getConvertedCoord(String x, String y, CoordSystem source, CoordSystem destination)
            throws IOException {

        StringBuilder builder = new StringBuilder(COORD_API);
        builder.append("&src=").append(source)
                .append("&dst=").append(destination)
                .append("&posX=").append(x)
                .append("&posY=").append(y);

        return mapper.readValue(new URL(builder.toString()), ConvertedCoord.class);
    }

    public enum CoordSystem {

        UTM("5179"),
        WGS84("4326"),
        BESSEL("4004"),
        GRS80("4019");

        String code;

        CoordSystem(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code.toString();
        }
    }

    @Override
    public void getSGIStoken() throws IOException {
        BUILDED_API = COORD_API + "?accessToken=" + accessTokenProvider.getAccessToken();
    }
}
