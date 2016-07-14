package com.aa.ndchtml5.common;

public class PurchaseFeature extends Filter {

	public static PurchaseFeature Advance_Seat_Selection = new PurchaseFeature("Advance Seat Selection", "Advance Seat Selection");
	public static PurchaseFeature Pre_Ordered_Meals = new PurchaseFeature("Pre Ordered Meals", "Pre Ordered Meals");
	public static PurchaseFeature Wifi = new PurchaseFeature("Wifi", "Wifi");
	public static PurchaseFeature Extra_Miles = new PurchaseFeature("Extra Miles", "Extra Miles");
	public static PurchaseFeature Checked_Bags = new PurchaseFeature("Checked Bags", "Checked Bags");
	public static PurchaseFeature Baggage_delivery = new PurchaseFeature("Baggage delivery", "Baggage delivery");
	public static PurchaseFeature Mileage_Multiplier = new PurchaseFeature("Mileage Multiplier", "Mileage Multiplier");
	public static PurchaseFeature Upgrade_to_First_Class = new PurchaseFeature("Upgrade to First Class", "Upgrade to First Class");
	
	public static final PurchaseFeature[] purchaseFeatureList = {Advance_Seat_Selection,Pre_Ordered_Meals,Wifi,Extra_Miles,Checked_Bags,
			Baggage_delivery,Mileage_Multiplier,Upgrade_to_First_Class};
	
	public PurchaseFeature(String code, String value) {
		super(code, value);
	}
}
