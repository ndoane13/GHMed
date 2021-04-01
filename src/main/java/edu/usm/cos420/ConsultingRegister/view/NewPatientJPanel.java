package edu.usm.cos420.ConsultingRegister.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
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
	private Map<String, String> formData;
	private JButton btnSubmit;
	private JButton btnCancel;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOther;

	/**
	 * @author codysnow
	 */
	public NewPatientJPanel() {

		setBounds(100, 100, 550, 500);

		// SUBMIT button with basic validation
		btnSubmit = new JButton("Submit");

		JLabel lblFirstName = new JLabel("First Name");

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);

		btnCancel = new JButton("Cancel");

		JLabel lblDateOfBirth = new JLabel("Date of Birth (MM.dd.yyyy)");

		formattedDateOfBirth = new JFormattedTextField(new SimpleDateFormat("MM.dd.yyyy"));

		JLabel lblNewLabel_1 = new JLabel("Phone Number");

		formattedPhoneNumber = new JFormattedTextField(createFormatter("03########"));

		// TODO: Add Outpatient ID to the top of the form upon generation
		JLabel lblNewPatientRecord = new JLabel("New Patient");

		JLabel lblNHISNumber = new JLabel("NHIS Number");

		JLabel lblAddress = new JLabel("GhanaPostGPS / Address");

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);

		JLabel lblSex = new JLabel("Sex");

		// Create the radio buttons.
		rdbtnMale = new JRadioButton("Male");

		// rdbtnMale.setMnemonic(KeyEvent.VK_M);
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setSelected(true);

		rdbtnFemale = new JRadioButton("Female");

		// rdbtnFemale.setMnemonic(KeyEvent.VK_F);
		rdbtnFemale.setActionCommand("Female");

		rdbtnOther = new JRadioButton("Other");

		// rdbtnOther.setMnemonic(KeyEvent.VK_O);
		rdbtnOther.setActionCommand("Other");

		// Group the radio buttons.
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rdbtnMale);
		radioButtonGroup.add(rdbtnFemale);
		radioButtonGroup.add(rdbtnOther);

		textPaneError = new JTextPane();
		textPaneError.setVisible(false);

		// TODO: What's the format for NHIS numbers?
		formattedTextFieldNHISNumber = new JFormattedTextField(createFormatter("######"));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
						groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addComponent(btnSubmit).addGap(75)
												.addComponent(lblNewPatientRecord))
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap().addComponent(lblAddress))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDateOfBirth).addComponent(formattedDateOfBirth,
																GroupLayout.PREFERRED_SIZE, 169,
																GroupLayout.PREFERRED_SIZE))
												.addGap(38)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(formattedPhoneNumber,
																		GroupLayout.PREFERRED_SIZE, 137,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(formattedTextFieldNHISNumber,
																		GroupLayout.PREFERRED_SIZE, 152,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblNewLabel_1).addGap(66)
																.addComponent(lblNHISNumber))))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textFieldAddress)
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblFirstName).addComponent(
																		textFieldFirstName, GroupLayout.PREFERRED_SIZE,
																		235, GroupLayout.PREFERRED_SIZE))
														.addGap(39)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblLastName)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(btnCancel)
																		.addComponent(textFieldLastName,
																				GroupLayout.PREFERRED_SIZE, 243,
																				GroupLayout.PREFERRED_SIZE))))))
										.addGap(42))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblSex))
								.addGroup(groupLayout.createSequentialGroup().addComponent(rdbtnMale)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbtnFemale)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbtnOther))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(
										textPaneError, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSubmit)
						.addComponent(lblNewPatientRecord).addComponent(btnCancel))
				.addGap(28)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(lblFirstName).addComponent(lblLastName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDateOfBirth)
						.addComponent(lblNewLabel_1).addComponent(lblNHISNumber))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(formattedDateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextFieldNHISNumber, GroupLayout.PREFERRED_SIZE, 25,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(lblAddress).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(lblSex).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnMale)
						.addComponent(rdbtnFemale).addComponent(rdbtnOther))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textPaneError, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(77, Short.MAX_VALUE)));
		setLayout(groupLayout);

		// use auto gap features for smarter spacing
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);

	}

	/**
	 * @return the textFieldFirstName
	 */
	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	/**
	 * @param textFieldFirstName the textFieldFirstName to set
	 */
	public void setTextFieldFirstName(JTextField textFieldFirstName) {
		this.textFieldFirstName = textFieldFirstName;
	}

	/**
	 * @return the textFieldLastName
	 */
	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	/**
	 * @param textFieldLastName the textFieldLastName to set
	 */
	public void setTextFieldLastName(JTextField textFieldLastName) {
		this.textFieldLastName = textFieldLastName;
	}

	/**
	 * @return the textFieldAddress
	 */
	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	/**
	 * @param textFieldAddress the textFieldAddress to set
	 */
	public void setTextFieldAddress(JTextField textFieldAddress) {
		this.textFieldAddress = textFieldAddress;
	}

	/**
	 * @return the formattedPhoneNumber
	 */
	public JFormattedTextField getFormattedPhoneNumber() {
		return formattedPhoneNumber;
	}

	/**
	 * @param formattedPhoneNumber the formattedPhoneNumber to set
	 */
	public void setFormattedPhoneNumber(JFormattedTextField formattedPhoneNumber) {
		this.formattedPhoneNumber = formattedPhoneNumber;
	}

	/**
	 * @return the formattedDateOfBirth
	 */
	public JFormattedTextField getFormattedDateOfBirth() {
		return formattedDateOfBirth;
	}

	/**
	 * @param formattedDateOfBirth the formattedDateOfBirth to set
	 */
	public void setFormattedDateOfBirth(JFormattedTextField formattedDateOfBirth) {
		this.formattedDateOfBirth = formattedDateOfBirth;
	}

	/**
	 * @return the formattedTextFieldNHISNumber
	 */
	public JFormattedTextField getFormattedTextFieldNHISNumber() {
		return formattedTextFieldNHISNumber;
	}

	/**
	 * @param formattedTextFieldNHISNumber the formattedTextFieldNHISNumber to set
	 */
	public void setFormattedTextFieldNHISNumber(JFormattedTextField formattedTextFieldNHISNumber) {
		this.formattedTextFieldNHISNumber = formattedTextFieldNHISNumber;
	}

	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/**
	 * @return the textPaneError
	 */
	public JTextPane getTextPaneError() {
		return textPaneError;
	}

	/**
	 * @param textPaneError the textPaneError to set
	 */
	public void setTextPaneError(JTextPane textPaneError) {
		this.textPaneError = textPaneError;
	}

	/**
	 * @return the rdbtnMale
	 */
	public JRadioButton getRdbtnMale() {
		return rdbtnMale;
	}

	/**
	 * @param rdbtnMale the rdbtnMale to set
	 */
	public void setRdbtnMale(JRadioButton rdbtnMale) {
		this.rdbtnMale = rdbtnMale;
	}

	public void addSubmitListener(ActionListener listener) {
		btnSubmit.addActionListener(listener);

	}

	public void CancelListener(ActionListener listener) {
		btnCancel.addActionListener(listener);

	}

	public void MaleListener(ActionListener listener) {
		rdbtnMale.addActionListener(listener);
	}

	public void FemaleListener(ActionListener listener) {
		rdbtnFemale.addActionListener(listener);
	}

	public void OtherListener(ActionListener listener) {
		rdbtnOther.addActionListener(listener);
	}

	// set formatting for Masks
	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s) {
				@Override
				public char getPlaceholderCharacter() {
					return Character.MIN_VALUE; // remove default space chars
				}
			};
			;
		} catch (java.text.ParseException exc) {
			System.err.println("Bad format: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}

}
