import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class CalListener implements ActionListener {

	private CalculatorFrame cal; 
	
	public CalListener(CalculatorFrame cal) {
		super();
		this.cal = cal;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int pop=-1;
		try{
		 pop=Integer.parseInt(cal.getTextField().getText());
		 System.out.println("pop is: "+pop);
			Integer[] results=cal.getLogic().calculate(pop);
			
			cal.getLabel().setText(""+pop);
			cal.getLabel_1().setText(results[0]+" numbers followed by "+results[1]+" letters");
			cal.getLabel_2().setText(""+results[2]);
			cal.getLabel_3().setText(""+(results[2]-pop));
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog( 
					null,"Invalid input, please enter an integer number",null,
							JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog( 
					null,"Error occured try again",null,
							JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
