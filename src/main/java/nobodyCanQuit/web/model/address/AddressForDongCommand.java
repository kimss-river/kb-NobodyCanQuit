package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Getter
@Setter
public class AddressForDongCommand extends AddressCommand {
}
