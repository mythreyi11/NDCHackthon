package com.aa.ndchtml5.web.model;

import java.util.List;

public class OfferDetails {
	
	private String offerId;
	private String flightDetails;
	private String fare;
	private List<String> includeFeatures;
	private List<String> purchaseFeautues;
	private String offerExpiryDate;
	
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(String flightDetails) {
		this.flightDetails = flightDetails;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public List<String> getIncludeFeatures() {
		return includeFeatures;
	}
	public void setIncludeFeatures(List<String> includeFeatures) {
		this.includeFeatures = includeFeatures;
	}
	public List<String> getPurchaseFeautues() {
		return purchaseFeautues;
	}
	public void setPurchaseFeautues(List<String> purchaseFeautues) {
		this.purchaseFeautues = purchaseFeautues;
	}
	public String getOfferExpiryDate() {
		return offerExpiryDate;
	}
	public void setOfferExpiryDate(String offerExpiryDate) {
		this.offerExpiryDate = offerExpiryDate;
	}
	
	
}
