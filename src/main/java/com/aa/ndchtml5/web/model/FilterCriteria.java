package com.aa.ndchtml5.web.model;

import java.util.List;

public class FilterCriteria {

	List<String> selectedFeatures;
	List<String> selectedStops;

	public List<String> getSelectedFeatures() {
		return selectedFeatures;
	}

	public void setSelectedFeatures(List<String> selectedFeatures) {
		this.selectedFeatures = selectedFeatures;
	}

	/**
	 * @return the selectedStops
	 */
	public List<String> getSelectedStops() {
		return selectedStops;
	}

	/**
	 * @param selectedStops the selectedStops to set
	 */
	public void setSelectedStops(List<String> selectedStops) {
		this.selectedStops = selectedStops;
	}

}
