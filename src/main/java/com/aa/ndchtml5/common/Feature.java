package com.aa.ndchtml5.common;

public class Feature extends Filter {

	public static Feature Seat_Back_Entertainment = new Feature("Seat Back Entertainment", "/images/seat_back_entertainment.jpg");
	public static Feature Power_Ports = new Feature("PowerPorts", "/images/power_ports.jpg");
	public static Feature Main_Cabin_Seat = new Feature("Main Cabin Seat", "/images/main_ cabin_ seat.jpg");
	public static Feature Pre_Ordered_Meals = new Feature("Pre Ordered Meals", "/images/pre_ ordered_meals.jpg");
	public static Feature Wifi = new Feature("Wifi", "/images/wifi.jpg");
	
	public static final Feature[] featuresList = {Seat_Back_Entertainment,Power_Ports,Main_Cabin_Seat,Pre_Ordered_Meals,Wifi};
	
	public Feature(String code, String value) {
		super(code, value);
	}
	
}
