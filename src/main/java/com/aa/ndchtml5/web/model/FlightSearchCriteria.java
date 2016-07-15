package com.aa.ndchtml5.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearchCriteria {

	private String fromAirportRoundtrip;
	private String toAirportRoundtrip;
	private String passengersNumberRoundtrip;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departDateRoundtrip;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date returnDateRoundtrip;
	
	public String getFromAirportRoundtrip() {
		return fromAirportRoundtrip;
	}
	public void setFromAirportRoundtrip(String fromAirportRoundtrip) {
		this.fromAirportRoundtrip = fromAirportRoundtrip;
	}
	public String getToAirportRoundtrip() {
		return toAirportRoundtrip;
	}
	public void setToAirportRoundtrip(String toAirportRoundtrip) {
		this.toAirportRoundtrip = toAirportRoundtrip;
	}
	public String getPassengersNumberRoundtrip() {
		return passengersNumberRoundtrip;
	}
	public void setPassengersNumberRoundtrip(String passengersNumberRoundtrip) {
		this.passengersNumberRoundtrip = passengersNumberRoundtrip;
	}
	public Date getDepartDateRoundtrip() {
		return departDateRoundtrip;
	}
	public void setDepartDateRoundtrip(Date departDateRoundtrip) {
		this.departDateRoundtrip = departDateRoundtrip;
	}
	public Date getReturnDateRoundtrip() {
		return returnDateRoundtrip;
	}
	public void setReturnDateRoundtrip(Date returnDateRoundtrip) {
		this.returnDateRoundtrip = returnDateRoundtrip;
	}
	
	
}
