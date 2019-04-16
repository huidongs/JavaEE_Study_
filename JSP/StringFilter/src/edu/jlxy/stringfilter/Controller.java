package edu.jlxy.stringfilter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller implements IController{
	
	/*private String[] availableFilters;
	private IView view;

	public Controller(String[] initFilters) {
		availableFilters = initFilters;
	}

	public String[] getAvailableFilters() {
		return availableFilters;
	}

	public void setView(MockView view) {
		this.view = view;
		this.view.updateAvailableFilters(availableFilters);
	}


	public void setView(IView view) {
		this.view = view;
		this.view.updateAvailableFilters(availableFilters);
	}
*/
	private IFilter[] availableFilters;

	private IView view;

	private List<IFilter> filterChain;



	public Controller(IFilter[] initFilters) {
		availableFilters = initFilters;
		filterChain = new ArrayList<IFilter>();
	}

	public IFilter[] getAvailableFilters() {
		return availableFilters;
	}

	public void setView(IView view) {
		this.view = view;
		this.view.updateAvailableFilters(availableFilters);
	}

	@Override
	public void addAvailFilterToFilterChain(IFilter filter) {
		
//		// TODO Auto-generated method stub
//		filterChain.add(filter);
//		this.view.updateFilterChain(filterChain);
		
		if (!filterChain.contains(filter)) {
			filterChain.add(filter);
			this.view.updateFilterChain(filterChain);
		}
	
	}
	
	@Override
	public void removeFilterFromFilterChain(IFilter filter) {
		filterChain.remove(filter);
		this.view.updateFilterChain(filterChain);
	}

	
	@Override
	public void apply(String inputText) {

		/*String output = "";

		// TODO 对inputText按照“转换器链”顺序进行处理，并将处理逻辑赋给output

		this.view.updateOutput(output);*/
		
		String output = "";

		for (Iterator<IFilter> iterator = filterChain.iterator(); iterator
				.hasNext();) {
			IFilter filter = iterator.next();
			inputText = filter.filter(inputText);
		}

		output = inputText;

		this.view.updateOutput(output);

	}

	


	
}
