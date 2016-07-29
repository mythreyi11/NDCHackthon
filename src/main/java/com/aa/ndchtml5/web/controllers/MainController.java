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
public class MainController {
	
	Offers allOffers;
	ArrayList<OfferDetails> purchasedList;
	ArrayList<OfferDetails> availableOfferDetailsList;
	
	@PostConstruct
	private void initData() {
		allOffers = ConvertXMLToJava.getOffers();
		purchasedList = new ArrayList<OfferDetails>();
		availableOfferDetailsList = new ArrayList<OfferDetails>();
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
		availableOfferDetailsList = ConvertDataToView.getOfferListToShow(allOffers.getOffer(),availableOfferDetailsList);
		model.addAttribute("availableOfferDetailsList", availableOfferDetailsList);
		model.addAttribute("purchasedList", purchasedList);
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
		availableOfferDetailsList = ConvertDataToView.getOfferListToShow(selectedOffers,purchasedList);
		model.addAttribute("availableOfferDetailsList", availableOfferDetailsList);
		return "offers :: filteredOffersList ";

	}
	
	@RequestMapping(value = "/addToCart" , method = RequestMethod.POST)
	public String addToCart(@RequestBody String offerId, ModelMap model) {
		  Offer offer = CommonService.getOfferByOfferID(offerId,allOffers.getOffer());
		  purchasedList.add(ConvertDataToView.getOfferDetails(offer));
		  
		  for(OfferDetails offerDetail: availableOfferDetailsList){
			  offerId = offerId.replace("\"", "");
			  if(offerDetail.getOfferId().equals(offerId)){
				  availableOfferDetailsList.remove(offerDetail);
				  break;
			  }
		  }
		  model.addAttribute("purchasedList", purchasedList);
		  model.addAttribute("availableOfferDetailsList", availableOfferDetailsList);
		  return "offers :: offersWithCart";
		}
	
	@RequestMapping(value = "/removeFromCart" , method = RequestMethod.POST)
	public String removeFromCart(@RequestBody String offerId, ModelMap model) {
		  Offer offer = CommonService.getOfferByOfferID(offerId,allOffers.getOffer());
		  availableOfferDetailsList.add(ConvertDataToView.getOfferDetails(offer));
		  
		  for(OfferDetails purchasedItem: purchasedList){
			  offerId = offerId.replace("\"", "");
			  if(purchasedItem.getOfferId().equals(offerId)){
				  purchasedList.remove(purchasedItem);
				  break;
			  }
		  }
		  model.addAttribute("purchasedList", purchasedList);
		  model.addAttribute("availableOfferDetailsList", availableOfferDetailsList);
		  return "offers :: offersWithCart";
		}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String returnPaymentPage(ModelMap model) {
		model.addAttribute("purchasedList", purchasedList);
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
