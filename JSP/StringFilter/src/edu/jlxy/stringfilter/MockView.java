package edu.jlxy.stringfilter;

import java.util.ArrayList;
import java.util.List;

public class MockView implements IView{
	
	/*private String[] availableFilters;

	public String[] getAvailableFilters() {
		return availableFilters;
	}

	public void updateAvailableFilters(String[] availableFilters) {
		this.availableFilters = availableFilters;
	}*/
	
	private IFilter[] availableFilters;

	public IFilter[] getAvailableFilters() {
		return availableFilters;
	}

	public void updateAvailableFilters(IFilter[] availableFilters) {
		this.availableFilters = availableFilters;
	}


	private List<IFilter> filterChain;

	private IController controller;

	private String inputText;

	private String outputText;

	public MockView(IController controller) {
		this.controller = controller;
		filterChain = new ArrayList<IFilter>();
	}



	public void addAvailFilterToFilterChain(IFilter initFilters) {
		controller.addAvailFilterToFilterChain(initFilters);
	}

	public List<IFilter> getFilterChain() {
		return filterChain;
	}

	public void updateFilterChain(List<IFilter> filterChain) {
		this.filterChain = filterChain;
	}


	public void removeFilterFromFilterChain(IFilter filter) {
		controller.removeFilterFromFilterChain(filter);
	}

	
	public void input(String inputText) {
		this.inputText = inputText;
	}

	public void apply() {
		controller.apply(this.inputText);
	}

	@Override
	public void updateOutput(String outputText) {
		this.outputText = outputText;
	}

	public String getOutput() {
		return outputText;
	}


}
