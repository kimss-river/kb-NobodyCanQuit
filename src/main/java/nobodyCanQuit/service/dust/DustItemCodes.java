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
    SO2("SO2", new double[]{0.03,0.06,2}),
    CO("CO", new double[]{2,9,15}),
    O3("O3", new double[]{0.030,0.090,0.150}),
    NO2("NO2", new double[]{0.02,0.05,15}),
    PM10("PM10", new double[]{30,80,150}),
    PM25("PM25", new double[]{15,35,75});

    String code;
    double[] rating;

    DustItemCodes(String code, double[] rating) {
        this.code = code;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.code;
    }

    public double[] getRating() {
        return rating;
    }
}
