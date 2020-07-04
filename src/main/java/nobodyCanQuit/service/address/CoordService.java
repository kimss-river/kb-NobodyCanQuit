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

    public <T extends Coordinates> T convert(T target, CoordSystem targetSys, CoordSystem dstSys) throws IOException {
        getSGIStoken();
        ConvertedCoord convertedCoord = getConvertedCoord(target.getX(), target.getY(), targetSys, dstSys);
        target.setNewX(convertedCoord.getX());
        target.setNewY(convertedCoord.getY());

        return target;
    }

    public <T extends Coordinates, V extends Coordinates> V convert(
            T target, V destination,  CoordSystem targetSys, CoordSystem dstSys) throws IOException {
        getSGIStoken();
        ConvertedCoord convertedCoord = getConvertedCoord(target.getX(), target.getY(), targetSys, dstSys);
        destination.setNewX(convertedCoord.getX());
        destination.setNewY(convertedCoord.getY());

        return destination;
    }


    public <T extends Coordinates> List<T> convert(List<T> target, CoordSystem targetSys, CoordSystem dstSys)
            throws IOException {
        getSGIStoken();
        ConvertedCoord convertedCoord;
        for (T t: target) {
            convertedCoord = getConvertedCoord(t.getX(), t.getY(), targetSys, dstSys);
            t.setNewX(convertedCoord.getX());
            t.setNewY(convertedCoord.getY());
        }

        return target;
    }

    public <T extends Coordinates, V extends Coordinates> List<V> convert(
            List<T> target, List<V> destination, CoordSystem targetSys, CoordSystem dstSys) throws IOException {
        getSGIStoken();
        ConvertedCoord convertedCoord;
        int i = 0;
        for (V t: destination) {
            convertedCoord = getConvertedCoord(target.get(i).getX(), target.get(i).getY(), targetSys, dstSys);
            t.setNewX(convertedCoord.getX());
            t.setNewY(convertedCoord.getY());
            i++;
        }
        return destination;
    }

    private ConvertedCoord getConvertedCoord(String x, String y, CoordSystem source, CoordSystem destination)
            throws IOException {
        getSGIStoken();
        StringBuilder builder = new StringBuilder(BUILDED_API);
        builder.append("&src=").append(source.toString())
                .append("&dst=").append(destination.toString())
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
