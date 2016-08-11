package com.aa.ndchtml5.common;

public class Stop extends DynamicView {

	public static Stop NONSTOP = new Stop("Nonstop", "Nonstop");
	public static Stop ONE = new Stop("1", "1");
	public static Stop TWO = new Stop("2", "2");
	public static Stop THREE = new Stop("3", "3");

	public static final Stop[] stopsList = { NONSTOP, ONE,TWO,THREE };
	
	public Stop(String code, String value) {
		super(code, value);
	}

}
