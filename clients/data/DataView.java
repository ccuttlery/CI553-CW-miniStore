package clients.data;

import java.awt.Container;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

import catalogue.Basket;
import clients.cashier.CashierController;
import clients.cashier.CashierModel;
import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockReadWriter;
import style.ColorManager;

import java.awt.Container;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

import clients.Picture;
import clients.backDoor.BackDoorController;
import clients.customer.CustomerModel;
import middle.MiddleFactory;
import middle.StockReader;

public class DataView implements Observer {

	  class Name                              // Names of buttons
	  {
	    public static final String CHECK  = "Check";
	    public static final String ADD = "Add";
	  }
	  
	  private static final int H = 300;       // Height of window pixels
	  private static final int W = 400;       // Width  of window pixels
	  
	  private final JLabel      pageTitle  = new JLabel();
	  private final JLabel  action   = new JLabel();
	  private final JTextField  descriptionInput   = new JTextField();
	  private final JLabel      descriptionAction  = new JLabel();
	  private final JTextField  priceInput   = new JTextField();
	  private final JLabel      priceAction  = new JLabel();
	  private final JTextField  stockInput   = new JTextField();
	  private final JLabel      stockAction  = new JLabel();
	  private final JButton     buttonCheck = new JButton( Name.CHECK );
	  private final JButton     buttonAdd = new JButton( Name.ADD );

	  private Picture picture = new Picture(80,80);
	  private DataController cont= null;
	  
	  public DataView(  RootPaneContainer rpc, MiddleFactory mf, int x, int y )
	  {

	  }
	  
	  
	  public void setController( DataController c )
	  {
	    cont = c;
	  }
	  
	@Override
	public void update(Observable modelC, Object arg) {
		DataModel model  = (DataModel) modelC;
	    String        message = (String) arg;
	    action.setText( message );
	}

}