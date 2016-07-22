package com.aa.ndchtml5.common;

public class Feature extends DynamicView {

	public static Feature SEAT_BACK_ENTERTAINMENT = new Feature("Seat Back Entertainment", "/images/seat_back_entertainment.gif");
	public static Feature POWER_PORTS = new Feature("PowerPorts", "/images/power_ports.gif");
	public static Feature MAIN_CABIN_SEAT = new Feature("Main Cabin Seat", "/images/main_cabin_seat.gif");
	public static Feature PRE_ORDERED_MEALS = new Feature("Pre Ordered Meals", "/images/pre_ordered_meals.gif");
	public static Feature WIFI = new Feature("Wifi", "/images/wifi.gif");
	
	public static final Feature[] featuresList = {SEAT_BACK_ENTERTAINMENT,POWER_PORTS,MAIN_CABIN_SEAT,PRE_ORDERED_MEALS,WIFI};
	
	public Feature(String code, String value) {
		super(code, value);
	}
	
}
