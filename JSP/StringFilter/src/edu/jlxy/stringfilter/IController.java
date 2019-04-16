package edu.jlxy.stringfilter;

public interface IController {
	
	void setView(IView view);
	void apply(String inputText);
	void removeFilterFromFilterChain(IFilter filter);
	void addAvailFilterToFilterChain(IFilter filter);

}
