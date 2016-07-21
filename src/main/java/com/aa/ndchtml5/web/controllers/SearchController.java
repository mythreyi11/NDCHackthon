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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aa.ndchtml5.converter.ConvertDataToView;
import com.aa.ndchtml5.converter.ConvertXMLToJava;
import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.service.CommonService;
import com.aa.ndchtml5.web.model.FilterCriteria;
import com.aa.ndchtml5.web.model.FlightSearchCriteria;
import com.aa.ndchtml5.web.model.OfferDetails;
import com.aa.ndchtml5.web.model.PaymentDetails;

@Controller
@SessionAttributes(value={"purchaseList","offerDetailsList"})
public class SearchController {
	
	Offers allOffers;
	ArrayList<Offer> purchaseList;
	ArrayList<OfferDetails> offerDetailsList;
	
	@PostConstruct
	private void initData() {
		allOffers = ConvertXMLToJava.getOffers();
		purchaseList = new ArrayList<Offer>();
		offerDetailsList = new ArrayList<OfferDetails>();
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String returnSearchPage(ModelMap model) {
		model.addAttribute("flightSearchCriteria", new FlightSearchCriteria());
		initData();
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
		offerDetailsList = ConvertDataToView.getOfferListToShow(allOffers.getOffer());
		model.addAttribute("offerDetailsList", offerDetailsList);
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
		List<OfferDetails> offerDetailsList = ConvertDataToView.getOfferListToShow(selectedOffers);
		model.addAttribute("offerDetailsList", offerDetailsList);
		return "offers :: resultsList";

	}
	
	@RequestMapping(value = "/addToCart" , method = RequestMethod.POST)
	public String addToCart(@RequestBody String offerId, ModelMap model) {
		  Offer offer = CommonService.getOfferByOfferID(offerId,allOffers.getOffer());
		  purchaseList.add(offer);
		  
		  for(OfferDetails offerDetail: offerDetailsList){
			  offerId = offerId.replace("\"", "");
			  if(offerDetail.getOfferId().equals(offerId)){
				  offerDetailsList.remove(offerDetail);
				  break;
			  }
		  }
		  model.addAttribute("purchaseList", purchaseList);
		  model.addAttribute("offerDetailsList", offerDetailsList);
		  return "offers :: purchaseCartList";
		}
	
	
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String returnPaymentPage(@ModelAttribute("purchaseList") ArrayList<Offer> purchaseList, ModelMap model) {
		List<OfferDetails> offerDetailsList = ConvertDataToView.getOfferListToShow(purchaseList);
		model.addAttribute("purchaseList", offerDetailsList);
		model.addAttribute("paymentDetails", new PaymentDetails());
		return "payment";
	}
	
	
	@RequestMapping(value = "/showReceipt", method = RequestMethod.POST)
	public String returnReceiptPage(@ModelAttribute("paymentDetails") PaymentDetails paymentDetails, ModelMap model) {
		/*OfferList offerList = ConvertDataToView.getOfferListToShow(purchaseList);
		model.addAttribute("purchaseList", offerList);
		model.addAttribute("paymentDetails", new PaymentDetails());*/
		return "receipt";
	}
	
}
