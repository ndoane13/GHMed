package edu.usm.cos420.ConsultingRegister.delegate;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class NewPatientJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;	
	private ButtonGroup radioButtonGroup;
	private JFormattedTextField formattedPhoneNumber;
	private JFormattedTextField formattedDateOfBirth;
	private JRadioButton rdbtnMale;
	private JTextPane textPaneError;
	private JFormattedTextField formattedTextFieldNHISNumber;
	private char sex;

	/**
	 * @author codysnow
	 */
	public NewPatientJPanel(final NewPatientHandler handler) {
		
		setBounds(100, 100, 550, 500);
		
		// SUBMIT button with basic validation
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if fields are empty
				StringBuilder errorText = new StringBuilder();
				boolean flag = false;
				
				if (textFieldFirstName.getText().isEmpty()) {
				    errorText.append("First Name is required.\n");
				    textFieldFirstName.setBackground(Color.pink);
				    flag = true;
				} 
				if (textFieldLastName.getText().isEmpty()) {
					errorText.append("Last Name is required.\n");
					textFieldLastName.setBackground(Color.pink);
					flag = true;
				} 
				if (textFieldAddress.getText().isEmpty()) {
					errorText.append("Address is required.\n");
					textFieldAddress.setBackground(Color.pink);
					flag = true;
				} 
				if (formattedDateOfBirth.getText().isEmpty()) {
					errorText.append("Date of Birth is required.\n");
					formattedDateOfBirth.setBackground(Color.pink);
					flag = true;
				} 
				
				if (flag) {
					textPaneError.setVisible(true);
					textPaneError.setBackground(Color.pink);
					textPaneError.setText(errorText.toString());
				}
				
				else {
					// add complete Patient to the model
					handler.addNewPatient(
						Long.parseLong(formattedTextFieldNHISNumber.getText()),
						textFieldFirstName.getText(), 
						textFieldLastName.getText(),
						textFieldAddress.getText(),
						Integer.parseInt(formattedPhoneNumber.getText()),
						formattedDateOfBirth.getText().toString(),
						sex
					);

					// clear fields
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					formattedTextFieldNHISNumber.setText("");
					textFieldAddress.setText("");
					formattedPhoneNumber.setText("");
					formattedDateOfBirth.setText("");
					rdbtnMale.setSelected(true);
					textPaneError.setVisible(false);
					textPaneError.setText("");
					// reset colors
					textFieldFirstName.setBackground(Color.WHITE);
					textFieldLastName.setBackground(Color.WHITE);
					textFieldAddress.setBackground(Color.WHITE);
					formattedDateOfBirth.setBackground(Color.WHITE);
					textPaneError.setBackground(Color.WHITE);
					setVisible(false);	
				}
			}
		});
		
		JLabel lblFirstName = new JLabel("First Name");
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear fields
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				formattedTextFieldNHISNumber.setText("");
				textFieldAddress.setText("");
				formattedPhoneNumber.setText("");
				formattedDateOfBirth.setText("");
				rdbtnMale.setSelected(true);
				textPaneError.setVisible(false);
				textPaneError.setText("");
				// reset colors
				textFieldFirstName.setBackground(Color.WHITE);
				textFieldLastName.setBackground(Color.WHITE);
				textFieldAddress.setBackground(Color.WHITE);
				formattedDateOfBirth.setBackground(Color.WHITE);
				textPaneError.setBackground(Color.WHITE);
				setVisible(false);
			}
		});
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth (MM.dd.yyyy)");
		
		formattedDateOfBirth = new JFormattedTextField(new SimpleDateFormat("MM.dd.yyyy"));
		
		JLabel lblNewLabel_1 = new JLabel("Phone Number");
		
		formattedPhoneNumber = new JFormattedTextField(createFormatter("03########"));
		
		// pull in next ID number 
		Long ID = handler.getNextID();
		JLabel lblNewPatientRecord = new JLabel("New Patient | Outpatient ID: " + ID);
		
		JLabel lblNHISNumber = new JLabel("NHIS Number");
		
		JLabel lblAddress = new JLabel("GhanaPostGPS / Address");
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		

	    //Create the radio buttons.
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = 'm';
			}
		});
		// rdbtnMale.setMnemonic(KeyEvent.VK_M);
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setSelected(true);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = 'f';
			}
		});
		// rdbtnFemale.setMnemonic(KeyEvent.VK_F);
		rdbtnFemale.setActionCommand("Female");

		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = 'o';
			}
		});
		// rdbtnOther.setMnemonic(KeyEvent.VK_O);
		rdbtnOther.setActionCommand("Other");

	    //Group the radio buttons.
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rdbtnMale);
		radioButtonGroup.add(rdbtnFemale);
		radioButtonGroup.add(rdbtnOther);
		
		textPaneError = new JTextPane();
		textPaneError.setVisible(false);
		
		// TODO: What's the format for NHIS numbers?
		formattedTextFieldNHISNumber = new JFormattedTextField(createFormatter("######"));

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSubmit)
							.addGap(75)
							.addComponent(lblNewPatientRecord))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddress))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDateOfBirth)
										.addComponent(formattedDateOfBirth, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(formattedPhoneNumber, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(formattedTextFieldNHISNumber, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(66)
											.addComponent(lblNHISNumber))))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldAddress)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblFirstName)
											.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
										.addGap(39)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblLastName)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnCancel)
												.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))))))
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSex))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnMale)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnFemale)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnOther))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPaneError, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(lblNewPatientRecord)
						.addComponent(btnCancel))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(lblLastName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNHISNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(formattedDateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldNHISNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblAddress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSex)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale)
						.addComponent(rdbtnOther))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneError, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		// use auto gap features for smarter spacing
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		

	}
	
	// set formatting for Masks
	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
		    formatter = new MaskFormatter(s){
		        @Override
		        public char getPlaceholderCharacter() {
		            return Character.MIN_VALUE; // remove default space chars
		        }
		    };;
		} catch (java.text.ParseException exc) {
		    System.err.println("Bad format: " + exc.getMessage());
		    System.exit(-1);
		}
		return formatter;
	}
}
