package edu.jlxy.stringfilter;

public class App {
	
	/*private Controller controller;*/

/*	public App(String[] initFilters) {
		controller = new Controller(initFilters);
	}
*/
	/*public Controller getController() {
		return controller;
	}
    
	private MockView view;

	public App(String[] initFilters) {
		controller = new Controller(initFilters);
		view = new MockView();
		controller.setView(view);
	}


	public MockView getView() {
		return view;
	}*/

	private IController controller;

	private IView view;

	public App(IFilter[] initFilters) {
		/*controller = new Controller(initFilters);
		view = new MockView(controller);
		controller.setView(view);*/
		
		controller = new Controller(initFilters);
		view = new ViewSwingImpl(controller);
		controller.setView(view);
		((ViewSwingImpl) view).createView();

	}

	public Controller getController() {
		return (Controller) controller;
	}

	public MockView getView() {
		return (MockView) view;
	}
	
	public static void main(String[] args) {
		IFilter[] initFilters = new IFilter[] { new UpperCaseFilter(),
				new LowerCaseFilter(), new PrefixTrimFilter() };
		new App(initFilters);
	}



}
