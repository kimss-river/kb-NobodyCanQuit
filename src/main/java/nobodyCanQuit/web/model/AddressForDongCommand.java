package nobodyCanQuit.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Data
public class AddressForDongCommand extends AddressCommand {
}
