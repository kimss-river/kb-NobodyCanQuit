package nobodyCanQuit.web.model.viligefcst;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ViligeFcstStores {

	@JsonIgnoreProperties("header")
	Response response;

	
	public List<FcstItem> getFcstItem() {
				
		return  response.getBody().getItems().getFsctItems();
	}
		
}

