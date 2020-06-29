package nobodyCanQuit.config.auth;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiAuthKeys {

    private final String ADDRESS_API_SECRET_KEY = "39ab7bf878bc45f3ab98";
    private final String DUST_API_SERVICE_KEY =
            "AFt3TjNEJq7jb0QYqGCXr2rMOb4LS%2F11Mv2HqbaHQNsJkT2McS8dfggWVOeac%2FGJFEQRokOtJaEmZSeZKKvqGQ%3D%3D";

}
