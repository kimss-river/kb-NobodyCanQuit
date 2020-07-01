package nobodyCanQuit.service.dust;

/*
* 대기오염물질 코드 알람
* SO2 아황산가스
* CO 일산화탄소
* O3 오존
* NO2 이산화질소
* PM10 미세먼지
* PM25 초미세먼지(PM2.5)
* */
public enum DustItemCodes {
    SO2("SO2"),
    CO("CO"),
    O3("O3"),
    NO2("NO2"),
    PM10("PM10"),
    PM25("PM25");

    String code;

    DustItemCodes(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
