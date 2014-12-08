//Abdullah AL-Sinaidi


package mortage_calc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

public class calc_mortage_gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc_mortage_gui window = new calc_mortage_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calc_mortage_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblgrossincome = new JLabel("Gross Income");
		lblgrossincome.setBounds(10, 40, 111, 20);
		frame.getContentPane().add(lblgrossincome);
		
		JLabel lblMonthlyDebt = new JLabel("Monthly Debt");
		lblMonthlyDebt.setBounds(10, 83, 111, 14);
		frame.getContentPane().add(lblMonthlyDebt);
		
		JLabel lblinterestRate = new JLabel("Interest Rate");
		lblinterestRate.setBounds(10, 124, 111, 17);
		frame.getContentPane().add(lblinterestRate);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(10, 163, 97, 14);
		frame.getContentPane().add(lblTerm);
		
		JLabel lblDownPayment = new JLabel("Down Payment");
		lblDownPayment.setBounds(10, 200, 111, 14);
		frame.getContentPane().add(lblDownPayment);
		
		textField_4 = new JTextField();
		textField_4.setBounds(388, 61, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 160, 40, 20);
		frame.getContentPane().add(comboBox);
		
		ArrayList<Integer> years = new ArrayList<Integer>();
		years.add(10);
		years.add(15);
		years.add(30);
		for(int i=0; i<years.size(); i++){
			comboBox.addItem(years.get(i));
		}
			comboBox.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers to be used in the calculations
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value from the high and low amounts
	            	double HOUSE_payment = calc_mort.House_Payment(GROSS_income);
	            	double HOUSE_Debt_Payment = calc_mort.House_Debt_Payment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = calc_mort.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value which is the amount of money you can't afford for the house
	            	Double MORTAGE = calc_mort.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText(PV);
	            }	            
			});
	            	
			textField = new JTextField();
			textField.setBounds(131, 40, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers to be used in the calculations
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value from the high and low amounts
	            	double HOUSE_payment = calc_mort.House_Payment(GROSS_income);
	            	double HOUSE_Debt_Payment = calc_mort.House_Debt_Payment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = calc_mort.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value which is the amount of money you can't afford for the house
	            	Double MORTAGE = calc_mort.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
			textField_1 = new JTextField();
			textField_1.setBounds(131, 80, 86, 20);
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			textField_1.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers to be used in the calculations
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value from the high and low amounts
	            	double HOUSE_payment = calc_mort.House_Payment(GROSS_income);
	            	double HOUSE_Debt_Payment = calc_mort.House_Debt_Payment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = calc_mort.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value which is the amount of money you can't afford for the house
	            	Double MORTAGE = calc_mort.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			textField_2 = new JTextField();
			textField_2.setBounds(131, 121, 86, 20);
			frame.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			textField_2.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers to be used in the calculations
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value from the high and low amounts
	            	double HOUSE_payment = calc_mort.House_Payment(GROSS_income);
	            	double HOUSE_Debt_Payment = calc_mort.House_Debt_Payment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = calc_mort.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value which is the amount of money you can't afford for the house
	            	Double MORTAGE = calc_mort.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
			textField_3 = new JTextField();
			textField_3.setBounds(126, 197, 86, 20);
			frame.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			textField_3.addActionListener(new ActionListener() {
				 
	            public void actionPerformed(ActionEvent e)
	            {
	            	// getting the text from the textfields in a type of Strings
	            	Integer TERM = (Integer)comboBox.getSelectedItem();
	            	String GROSS_INCOME = textField.getText();
	            	String MONTHLY_DEBT= textField_1.getText();
	            	String INTEREST_RATE= textField_2.getText();
	            	String DOWN_PAYMENT= textField_3.getText();
	            	
	            	// converting string into integers to be used in the calculations
	            	Double GROSS_income = Double.parseDouble(GROSS_INCOME);
	            	Double MONTHLY_debt = Double.parseDouble(MONTHLY_DEBT);
	            	Double INTEREST_rate= Double.parseDouble(INTEREST_RATE);
	            	Double DOWN_payment= Double.parseDouble(DOWN_PAYMENT);
	            	
	            	// getting affordable value from the high and low amounts
	            	double HOUSE_payment = calc_mort.House_Payment(GROSS_income);
	            	double HOUSE_Debt_Payment = calc_mort.House_Debt_Payment(GROSS_income, MONTHLY_debt);
	            	double CAN_afford = calc_mort.can_afford(HOUSE_Debt_Payment, HOUSE_payment);
	            	
	            	// calculating and rounding the present value which is the amount of money you can't afford for the house
	            	Double MORTAGE = calc_mort.present_value(CAN_afford,TERM ,INTEREST_rate,DOWN_payment );
	            	DecimalFormat format = new DecimalFormat("#0.000");
	            	String PV = format.format(MORTAGE);
	            	textField_4.setText("$"+PV);
	            }	            
			});
			
			
		
			
			
		
		JLabel lblAfordableAmount = new JLabel("Afordable Amount = ");
		lblAfordableAmount.setBounds(244, 64, 134, 14);
		frame.getContentPane().add(lblAfordableAmount);
		
		JLabel lblWhenChangingNumbers = new JLabel("When changing numbers or any of the fields, Press Enter to re-calculate ");
		lblWhenChangingNumbers.setBounds(67, 9, 368, 20);
		frame.getContentPane().add(lblWhenChangingNumbers);
		

		
	}
	}
