package com.aa.ndchtml5.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aa.ndchtml5.converter.ConvertDataToView;
import com.aa.ndchtml5.converter.ConvertXMLToJava;
import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.service.CommonService;
import com.aa.ndchtml5.web.model.FilterCriteria;
import com.aa.ndchtml5.web.model.FlightSearchCriteria;
import com.aa.ndchtml5.web.model.OfferList;

@Controller
public class SearchController {
	
	Offers allOffers;
	List<Offer> purchaseList;
	
	@PostConstruct
	private void iniData() {
		allOffers = ConvertXMLToJava.getOffers();
		purchaseList = new ArrayList<Offer>();
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String returnSearchPage(ModelMap model) {
		model.addAttribute("flightSearchCriteria", new FlightSearchCriteria());
		return "search";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String returncartPage(ModelMap model) {
		return "cart";
	}
	@RequestMapping(value = "/loadInitialData" , method = RequestMethod.POST)
	public String returnOffersPage(@ModelAttribute("flightSearchCriteria") FlightSearchCriteria flightSearchCriteria,
			ModelMap model, BindingResult result) {
		 if (result.hasErrors()) {
	            return "search";
	        }
		OfferList offerList = ConvertDataToView.getOfferListToShow(allOffers.getOffer());
		model.addAttribute("offerList", offerList);
		model.addAttribute("purchaseList", purchaseList);
		return "offers";
	}
	
	@RequestMapping(value = "/getDetailsOnFilterSelection" , method = RequestMethod.POST)
	public String getFilteredOffers(@RequestBody FilterCriteria filters,ModelMap model) {
		List<Offer> selectedOffers;
		 if (filters !=null && 	filters.getSelectedFeatures().isEmpty()) {
			 selectedOffers = allOffers.getOffer(); 
		 }
		 else {
			 selectedOffers = CommonService.findByFeature(filters.getSelectedFeatures(),allOffers.getOffer());
		 }
		OfferList offerList = ConvertDataToView.getOfferListToShow(selectedOffers);
		model.addAttribute("offerList", offerList);
		return "offers :: resultsList";

	}
	
	@RequestMapping(value = "/addToCart" , method = RequestMethod.POST)
	public String aaddToCart(@RequestBody String offerId, ModelMap model) {
		  Offer offer = CommonService.getOfferByOfferID(offerId,allOffers.getOffer());
		  purchaseList.add(offer);
		  model.addAttribute("purchaseList", purchaseList);
		  return "offers :: purchaseCartList";
		}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String returnPaymentPage(@ModelAttribute("purchaseList") List<Offer> purchaseList, ModelMap model) {
		OfferList offerList = ConvertDataToView.getOfferListToShow(purchaseList);
		model.addAttribute("purchaseList", offerList);
		return "payment";
	}
}
