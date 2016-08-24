package com.aa.ndchtml5.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.aa.ndchtml5.converter.ConvertDataToView;
import com.aa.ndchtml5.domain.Offers;
import com.aa.ndchtml5.domain.Offers.Offer;
import com.aa.ndchtml5.domain.Offers.Offer.SegmentDetail;
import com.aa.ndchtml5.domain.Offers.Offer.SliceDetail;
import com.aa.ndchtml5.web.model.FilterCriteria;
import com.aa.ndchtml5.web.model.FlightSearchCriteria;
import com.aa.ndchtml5.web.model.OfferDetails;

public class CommonService {
	
	
	/**
	 * This method remove toBeRemovedList from parentList
	 * @param filteredOffers
	 * @param availableOfferDetails
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<OfferDetails> getSubList(ArrayList<OfferDetails> parentList,
			ArrayList<OfferDetails> toBeRemovedList) {

		ArrayList<OfferDetails> newParentList = (ArrayList<OfferDetails>) parentList.clone();
		if (toBeRemovedList.isEmpty()) {
			return newParentList;
		} else {
			newParentList.removeAll(toBeRemovedList);
			return newParentList;

		}

	}
	
	
	/**
	 * This method will filter the List based on the filters
	 * @param selectedfeatures
	 * @param offers
	 * @return
	 */
	public static ArrayList<OfferDetails> filterByFeature(List<String> selectedfeatures,
			List<OfferDetails> offers) {
		ArrayList<OfferDetails> filteredList = new ArrayList<OfferDetails>();
		for (OfferDetails offer : offers) {
			List<String> featuresInOffer = new ArrayList<String>();
			featuresInOffer.addAll(offer.getIncludeFeatures());
			featuresInOffer.addAll(offer.getPurchaseFeautues());
			if (featuresInOffer.containsAll(selectedfeatures))
				filteredList.add(offer);
		}
		return filteredList;
	}
	
	
	/**
	 * This method will filter the List based on the filters
	 * @param selectedfeatures
	 * @param offers
	 * @return
	 */
	public static ArrayList<OfferDetails> filterByStops(List<String> selectedStops,
			List<OfferDetails> offers) {
		ArrayList<OfferDetails> filteredList = new ArrayList<OfferDetails>();
		for (OfferDetails offer : offers) {
			if(selectedStops.contains(String.valueOf(offer.getNoOfSegments()))){
				filteredList.add(offer);
			}
			
		}
		return filteredList;
	}
	
	/**
	 * This method will filter the List based on the filters
	 * @param selectedfeatures
	 * @param offers
	 * @return
	 */
	public static ArrayList<OfferDetails> filterByAirlines(List<String> selectedAirlines,
			List<OfferDetails> offers) {
		ArrayList<OfferDetails> filteredList = new ArrayList<OfferDetails>();
		for (OfferDetails offer : offers) {
			List<SegmentDetail> segmentDetailList = offer.getSegmentDetailList();
			String[] otherAirlinesCarrierCodes = {"IB","AS","HA","SQ"};
			List<String> otherAirlinesList = Arrays.asList(otherAirlinesCarrierCodes);
			for (SegmentDetail segment : segmentDetailList) {
				if (selectedAirlines.contains(segment.getCarrierCode()) || (selectedAirlines.contains("OA") && otherAirlinesList.contains(segment.getCarrierCode()))) {
					filteredList.add(offer);
				}

			}

		}
		return filteredList;
	}
	
	
	/**
	 * This method will filter the offers by Date and Origin/Destination
	 * @param allOffers
	 * @param flightSearchCriteria
	 * @return
	 */
	@SuppressWarnings("unused")
	public static ArrayList<OfferDetails> filterByDateAndOD(Offers allOffers, FlightSearchCriteria flightSearchCriteria) {
		
		ArrayList<OfferDetails> filteredOfferDetailsList = new ArrayList<OfferDetails>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date departDate = flightSearchCriteria.getDepartDate();
		Date returnDate = flightSearchCriteria.getReturnDate();
		String noOfPax = flightSearchCriteria.getPassengersNumber();
		String fromAirport = flightSearchCriteria.getFromAirport();
		String toAirport = flightSearchCriteria.getToAirport();
		List<Offer> filteredList = new ArrayList<Offer>();
		
		if (fromAirport == null || toAirport == null || departDate == null) {
			for (Offer offer : allOffers.getOffer()) {
				filteredOfferDetailsList.add(ConvertDataToView.getOfferDetails(offer));
			}
			 return filteredOfferDetailsList;
		}

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
		for (Offer offer : filteredList) {
			filteredOfferDetailsList.add(ConvertDataToView.getOfferDetails(offer));
		}
		 return filteredOfferDetailsList;
		
	}
	
	/**
	 * Return if the selectedFeature is present offer's features
	 * @param selectedFeature
	 * @param featuresInOffer
	 * @return
	 */
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

	
	
	/**
	 * Get the offer from the List by offerId
	 * @param offerId
	 * @param offers
	 * @return
	 */
	public static OfferDetails getOfferByOfferID(String offerId, List<OfferDetails> offers) {
		offerId = offerId.replace("\"", "");
		for (OfferDetails offer : offers) {
			if (offerId.equalsIgnoreCase(offer.getOfferId())) {
				return offer;
			}
		}
		return null;
	}


	public static FilterCriteria mapFromJson(String str) {
		FilterCriteria filters = new FilterCriteria();
		Map<String, List<String>> responseMap = splitToMap(str, "&", ":",",");
		for(Entry<String, List<String>> e : responseMap.entrySet()) {
			if(e.getKey().contains("selectedFeatures")) {
			filters.setSelectedFeatures(e.getValue());
			}
			if(e.getKey().contains("selectedStops")) {
			filters.setSelectedStops(e.getValue()); 
			}
			if(e.getKey().contains("selectedAirlines")) {
			filters.setSelectedAirlines(e.getValue());
			}
		}
		return filters;
	}

	private static Map<String, List<String>> splitToMap(String source, String entriesSeparator,
			String keyValueSeparator, String valueValueSeparator) {
		source = source.replace("{", "");
		source = source.replace("}", "");
		source = source.replace("\"", "");
		source = source.replace("[", "");
		source = source.replace("]", "");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String[] entries = source.split(entriesSeparator);
		for (String entry : entries) {
			if (entry.contains(keyValueSeparator)) {
				String[] keyValue = entry.split(keyValueSeparator);
				String[] values = keyValue.length > 1 ? keyValue[1].split(valueValueSeparator): new String[0];
				List<String> valuesList = convertToList(values);
				map.put(keyValue[0], valuesList);
			}
		}
		return map;
	}
	
	private static List<String> convertToList(String[] values) {
		List<String> valuesList = new ArrayList<String>();
		for (String s : values) {
			valuesList.add(s);
		}
		return valuesList;
	}

}
