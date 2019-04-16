package edu.jlxy.stringfilter;

import java.util.List;

public interface IView {

	void updateAvailableFilters(IFilter[] availableFilters);
	void updateFilterChain(List<IFilter> filterChain);
	void updateOutput(String output);

}
