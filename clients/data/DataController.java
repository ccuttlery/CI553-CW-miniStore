package clients.data;



public class DataController {
	  private DataModel model = null;
	  private DataView  view  = null;

	  /**
	   * Constructor
	   * @param model The model 
	   * @param view  The view from which the interaction came
	   */
	  public DataController( DataModel model, DataView view )
	  {
	    this.view  = view;
	    this.model = model;
	  }	  
}