import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class CalculatorFrame {

	private JFrame frame;
	private JTextField textField;
	private Logic logic;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	
	/**
	 * Create the application.
	 */
	public CalculatorFrame(Logic l) {
		initialize( l);
		logic=l;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Logic l) {
		frame = new JFrame("Calculator");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Enter the size of the population here:");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(10, 11, 193, 24);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(180, 14));
		textField.setBounds(213, 13, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(309, 12, 89, 23);
		btnCalculate.addActionListener(new CalListener(this));
		frame.getContentPane().add(btnCalculate);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResults.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblResults.setBounds(10, 59, 193, 24);
		frame.getContentPane().add(lblResults);
		
		JLabel lblPopulation = new JLabel("Population");
		lblPopulation.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblPopulation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPopulation.setBounds(10, 94, 193, 24);
		frame.getContentPane().add(lblPopulation);
		
		JLabel lblPattern = new JLabel("Pattern");
		lblPattern.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblPattern.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPattern.setBounds(10, 129, 193, 24);
		frame.getContentPane().add(lblPattern);
		
		JLabel lblTotalPlates = new JLabel("Total Plates");
		lblTotalPlates.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTotalPlates.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPlates.setBounds(10, 164, 193, 24);
		frame.getContentPane().add(lblTotalPlates);
		
		JLabel lblExcessPlates = new JLabel("Excess Plates");
		lblExcessPlates.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblExcessPlates.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExcessPlates.setBounds(10, 199, 193, 24);
		frame.getContentPane().add(lblExcessPlates);
		
		 label = new JLabel("???");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(213, 94, 221, 24);
		frame.getContentPane().add(label);
	
		 label_1 = new JLabel("???");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(213, 129, 221, 24);
		frame.getContentPane().add(label_1);
		
		 label_2 = new JLabel("???");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(213, 164, 221, 24);
		frame.getContentPane().add(label_2);
		
		 label_3 = new JLabel("???");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(213, 199, 221, 24);
		frame.getContentPane().add(label_3);
		frame.setVisible(true);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabel_1() {
		return label_1;
	}

	public void setLabel_1(JLabel label_1) {
		this.label_1 = label_1;
	}

	public JLabel getLabel_2() {
		return label_2;
	}

	public void setLabel_2(JLabel label_2) {
		this.label_2 = label_2;
	}

	public JLabel getLabel_3() {
		return label_3;
	}

	public void setLabel_3(JLabel label_3) {
		this.label_3 = label_3;
	}
	
}
