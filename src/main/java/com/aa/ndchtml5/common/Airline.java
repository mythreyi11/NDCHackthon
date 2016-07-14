package com.aa.ndchtml5.common;

public class Airline extends Filter {

	public static Airline American = new Airline("American Airlines", "American Airlines");
	public static Airline British = new Airline("British Airways", "British Airways");
	public static Airline Other = new Airline("Other", "Other");

	public static final Airline[] airlineList = { American, British, Other };

	public Airline(String code, String value) {
		super(code, value);
	} 

}
