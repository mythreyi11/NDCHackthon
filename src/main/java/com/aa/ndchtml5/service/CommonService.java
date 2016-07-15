package com.aa.ndchtml5.service;

import java.util.ArrayList;
import java.util.List;

import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;

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
