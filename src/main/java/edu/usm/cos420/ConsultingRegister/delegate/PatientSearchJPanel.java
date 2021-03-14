package edu.usm.cos420.ConsultingRegister.delegate;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.List;
import java.beans.PropertyChangeEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import edu.usm.cos420.ConsultingRegister.domain.Patient;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

public class PatientSearchJPanel extends JPanel {
	/**
	 * @wbp.nonvisual location=282,149
	 */
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldOutPatientId;
	
	private JTable table;
	private JLabel lblLastName;
	private JLabel lblOutpatientId;
	private DefaultListModel listModel;
	private JButton btnCancel;
	private int size = 0;
	private String[][] rec;
	private String col[] = { "ID", "First Name", "Last Name", "Address" };

	/**
	 * Create the panel.
	 */
	public PatientSearchJPanel(final PatientSearchHandler handler) {
		setBounds(100, 100, 600, 600);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);

		JButton JButtonSubmit = new JButton("Submit");

		textFieldOutPatientId = new JTextField();
		textFieldOutPatientId.setColumns(10);
		listModel = new DefaultListModel();

		JLabel lblFirstName = new JLabel("First Name");

		lblLastName = new JLabel("Last Name");

		lblOutpatientId = new JLabel("Outpatient ID");

		btnCancel = new JButton("Cancel");
		rec = new String[size][4];

		final JScrollPane scrollPane = new JScrollPane();
		table = new JTable(rec, col);
		JTableHeader header = table.getTableHeader();

		scrollPane.setViewportView(table);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLastName.setText("");
				textFieldFirstName.setText("");
				textFieldOutPatientId.setText("");
				setVisible(false);
			}
		});

		JButtonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listModel.clear();

				StringBuilder errorText = new StringBuilder();

				if (!(textFieldOutPatientId.getText().isBlank())) {
					try {
						Long temp = Long.parseLong(textFieldOutPatientId.getText());
						Patient temp2 = handler.searchPatientByID(temp);
						listModel.addElement(temp2);
						textFieldOutPatientId.setText("");
					} catch (NumberFormatException nfe) {

					}

				}

				else if (!(textFieldFirstName.getText().isBlank()) && (!(textFieldLastName.getText().isBlank()))) {
					String temp = textFieldFirstName.getText() + " " + textFieldLastName.getText();
					List<Patient> temp2 = handler.searchPatientByName(temp);

					for (int i = 0; i < temp2.size(); ++i) {
						listModel.addElement(temp2.get(i));
					}

					textFieldFirstName.setText("");
					textFieldLastName.setText("");

				}

				else if (!(textFieldFirstName.getText().isBlank()) && ((textFieldLastName.getText().isBlank()))) {
					String temp = textFieldFirstName.getText();
					List<Patient> temp2 = handler.searchPatientByFirstName(temp);

					for (int i = 0; i < temp2.size(); ++i) {
						listModel.addElement(temp2.get(i));
					}
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
				}

				else if ((textFieldFirstName.getText().isBlank()) && (!(textFieldLastName.getText().isBlank()))) {
					String temp = textFieldLastName.getText();
					List<Patient> temp2 = handler.searchPatientByLastName(temp);

					for (int i = 0; i < temp2.size(); i++) {
						listModel.addElement(temp2.get(i));
					}
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
				}
				size = listModel.getSize();
				rec = new String[size][4];
				for (int i = 0; i < size; i++) {
					// System.out.println(listModel.getElementAt(i));
					Patient patient = (Patient) listModel.getElementAt(i);
					rec[i][0] = patient.getId() + "";
					rec[i][1] = patient.getFirstName();
					rec[i][2] = patient.getLastName();
					rec[i][3] = patient.getAddress();

					// System.out.println(rec[0][1]);
				}
				table = new JTable(rec, col);
				JTableHeader header = table.getTableHeader();
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane.setViewportView(table);
				table.setFocusable(false);
				
				table.addMouseListener(new MouseAdapter() {
			         public void mouseClicked(MouseEvent me) {
			            if (me.getClickCount() == 1) {     // to detect doble click events
			               JTable target = (JTable)me.getSource();
			               int row = target.getSelectedRow(); // select a row
			              // int column = target.getSelectedColumn(); // select a column
			              JOptionPane.showInternalMessageDialog(null, "ID Number = "+table.getValueAt(row, 0)+"\n"+"Name = "+table.getValueAt(row, 1) 
			              +table.getValueAt(row, 2)+"\n"+"Address = "+table.getValueAt(row, 3)); // get the value of a row and column.
			            }
			         }
			      });
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textFieldOutPatientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblOutpatientId, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(64)
									.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addComponent(JButtonSubmit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))))
					.addGap(109))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldOutPatientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(JButtonSubmit))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName)
										.addComponent(lblOutpatientId)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblLastName)))
							.addGap(66)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnCancel))))
		);
		setLayout(groupLayout);

	}
}
