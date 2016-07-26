package com.aa.ndchtml5.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aa.ndchtml5.common.Stop;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.web.model.OfferDetails;

public class ConvertDataToView {
	
	/**
	 * @param offers
	 * @return
	 */
	public static ArrayList<OfferDetails> getOfferListToShow(List<Offer> offers , List<OfferDetails> availableOfferDetails) {
		
		ArrayList<OfferDetails> offerDetailsList = new ArrayList<OfferDetails>();
		if (availableOfferDetails.isEmpty()) {
			for (Offer offer : offers) {
				offerDetailsList.add(getOfferDetails(offer));
			}
		}
		else {
			for (Offer offer : offers) {
				for (OfferDetails offerDetails : availableOfferDetails) {
					if (!offer.getOfferId().equalsIgnoreCase(offerDetails.getOfferId())) {
						offerDetailsList.add(getOfferDetails(offer));
					}
				}
			}
		}
		
		return offerDetailsList; 
	}
	
	/**
	 * @param offer
	 * @return
	 */
	public static OfferDetails getOfferDetails(Offer offer) {
		if (offer == null) {
			return null;
		}
		OfferDetails offerDetails = new OfferDetails();
		
		offerDetails.setOfferId(offer.getOfferId());
		offerDetails.setOfferExpiryDate(populateExpiryDate(offer.getOfferExpiryTime()));
		offerDetails.setFlightDetails(getFlightDetails(offer));
		offerDetails.setFare("$" + offer.getPrice().getTotal());
		offerDetails.setIncludeFeatures(offer.getIncludedFeatures().getFeature());
		offerDetails.setPurchaseFeautues(offer.getForPurchaseFeatures().getFeature());
		return offerDetails;
	}

	private static String getFlightDetails(Offer offer) {
		String stops = getStopDetails(offer.getSliceDetail().getNumberOfSegments().intValue());
		String flightDetails = stops + " " + offer.getSliceDetail().getOrigin() + "-" +  offer.getSliceDetail().getDestination();
		return flightDetails;
	}
	
	private static String getStopDetails(int stops) {
		switch (stops) {
		case 0:
			return Stop.NONSTOP.getValue();
		case 1:
			return Stop.ONE_PLUS.getValue();
		case 2:
			return Stop.TWO_PLUS.getValue();
		default:
			return null;
		}
		
	}
	
	private static String populateExpiryDate(String dateStr) {
		if (dateStr == null)
			return null;
		dateStr = dateStr.replace('T', ' ');
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat stringFormatter = new SimpleDateFormat("dd MMM yyyy HH:mm");
		String formattedStr = dateStr; 
		Date date;
		try {
			date = (Date)dateFormatter.parse(dateStr);
			formattedStr = (String)stringFormatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedStr = "(Expires " +formattedStr+")";
		return formattedStr;
	}
}
