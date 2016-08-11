package com.aa.ndchtml5.common;

public class Feature extends DynamicView {

	public static Feature SEAT_BACK_ENTERTAINMENT = new Feature("Seat Back Entertainment",
			"/images/seat_back_entertainment.jpg");
	public static Feature POWER_PORTS = new Feature("PowerPorts", "/images/power_ports.jpg");
	public static Feature MAIN_CABIN_SEAT = new Feature("Main Cabin Seat", "/images/main_cabin_seat.jpg");
	public static Feature PRE_ORDERED_MEALS = new Feature("Pre Ordered Meals", "/images/pre_ordered_meals.jpg");
	public static Feature WIFI = new Feature("Wifi", "/images/wifi.jpg");
	public static Feature ADVANCE_SEAT_SELECTION = new Feature("Advance Seat Selection",
			"/images/advance_seat_selection.jpg");
	public static Feature FREE_GROUP_ONE_BOARDING = new Feature("Free Group1 boarding", "/images/Free_Group1_boarding.jpg");
	public static Feature BAGGAGE_DELIVERY = new Feature("Baggage Delivery", "/images/baggage_delivery.jpg");
	public static Feature UPGRADE_TO_FIRSTCLASS = new Feature("Upgrade To First Class",
			"/images/upgrade_to_first_class.jpg");
	public static Feature DOUBLE_MILES = new Feature("Double Miles", "/images/double_miles.jpg");

	public static final Feature[] featuresList = { SEAT_BACK_ENTERTAINMENT, POWER_PORTS, MAIN_CABIN_SEAT,
			PRE_ORDERED_MEALS, WIFI, ADVANCE_SEAT_SELECTION, FREE_GROUP_ONE_BOARDING, BAGGAGE_DELIVERY,
			UPGRADE_TO_FIRSTCLASS, DOUBLE_MILES };

	public Feature(String code, String value) {
		super(code, value);
	}

}
