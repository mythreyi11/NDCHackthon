package com.aa.ndchtml5.common;

public class Stop extends DynamicView {

	public static Stop NONSTOP = new Stop("Nonstop", "Nonstop");
	public static Stop ONE_PLUS = new Stop("1+", "1+");
	public static Stop TWO_PLUS = new Stop("2+", "2+");

	public static final Stop[] stopsList = { NONSTOP, ONE_PLUS,TWO_PLUS };
	
	public Stop(String code, String value) {
		super(code, value);
	}

}
