package com.aa.ndchtml5.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aa.ndchtml5.converter.ConvertDataToView;
import com.aa.ndchtml5.converter.ConvertXMLToJava;
import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.web.model.FilterCriteria;
import com.aa.ndchtml5.web.model.OfferList;

@Controller
public class SearchController {
	
	Offers allOffers;
	
	@PostConstruct
	private void iniData() {
		allOffers = ConvertXMLToJava.getOffers();
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String returnSearchPage(ModelMap model) {
		return "search";
	}
	
	@RequestMapping(value = "/loadInitialData" , method = RequestMethod.POST)
	public String returnOffersPage(ModelMap model) {
		OfferList offerList = ConvertDataToView.getOfferListToShow(allOffers.getOffer());
		model.addAttribute("offerList", offerList);
		return "offers";
	}
	
	@RequestMapping(value = "/getDetailsOnFilterSelection" , method = RequestMethod.POST)
	public String getFilteredOffers(@RequestBody FilterCriteria filters,ModelMap model) {
		List<Offer> selectedOffers;
		 if (filters !=null && 	filters.getSelectedFeatures().isEmpty()) {
			 selectedOffers = allOffers.getOffer(); 
		 }
		 else {
			 selectedOffers = findByIncludedFeature(filters.getSelectedFeatures(),allOffers.getOffer());
		 }
		OfferList offerList = ConvertDataToView.getOfferListToShow(selectedOffers);
		model.addAttribute("offerList", offerList);
		return "offers :: resultsList";

	}

	private List<Offer> findByIncludedFeature(List<String> selectedfeatures,
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
	
	private boolean isSelectedPresentInOffer(String selectedFeature,
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

}
