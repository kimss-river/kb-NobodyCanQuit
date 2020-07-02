package nobodyCanQuit.service.forecast;

// TODO 각 코드가 무엇을 의미하는지 설명추가
public enum ForecastCategory {

    POP("POP"),
    PTY("PTY"),
    R06("R06"),
    TH3("TH3"),
    TMN("TMN"),
    TMX("TMX"),
    SKY("SKY"),
    VEC("VEC"),
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

