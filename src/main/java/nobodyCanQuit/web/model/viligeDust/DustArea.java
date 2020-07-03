package nobodyCanQuit.web.model.viligeDust;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import nobodyCanQuit.service.address.Coordinates;

@JsonIgnoreProperties({"_returnType",
	"cityNameEng",
    "dataGubun",
    "dataTime",
    "districtCode",
    "districtNumSeq",
    "itemCode",
    "khaiValue",
    "numOfRows",
    "pageNo",
    "resultCode",
    "resultMsg",
    "searchCondition",
    "serviceKey",
    "totalCount"})
@Data
public class DustArea implements Coordinates {
	//지역
	@JsonProperty("cityName")
	private String cityName;
	//구
	@JsonProperty("sidoName")
	private String sidoName;
	//미세먼지 평균농도
	@JsonProperty("pm10Value")
	private String pm10Value;
	//초미세먼지 평균농도
	@JsonProperty("pm25Value")
	private String pm25Value;
	//아황산가스 평균농도
	@JsonProperty("so2Value")
	private String so2Value;
//	일산화탄소 평균농도
	@JsonProperty("coValue")
	private String coValue;
//	오존 평균농도
	@JsonProperty("o3Value")
	private String o3Value;
//	이산화질소 평균농도
	@JsonProperty("no2Value")
	private String no2Value;
//	등급
	private String pm10Grade;
	private String pm25Grade;
	private String so2Grade;
	private String coGrade;
	private String o3Grade;
	private String no2Grade;
//  좌표
	private String xCoord;
	private String yCoord;

	@Override
	public String getX() {
		return xCoord;
	}

	@Override
	public String getY() {
		return yCoord;
	}

	@Override
	public void setNewX(String newX) {
		this.xCoord = newX;
	}

	@Override
	public void setNewY(String newY) {
		this.yCoord = newY;
	}
}
