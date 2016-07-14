package com.aa.ndchtml5.common;

public class IncludedFeature extends Filter {

	public static IncludedFeature Seat_Back_Entertainment = new IncludedFeature("Seat Back Entertainment", "Seat Back Entertainment");
	public static IncludedFeature Power_Ports = new IncludedFeature("PowerPorts", "PowerPorts");
	public static IncludedFeature Double_Miles = new IncludedFeature("Double Miles", "Double Miles");
	public static IncludedFeature Free_Luggauge_Delivery = new IncludedFeature("Free Luggauge Delivery", "Free Luggauge Delivery");
	public static IncludedFeature One_Free_check_bag = new IncludedFeature("One Free check bag", "One Free check bag");
	public static IncludedFeature Free_Wifi = new IncludedFeature("Free Wifi", "Free Wifi");
	public static IncludedFeature Main_Cabin_Seat = new IncludedFeature("Main Cabin Seat", "Main Cabin Seat");
	public static IncludedFeature Admirals_Club_Access = new IncludedFeature("Admirals Club Access", "Admirals Club Access");
	public static IncludedFeature Free_Group1_boarding = new IncludedFeature("Free Group1 boarding", "Free Group1 boarding");
	public static IncludedFeature Free_Admirals_club_Access = new IncludedFeature("Free Admirals club Access", "Free Admirals club Access");
	public static IncludedFeature Option_to_choose_Exit_Row = new IncludedFeature("Option to choose Exit Row", "Option to choose Exit Row");

	public static final IncludedFeature[] includedFeatureList = {Seat_Back_Entertainment,Power_Ports,Double_Miles,Free_Luggauge_Delivery,
			One_Free_check_bag,Free_Wifi,Main_Cabin_Seat,Admirals_Club_Access,Free_Group1_boarding,Free_Admirals_club_Access,Option_to_choose_Exit_Row};
	
	public IncludedFeature(String code, String value) {
		super(code, value);
	}
}
