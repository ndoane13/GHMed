package edu.usm.cos420.ConsultingRegister.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import edu.usm.cos420.ConsultingRegister.domain.Patient;
import edu.usm.cos420.ConsultingRegister.service.PatientService;
import edu.usm.cos420.ConsultingRegister.view.PatientSearchJPanel;

public class PatientSearchHandler {
	private PatientService atMyService;
	private PatientSearchJPanel newSearchPanel;

	public PatientSearchHandler(PatientService atMyService, PatientSearchJPanel searchPanel) {
		this.atMyService = atMyService;
		this.newSearchPanel = searchPanel;
		searchPanel.addSubmitListener(new SubmitListener());
		searchPanel.addCancelListener(new CancelListener());
	}

	public Long getNextID() {
		return atMyService.maxPatientID() + 1;
	}

	public List<Patient> searchPatientByName(String name) {
		return atMyService.getPatientByName(name);
	}

	public List<Patient> searchPatientByFirstName(String name) {
		return atMyService.getPatientByFirstName(name);
	}

	public List<Patient> searchPatientByLastName(String name) {
		return atMyService.getPatientByLastName(name);
	}

	public Patient searchPatientByID(Long ID) {
		return atMyService.getPatient(ID);
	}

	public List<Patient> getAll() {
		return atMyService.getAll();
	}

	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newSearchPanel.getListModel().clear();
			int size = 0;
			String[][] rec;

			if (!(newSearchPanel.getTextFieldOutPatientId().getText().isBlank())) {
				try {
					Long temp = Long.parseLong(newSearchPanel.getTextFieldOutPatientId().getText());
					Patient temp2 = searchPatientByID(temp);
					newSearchPanel.getListModel().addElement(temp2);
					newSearchPanel.getTextFieldOutPatientId().setText("");
				} catch (NumberFormatException nfe) {

				}

			}

			else if (!(newSearchPanel.getTextFieldFirstName().getText().isBlank())
					&& (!(newSearchPanel.getTextFieldLastName().getText().isBlank()))) {
				String temp = newSearchPanel.getTextFieldFirstName().getText() + " "
						+ newSearchPanel.getTextFieldLastName().getText();
				List<Patient> temp2 = searchPatientByName(temp);

				for (int i = 0; i < temp2.size(); ++i) {
					newSearchPanel.getListModel().addElement(temp2.get(i));
				}

				newSearchPanel.getTextFieldFirstName().setText("");
				newSearchPanel.getTextFieldLastName().setText("");

			}

			else if (!(newSearchPanel.getTextFieldFirstName().getText().isBlank())
					&& ((newSearchPanel.getTextFieldLastName().getText().isBlank()))) {
				String temp = newSearchPanel.getTextFieldFirstName().getText();
				List<Patient> temp2 = searchPatientByFirstName(temp);

				for (int i = 0; i < temp2.size(); ++i) {
					newSearchPanel.getListModel().addElement(temp2.get(i));
				}
				newSearchPanel.getTextFieldFirstName().setText("");
				newSearchPanel.getTextFieldLastName().setText("");
			}

			else if ((newSearchPanel.getTextFieldFirstName().getText().isBlank())
					&& (!(newSearchPanel.getTextFieldLastName().getText().isBlank()))) {
				String temp = newSearchPanel.getTextFieldLastName().getText();
				List<Patient> temp2 = searchPatientByLastName(temp);

				for (int i = 0; i < temp2.size(); i++) {
					newSearchPanel.getListModel().addElement(temp2.get(i));
				}
				newSearchPanel.getTextFieldFirstName().setText("");
				newSearchPanel.getTextFieldLastName().setText("");
			}
			size = newSearchPanel.getListModel().getSize();
			newSearchPanel.setSize(size);
			rec = new String[size][4];
			newSearchPanel.setRec(rec);
			try {
				for (int i = 0; i < size; i++) {
					// System.out.println(listModel.getElementAt(i));
					Patient patient = (Patient) newSearchPanel.getListModel().getElementAt(i);
					rec[i][0] = patient.getId() + "";
					rec[i][1] = patient.getFirstName();
					rec[i][2] = patient.getLastName();
					rec[i][3] = patient.getAddress();

					// System.out.println(rec[0][1]);
				}
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(newSearchPanel, "ID not found", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			newSearchPanel.setRec(rec);
			newSearchPanel.setTable(new JTable(rec, newSearchPanel.getCol()));
			JTableHeader header = newSearchPanel.getTable().getTableHeader();
			newSearchPanel.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			newSearchPanel.getScrollPane().setViewportView(newSearchPanel.getTable());
			newSearchPanel.getTable().setFocusable(false);
			newSearchPanel.getTable().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					if (me.getClickCount() == 1) { // to detect doble click events
						JTable target = (JTable) me.getSource();
						int row = target.getSelectedRow(); // select a row
						// int column = target.getSelectedColumn(); // select a column
						JOptionPane.showInternalMessageDialog(newSearchPanel,
								"ID Number = " + newSearchPanel.getTable().getValueAt(row, 0) + "\n" + "Name = "
										+ newSearchPanel.getTable().getValueAt(row, 1)
										+ newSearchPanel.getTable().getValueAt(row, 2) + "\n" + "Address = "
										+ newSearchPanel.getTable().getValueAt(row, 3)); // get // the
						// value
						// of
						// a
						// row
						// and
						// column.

					}
				}
			});

		}
	}

	class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newSearchPanel.getTextFieldLastName().setText("");
			newSearchPanel.getTextFieldFirstName().setText("");
			newSearchPanel.getTextFieldOutPatientId().setText("");
			newSearchPanel.setVisible(false);
		}
	}
}
