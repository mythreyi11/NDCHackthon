package com.aa.ndchtml5.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.domain.Offers.Offer.SliceDetail;
import com.aa.ndchtml5.web.model.FlightSearchCriteria;

public class CommonService {
	
	public static List<Offer> findByFeature(List<String> selectedfeatures,
			List<Offer> offers) {
		List<Offer> resultToShow = new ArrayList<Offer>();
		boolean featurePresentInoffer = false;
			for (Offer offer : offers) {
				for (String selectedFeature : selectedfeatures) {
					List<String> featuresInOffer = offer.getIncludedFeatures().getFeature();
					if (isSelectedPresentInOffer(selectedFeature, featuresInOffer)) {
						 featurePresentInoffer = true;
					} else {
						 featurePresentInoffer = false;
				}
			}
				if (featurePresentInoffer) {
					resultToShow.add(offer);
				}
		}
		return resultToShow;
	}
	
	public static List<Offer> filterByOffersFlightSearch(Offers allOffers, FlightSearchCriteria flightSearchCriteria) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date departDate = flightSearchCriteria.getDepartDate();
		Date returnDate = flightSearchCriteria.getReturnDate();
		String noOfPax = flightSearchCriteria.getPassengersNumber();
		String fromAirport = flightSearchCriteria.getFromAirport();
		String toAirport = flightSearchCriteria.getToAirport();
		List<Offer> filteredList = new ArrayList<Offer>();
		
		if (fromAirport == null || toAirport == null || departDate == null)
			return allOffers.getOffer();

		for (Offers.Offer offer : allOffers.getOffer()) {
			SliceDetail sliceDetail = offer.getSliceDetail();
			Date sliceDepDate = null;
			Date sliceArrDate = null;
			try {
				sliceDepDate = sdf.parse(sliceDetail.getDepartureTime());
				sliceArrDate = sdf.parse(sliceDetail.getArrivalTime());
			} catch (Exception e) {
				e.printStackTrace();
			}

			if ((sliceDetail.getOrigin().equalsIgnoreCase(fromAirport)) && (sliceDetail.getDestination().equalsIgnoreCase(toAirport))
					&& sliceDepDate.compareTo(departDate) == 0)
				filteredList.add(offer);
		}
		return filteredList;
	}
	
	private static boolean isSelectedPresentInOffer(String selectedFeature,
			List<String> featuresInOffer) {
		for (String featureInOffer : featuresInOffer) {
			if (selectedFeature.equalsIgnoreCase(featureInOffer)) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public static Offer getOfferByOfferID(String offerId, List<Offer> offers) {
		offerId = offerId.replace("\"", "");
		for (Offer offer : offers) {
			if (offerId.equalsIgnoreCase(offer.getOfferId())) {
				return offer;
			}
		}
		return null;
	}

}
