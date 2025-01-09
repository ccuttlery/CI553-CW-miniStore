package clients.data;

import catalogue.Basket;
import catalogue.Product;
import debug.DEBUG;
import middle.*;

import java.util.Observable;

/**
 * Implements the Model of the cashier client
 */
public class DataModel extends Observable
{
  private Product     theProduct = null;            // Current product
  private Basket      theBasket  = null;            // Bought items

  private String      pn = "";                      // Product being processed

  private StockReadWriter stock     = null;


  /**
   * Construct the model of the Data
   * @param mf The factory to create the connection objects
   */

  public DataModel(MiddleFactory mf)
  {
    try                                           
    {      
      stock = mf.makeStockReadWriter();        // Database access
    } catch ( Exception e )
    {
      DEBUG.error("DataModel.constructor\n%s", e.getMessage() );
    }
  }


  /**
   * ask for update of view callled at start of day
   * or after system reset
   */
  public void askForUpdate()
  {
    setChanged(); notifyObservers("Welcome");
  }
}
  
