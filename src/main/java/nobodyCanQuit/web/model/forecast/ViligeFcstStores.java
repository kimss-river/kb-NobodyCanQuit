package nobodyCanQuit.web.model.forecast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ViligeFcstStores {

	@JsonIgnoreProperties("header")
	Response response;


	public List<FcstItem> getFcstItem() {
		try {
			return  response.getBody().getItems().getFsctItems();
		} catch (NullPointerException npe) {
			npe.getStackTrace();
			return null;
		}
	}
		
}

