
package edu.usm.cos420.ConsultingRegister.controller;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import edu.usm.cos420.ConsultingRegister.service.PatientService;
import edu.usm.cos420.ConsultingRegister.view.NewPatientJPanel;

/**
 * A Controller class to process UI input
 * 
 */
public class NewPatientHandler {
	private NewPatientJPanel newPatient;

	private PatientService atMyService;
	private Map<String, String> formData;

	/**
	 * Constructor : pass in a service class which can provide access to cItem
	 * operations.
	 * 
	 * @param view
	 * @param service
	 */
	public NewPatientHandler(PatientService service, NewPatientJPanel patient) {
		this.atMyService = service;
		this.newPatient = patient;
		patient.addSubmitListener(new SubmitListener());
		patient.CancelListener(new CancelListener());
		patient.MaleListener(new MaleListener());
		patient.FemaleListener(new FemaleListener());
		patient.OtherListener(new OtherListener());

	}

	public Long getNextID() {
		return atMyService.maxPatientID() + 1;
	}

	/*
	 * Long id, Long nhisId, String first, String last, String Address, int
	 * phoneNumber, String birthdate, char sex, String guardian, String dependent
	 */
	public void addNewPatient(Long nhisID, String first, String last, String address, int phoneNumber, String birthdate,
			char sex) {

		// we should construct the patient in the service because it has access
		// to the next PatientID value
		atMyService.addPatient(nhisID, first, last, address, phoneNumber, birthdate, sex);
	}

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

	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StringBuilder errorText = new StringBuilder();
			boolean flag = false;

			if (newPatient.getTextFieldFirstName().getText().isEmpty()) {
				errorText.append("First Name is required.\n");
				newPatient.getTextFieldFirstName().setBackground(Color.pink);
				flag = true;
			}
			if (newPatient.getTextFieldLastName().getText().isEmpty()) {
				errorText.append("Last Name is required.\n");
				newPatient.getTextFieldFirstName().setBackground(Color.pink);
				flag = true;
			}
			if (newPatient.getTextFieldAddress().getText().isEmpty()) {
				errorText.append("Address is required.\n");
				newPatient.getTextFieldAddress().setBackground(Color.pink);
				flag = true;
			}
			if (newPatient.getFormattedDateOfBirth().getText().isEmpty()) {
				errorText.append("Date of Birth is required.\n");
				newPatient.getFormattedDateOfBirth().setBackground(Color.pink);
				flag = true;
			}

			if (flag) {
				newPatient.getTextPaneError().setVisible(true);
				newPatient.getTextPaneError().setBackground(Color.pink);
				newPatient.getTextPaneError().setText(errorText.toString());
			}

			else {

				// add complete Patient to the model

				addNewPatient(Long.parseLong(newPatient.getFormattedTextFieldNHISNumber().getText()),
						newPatient.getTextFieldFirstName().getText(), newPatient.getTextFieldLastName().getText(),
						newPatient.getTextFieldAddress().getText(),
						Integer.parseInt(newPatient.getFormattedPhoneNumber().getText()),
						newPatient.getFormattedDateOfBirth().getText().toString(), newPatient.getSex());

				// clear fields textFieldFirstName.setText("");
				newPatient.getTextFieldFirstName().setText("");
				newPatient.getTextFieldLastName().setText("");
				newPatient.getFormattedTextFieldNHISNumber().setText("");
				newPatient.getTextFieldAddress().setText("");
				newPatient.getFormattedPhoneNumber().setText("");
				newPatient.getFormattedDateOfBirth().setText("");
				newPatient.getRdbtnMale().setSelected(true);
				newPatient.getTextPaneError().setVisible(false);
				newPatient.getTextPaneError().setText(""); // reset colors
				newPatient.getTextFieldFirstName().setBackground(Color.WHITE);
				newPatient.getTextFieldLastName().setBackground(Color.WHITE);
				newPatient.getTextFieldAddress().setBackground(Color.WHITE);
				newPatient.getFormattedDateOfBirth().setBackground(Color.WHITE);
				newPatient.getTextPaneError().setBackground(Color.WHITE);
				newPatient.setVisible(true);

			}

		}
	}

	class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// clear fields
			newPatient.getTextFieldFirstName().setText("");
			newPatient.getTextFieldLastName().setText("");
			newPatient.getFormattedTextFieldNHISNumber().setText("");
			newPatient.getTextFieldAddress().setText("");
			newPatient.getFormattedPhoneNumber().setText("");
			newPatient.getFormattedDateOfBirth().setText("");
			newPatient.getRdbtnMale().setSelected(true);
			newPatient.getTextPaneError().setVisible(false);
			newPatient.getTextPaneError().setText("");
			// reset colors
			newPatient.getTextFieldFirstName().setBackground(Color.WHITE);
			newPatient.getTextFieldLastName().setBackground(Color.WHITE);
			newPatient.getTextFieldAddress().setBackground(Color.WHITE);
			newPatient.getFormattedDateOfBirth().setBackground(Color.WHITE);
			newPatient.getTextPaneError().setBackground(Color.WHITE);
			newPatient.setVisible(false);
		}

	}

	class MaleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newPatient.setSex('M');
		}
	}

	class FemaleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newPatient.setSex('F');
		}
	}

	class OtherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newPatient.setSex('O');
		}
	}

}
