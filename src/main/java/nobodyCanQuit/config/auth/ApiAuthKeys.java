package nobodyCanQuit.config.auth;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiAuthKeys {

    private final String ADDRESS_API_SECRET_KEY = "39ab7bf878bc45f3ab98";
    private final String DUST_API_SERVICE_KEY =
            "c1oDP6S4zsHCL0363RXIUgo6hxo3nBtNZrxqfyL7Tz3cM2vTECRegj3MteDb5P93%2FfsMigDzuuh2UCAz1q0M8w%3D%3D";

}
