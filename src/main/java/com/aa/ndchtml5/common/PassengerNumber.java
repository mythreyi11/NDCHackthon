package com.aa.ndchtml5.common;

public class PassengerNumber extends DynamicView {

	public static PassengerNumber ONE = new PassengerNumber("1", "1");
	public static PassengerNumber TWO = new PassengerNumber("2", "2");
	public static PassengerNumber THREE = new PassengerNumber("3", "3");
	public static PassengerNumber FOUR = new PassengerNumber("4", "4");
	public static PassengerNumber FIVE = new PassengerNumber("5", "5");
	public static PassengerNumber SIX = new PassengerNumber("6", "6");

	public static final PassengerNumber[] passengerNumberList = { ONE, TWO, THREE, FOUR, FIVE, SIX };

	public PassengerNumber(String code, String value) {
		super(code, value);
	} 
}
