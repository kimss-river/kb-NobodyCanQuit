package nobodyCanQuit.web.model.dust;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
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

@Setter
@Getter
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
	private String x;
	private String y;

	@Override
	public String getX() {
		return x;
	}

	@Override
	public String getY() {
		return y;
	}

	@Override
	public void setNewX(String newX) {
		this.x = newX;
	}

	@Override
	public void setNewY(String newY) {
		this.y = newY;
	}

	@Override
	public int hashCode() {
		return cityName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DustArea) {
			return this.cityName.equals(String.valueOf(((DustArea) obj).getCityName()));
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.cityName;
	}
}
