import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Controller
{
	public BagelButtonListener BBL;
	public CoffeePanelListener CPL;
	public ToppingPanelListener TPL;
	public CalcButtonListener CBL;
	public ExitButtonListener EBL;
	
	private calculations bill;
	
	public Controller()
	{
		bill = new calculations();
		
		BBL = new BagelButtonListener();
		CPL = new CoffeePanelListener();
		TPL = new ToppingPanelListener();
		CBL = new CalcButtonListener();
		EBL = new ExitButtonListener();
		
	}
	public class BagelButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if((e.getActionCommand()).equals("White Bagel"))
			{
				bill.setBagel("white");
			}
			else
			{
				bill.setBagel("wheat");
			}
		}
		
	}
	
	public class CoffeePanelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int type = -1;
			String coffee = e.getActionCommand();
			if(coffee.equals("No Coffee"))
			{
				type = 1;
			}
			else if(coffee.equals("Regular Coffee"))
			{
				type = 2;
			}
			else if(coffee.equals("Decaf Coffee"))
			{
				type = 3;
			}
			else
			{
				type = 0;
			}
			bill.setCoffee(type);
		}
	}
	
	public class ToppingPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			boolean[] toppings = bill.getToppings();
			String top = e.getActionCommand();
			JCheckBox checkBox = (JCheckBox)e.getSource();
			if(top.equals("Cream Cheese"))
			{
				toppings[0] = checkBox.isSelected();
			}
			else if(top.equals("Butter"))
			{
				toppings[1] = checkBox.isSelected();
			}
			else if(top.equals("Peach Jelly"))
			{
				toppings[2] = checkBox.isSelected();
			}
			else
			{
				toppings[3] = checkBox.isSelected();
			}
			bill.setToppings(toppings);
		}
	}
	
	public class CalcButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Variables to hold the subtotal, tax, and total
	         double subtotal;
	       
	         // Calculate the subtotal.
	         double bills[] = new double[3];
	         bills=bill.gettheBill();
	         subtotal = bills[0] +  bills[1] +  bills[2];

	         
	         // Create a DecimalFormat object to format output.
	         DecimalFormat dollar = new DecimalFormat("0.00");

	         // Display the charges.
	         JOptionPane.showMessageDialog(null, "Subtotal: $" +
	                       dollar.format(subtotal) + "\n" +
	                       "Tax: $" + dollar.format(bills[3]) + "\n" +
	                       "Total: $" + dollar.format(bills[4]));
	         
	                  
		}	
	}
	
	public class ExitButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
