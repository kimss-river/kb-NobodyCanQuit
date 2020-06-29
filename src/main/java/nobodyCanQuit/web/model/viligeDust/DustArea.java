package nobodyCanQuit.web.model.viligeDust;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties({"_returnType",
    "cityNameEng",
    "coValue",
    "dataGubun",
    "dataTime",
    "districtCode",
    "districtNumSeq",
    "itemCode",
    "khaiValue",
    "no2Value",
    "numOfRows",
    "o3Value",
    "pageNo",
    "pm25Value",
    "resultCode",
    "resultMsg",
    "searchCondition",
    "serviceKey",
    "so2Value",
    "totalCount"})
@Data
public class DustArea {
	 @JsonProperty("cityName")
	 private String cityName;
	 @JsonProperty("sidoName")
	 private String sidoName;
	 @JsonProperty("pm10Value")
	 private String pm10Value;
}
