package edu.usm.cos420.ConsultingRegister.view;

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
	private final JScrollPane scrollPane;
	JButton JButtonSubmit;

	/**
	 * Create the panel.
	 */
	public PatientSearchJPanel() {
		setBounds(100, 100, 600, 600);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);

		JButtonSubmit = new JButton("Submit");

		textFieldOutPatientId = new JTextField();
		textFieldOutPatientId.setColumns(10);
		listModel = new DefaultListModel();

		JLabel lblFirstName = new JLabel("First Name");

		lblLastName = new JLabel("Last Name");

		lblOutpatientId = new JLabel("Outpatient ID");

		btnCancel = new JButton("Cancel");
		rec = new String[size][4];

		scrollPane = new JScrollPane();
		table = new JTable(rec, col);
		JTableHeader header = table.getTableHeader();

		scrollPane.setViewportView(table);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(47)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldOutPatientId, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(27).addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblOutpatientId, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE)
										.addGap(64).addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 74,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addGap(10).addComponent(lblLastName,
														GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												groupLayout.createSequentialGroup()
														.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(JButtonSubmit, GroupLayout.PREFERRED_SIZE,
																		73, GroupLayout.PREFERRED_SIZE))))))
				.addGap(109)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldOutPatientId, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(JButtonSubmit))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(6)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblFirstName).addComponent(lblOutpatientId)))
										.addGroup(groupLayout.createSequentialGroup().addGap(4)
												.addComponent(lblLastName)))
								.addGap(66)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(btnCancel)))));
		setLayout(groupLayout);

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
	 * @return the textFieldOutPatientId
	 */
	public JTextField getTextFieldOutPatientId() {
		return textFieldOutPatientId;
	}

	/**
	 * @param textFieldOutPatientId the textFieldOutPatientId to set
	 */
	public void setTextFieldOutPatientId(JTextField textFieldOutPatientId) {
		this.textFieldOutPatientId = textFieldOutPatientId;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the lblLastName
	 */
	public JLabel getLblLastName() {
		return lblLastName;
	}

	/**
	 * @param lblLastName the lblLastName to set
	 */
	public void setLblLastName(JLabel lblLastName) {
		this.lblLastName = lblLastName;
	}

	/**
	 * @return the lblOutpatientId
	 */
	public JLabel getLblOutpatientId() {
		return lblOutpatientId;
	}

	/**
	 * @param lblOutpatientId the lblOutpatientId to set
	 */
	public void setLblOutpatientId(JLabel lblOutpatientId) {
		this.lblOutpatientId = lblOutpatientId;
	}

	/**
	 * @return the listModel
	 */
	public DefaultListModel getListModel() {
		return listModel;
	}

	/**
	 * @param listModel the listModel to set
	 */
	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	/**
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel the btnCancel to set
	 */
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	/**
	 * @return the size
	 */
	public int getsize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the rec
	 */
	public String[][] getRec() {
		return rec;
	}

	/**
	 * @param rec the rec to set
	 */
	public void setRec(String[][] rec) {
		this.rec = rec;
	}

	/**
	 * @return the col
	 */
	public String[] getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(String[] col) {
		this.col = col;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void addSubmitListener(ActionListener listener) {
		JButtonSubmit.addActionListener(listener);

	}
	public void addCancelListener(ActionListener listener) {
		btnCancel.addActionListener(listener);
	}

}
