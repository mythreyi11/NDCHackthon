package com.aa.ndchtml5.common;

public class Feature extends DynamicView {

	public static Feature SEAT_BACK_ENTERTAINMENT = new Feature("Seat Back Entertainment", "/images/seat_back_entertainment.jpg");
	public static Feature POWER_PORTS = new Feature("PowerPorts", "/images/power_ports.jpg");
	public static Feature MAIN_CABIN_SEAT = new Feature("Main Cabin Seat", "/images/main_cabin_seat.jpg");
	public static Feature PRE_ORDERED_MEALS = new Feature("Pre Ordered Meals", "/images/pre_ordered_meals.jpg");
	public static Feature WIFI = new Feature("Wifi", "/images/wifi.jpg");
	public static Feature ADVANCED_SEAT_SELECTION = new Feature("Advanced Seat Selection", "/images/advanced_seat_selection.jpg");
	public static Feature GROUP_ONE_BOARDING = new Feature("Group one boarding", "/images/group_one_boarding.jpg");
	
	
	public static final Feature[] featuresList = {SEAT_BACK_ENTERTAINMENT,POWER_PORTS,MAIN_CABIN_SEAT,PRE_ORDERED_MEALS,WIFI,ADVANCED_SEAT_SELECTION, GROUP_ONE_BOARDING};
	
	public Feature(String code, String value) {
		super(code, value);
	}
	
}
