package com.aa.ndchtml5.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearchCriteria {

	private String fromAirport;
	private String toAirport;
	private String passengersNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date returnDate;
	/**
	 * @return the fromAirport
	 */
	public String getFromAirport() {
		return fromAirport;
	}
	/**
	 * @param fromAirport the fromAirport to set
	 */
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}
	/**
	 * @return the toAirport
	 */
	public String getToAirport() {
		return toAirport;
	}
	/**
	 * @param toAirport the toAirport to set
	 */
	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}
	/**
	 * @return the passengersNumber
	 */
	public String getPassengersNumber() {
		return passengersNumber;
	}
	/**
	 * @param passengersNumber the passengersNumber to set
	 */
	public void setPassengersNumber(String passengersNumber) {
		this.passengersNumber = passengersNumber;
	}
	/**
	 * @return the departDate
	 */
	public Date getDepartDate() {
		return departDate;
	}
	/**
	 * @param departDate the departDate to set
	 */
	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}
	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	
}
