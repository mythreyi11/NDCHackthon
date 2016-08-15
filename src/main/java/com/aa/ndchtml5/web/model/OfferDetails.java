package com.aa.ndchtml5.web.model;

import java.util.List;

import com.aa.ndchtml5.common.Feature;
import com.aa.ndchtml5.domain.Offers.Offer.FareRules;
import com.aa.ndchtml5.domain.Offers.Offer.Price;
import com.aa.ndchtml5.domain.Offers.Offer.SegmentDetail;

public class OfferDetails {
	
	private String offerId;
	private String flightDetails;
	private String fare;
	private List<String> includeFeatures;
	private List<String> purchaseFeautues;
	private String offerExpiryDate;
	private FareRules fareRules;
	private Price price;
	private List<Feature> inclTotalFeatures;
	private List<Feature> purTotalFeatures;
	private int noOfSegments;
	private List<SegmentDetail> segmentDetailList;
	
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
	/**
	 * @return the fareRules
	 */
	public FareRules getFareRules() {
		return fareRules;
	}
	/**
	 * @param fareRules the fareRules to set
	 */
	public void setFareRules(FareRules fareRules) {
		this.fareRules = fareRules;
	}
	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	public List<Feature> getInclTotalFeatures() {
		return inclTotalFeatures;
	}
	public void setInclTotalFeatures(List<Feature> inclTotalFeatures) {
		this.inclTotalFeatures = inclTotalFeatures;
	}
	public List<Feature> getPurTotalFeatures() {
		return purTotalFeatures;
	}
	public void setPurTotalFeautues(List<Feature> purTotalFeatures) {
		this.purTotalFeatures = purTotalFeatures;
	}

/**
	 * @return the noOfSegments
	 */
	public int getNoOfSegments() {
		return noOfSegments;
	}
	/**
	 * @param noOfSegments the noOfSegments to set
	 */
	public void setNoOfSegments(int noOfSegments) {
		this.noOfSegments = noOfSegments;
	}
	/**
	 * @return the segmentDetailList
	 */
	public List<SegmentDetail> getSegmentDetailList() {
		return segmentDetailList;
	}
	/**
	 * @param segmentDetailList the segmentDetailList to set
	 */
	public void setSegmentDetailList(List<SegmentDetail> segmentDetailList) {
		this.segmentDetailList = segmentDetailList;
	}
	
	
}
