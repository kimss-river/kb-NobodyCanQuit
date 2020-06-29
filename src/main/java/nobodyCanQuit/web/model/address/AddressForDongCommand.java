package nobodyCanQuit.web.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"id", "errMsg", "errCd", "trId"})
@Data
public class AddressForDongCommand extends AddressCommand {
}
