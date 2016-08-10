package com.aa.ndchtml5.web.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aa.ndchtml5.converter.ConvertXMLToJava;
import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.service.CommonService;
import com.aa.ndchtml5.web.model.FilterCriteria;
import com.aa.ndchtml5.web.model.FlightSearchCriteria;
import com.aa.ndchtml5.web.model.OfferDetails;
import com.aa.ndchtml5.web.model.PaymentDetails;

@Controller
@SessionAttributes(value = { "shoppingCartOffersList", "displayOffersList" ,"flightSearchOffersList" })
public class MainController {

	// All the offers in the system
	Offers allOffers;
	// The list of offers in the shopping cart
	ArrayList<OfferDetails> shoppingCartOffersList;
	// The list of offers that will be displayed to customer
	ArrayList<OfferDetails> displayOffersList;
	// The list of offers filtered based on Date and OD (from search page)
	ArrayList<OfferDetails> flightSearchOffersList;

	@PostConstruct
	private void initData() {
		allOffers = ConvertXMLToJava.getOffers();
		shoppingCartOffersList = new ArrayList<OfferDetails>();
		displayOffersList = new ArrayList<OfferDetails>();
		flightSearchOffersList = new ArrayList<OfferDetails>();
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

	/**
	 * This method will return initial offers based on search criteria
	 * @param flightSearchCriteria
	 * @param model
	 * @param result
	 * @return offers
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loadInitialData", method = RequestMethod.POST)
	public String returnOffersPage(@ModelAttribute("flightSearchCriteria") FlightSearchCriteria flightSearchCriteria,
			ModelMap model, BindingResult result) {
		if (result.hasErrors()) {
			return "search";
		}
		flightSearchOffersList = CommonService.filterByDateAndOD(allOffers, flightSearchCriteria);
		displayOffersList = (ArrayList<OfferDetails>)flightSearchOffersList.clone();
		model.addAttribute("displayOffersList", displayOffersList);
		model.addAttribute("shoppingCartOffersList", shoppingCartOffersList);
		return "offers";
	}

	/**
	 * This method will return the filteredOffersList based on filters applied
	 * @param filters
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getDetailsOnFilterSelection", method = RequestMethod.POST)
	public String getFilteredOffers(@RequestBody FilterCriteria filters, ModelMap model) {
		
		// if there are filters present then filter the flightSearchOffersList based on filters and remove shopping cart list
		if (filters != null && !filters.getSelectedFeatures().isEmpty()) {
			displayOffersList = CommonService.filterByFeature(filters.getSelectedFeatures(), flightSearchOffersList);
			
			displayOffersList = CommonService.getSubList(displayOffersList, shoppingCartOffersList);
			//displayOffersList.removeAll(shoppingCartOffersList);
		}
		else {
			// if there are no filters then remove shoppingCartOffersList from flightSearchOffersList
			//flightSearchOffersList.removeAll(shoppingCartOffersList);
		displayOffersList = CommonService.getSubList(flightSearchOffersList, shoppingCartOffersList);
		}
		model.addAttribute("displayOffersList", displayOffersList);
		return "offers :: filteredOffersList ";

	}

	
	/**
	 * This method will add to cart the offer selected
	 * @param offerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestBody String offerId, ModelMap model) {
		OfferDetails offer = CommonService.getOfferByOfferID(offerId, displayOffersList);
		shoppingCartOffersList.add(offer);
		displayOffersList.remove(offer);

		for (OfferDetails offerDetail : displayOffersList) {
			offerId = offerId.replace("\"", "");
			if (offerDetail.getOfferId().equals(offerId)) {
				displayOffersList.remove(offerDetail);
				break;
			}
		}
		model.addAttribute("shoppingCartOffersList", shoppingCartOffersList);
		model.addAttribute("displayOffersList", displayOffersList);
		return "offers :: offersWithCart";
	}
	
	

	/**
	 * This method will remove the selected offer from the cart
	 * @param offerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/removeFromCart", method = RequestMethod.POST)
	public String removeFromCart(@RequestBody String offerId, ModelMap model) {
		OfferDetails offer = CommonService.getOfferByOfferID(offerId, flightSearchOffersList);
		displayOffersList.add(offer);
		shoppingCartOffersList.remove(offer);
		model.addAttribute("shoppingCartOffersList", shoppingCartOffersList);
		model.addAttribute("displayOffersList", displayOffersList);
		return "offers :: offersWithCart";
	}

	
	/**
	 * This method will return to the payment page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String returnPaymentPage(ModelMap model) {
		model.addAttribute("shoppingCartOffersList", shoppingCartOffersList);
		model.addAttribute("paymentDetails", new PaymentDetails());
		return "payment";
	}

	
	
	/**
	 * This method will return receipt page
	 * @param paymentDetails
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showReceipt", method = RequestMethod.POST)
	public String returnReceiptPage(@ModelAttribute("paymentDetails") PaymentDetails paymentDetails, ModelMap model) {
		model.addAttribute("shoppingCartOffersList", shoppingCartOffersList);
		for(OfferDetails offerDetails:shoppingCartOffersList){
			for(Offer offer:allOffers.getOffer()){
				if(offerDetails.getOfferId().equalsIgnoreCase(offer.getOfferId())){
					offer.setOfferStatus("Purchased");
				}
			}
			
		}
		ConvertXMLToJava.persistOffers(allOffers);
		return "receipt";
	}

}
