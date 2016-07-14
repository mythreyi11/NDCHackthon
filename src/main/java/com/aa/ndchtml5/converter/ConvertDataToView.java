package com.aa.ndchtml5.converter;

import java.util.ArrayList;
import java.util.List;

import com.aa.ndchtml5.common.Stop;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.web.model.OfferDetails;
import com.aa.ndchtml5.web.model.OfferList;

public class ConvertDataToView {
	
	/**
	 * @param offers
	 * @return
	 */
	public static OfferList getOfferListToShow(List<Offer> offers) {
		
		OfferList offerList = new OfferList();
		List<OfferDetails> offerDetailsList = new ArrayList<OfferDetails>();
		for (Offer offer : offers) { 
			offerDetailsList.add(getOfferDetails(offer));
		}
		offerList.setOfferDetailsList(offerDetailsList);
		return offerList;
	}
	
	public static OfferDetails getOfferDetails(Offer offer) {
		if (offer == null) {
			return null;
		}
		OfferDetails offerDetails = new OfferDetails();
		
		offerDetails.setOfferId(offer.getOfferId());
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
}
