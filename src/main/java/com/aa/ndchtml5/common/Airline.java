package com.aa.ndchtml5.common;

public class Airline extends DynamicView {

	public static Airline AMERICAN = new Airline("AA", "American Airlines");
	public static Airline BRITISH = new Airline("BA", "British Airways");
	public static Airline OTHER = new Airline("OA", "Other");

	public static final Airline[] airlineList = { AMERICAN, BRITISH, OTHER };

	public Airline(String code, String value) {
		super(code, value);
	} 

}
