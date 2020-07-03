package nobodyCanQuit.service.forecast;

public enum ForecastCategory {
	
	//강수확률(%)
    POP("POP"),
    //강수형태(0-없음, 1-비, 2-비/눈, 3-눈, 4-소나기)
    PTY("PTY"),
    //6시간 강수량(mm)
    R06("R06"),
    //3시간 기온(℃)
    TH3("TH3"),
    //최저기온(발표시각 0200)
    TMN("TMN"),
    //최고기온(발표시각 1100)
    TMX("TMX"),
    //하늘상태(1-맑음, 3-구름많음, 4-흐림)
    SKY("SKY"),
    //풍향(16방위 NESW (풍속+22.5*0.5)/22.5)
    //0-N, 1-NNE, 2-NE, 3-ENE, 4-E, 5-ESE, 6-SE, 7-SSE, 8-S, 9-SSW, 10-SW, 11-WSW, 12-W, 13-WNW, 14-NW, 15-NNW, 16-N
    VEC("VEC"),
    //풍속(m/s)
    WSD("WSD");

    String category;

    ForecastCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}

