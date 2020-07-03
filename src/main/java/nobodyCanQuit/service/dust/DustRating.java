package nobodyCanQuit.service.dust;

public enum DustRating {
	SO2(new double[]{0.03,0.06,2}),
    CO(new double[]{2,9,15}),
    O3(new double[]{0.030,0.090,0.150}),
    NO2(new double[]{0.02,0.05,15}),
    PM10(new double[]{30,80,150}),
    PM25(new double[]{15,35,75});
	
	double[] d;
	
	DustRating(double[] d){
		this.d = d;
	}

}
