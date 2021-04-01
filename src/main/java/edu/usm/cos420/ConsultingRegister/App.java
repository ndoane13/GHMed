package edu.usm.cos420.ConsultingRegister;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.usm.cos420.ConsultingRegister.controller.NewPatientHandler;
import edu.usm.cos420.ConsultingRegister.controller.PatientDetailHandler;
import edu.usm.cos420.ConsultingRegister.controller.PatientSearchHandler;
import edu.usm.cos420.ConsultingRegister.service.PatientService;
import edu.usm.cos420.ConsultingRegister.service.impl.PatientService1;
import edu.usm.cos420.ConsultingRegister.view.GUIStack;
import edu.usm.cos420.ConsultingRegister.view.NewPatientJPanel;
import edu.usm.cos420.ConsultingRegister.view.PatientSearchJPanel;

/**
 * Top level application class that coordinates the calls to GUI and handlers
 *
 */
public class App
{	
    /**
     * Entry point for application : calls {@link #provideCItemAccess()}
     * @param args  main program arguments, currently not used
     */
	public static void main( String[] args )
    {
		// HashMap of JPanel UI Objects to pass to our main JFrame 
		// so we can set up our CardLayout view. The String key
		// is the name of the JPanel the CardLayout uses to find
		// the card when switching between them. 
		LinkedHashMap<String, JPanel> JPanelList = new LinkedHashMap<>();
		/*
		 * JPanel cards; cards = new JPanel(new CardLayout()); CardLayout cl =
		 * (CardLayout)(cards.getLayout());
		 * 
		 * // instantiate your Handlers and JPanels here
		 */		
		PatientService service = new PatientService1();
		NewPatientJPanel newPatient = new NewPatientJPanel();
		NewPatientHandler newPatientHandler = new NewPatientHandler(service,newPatient);
		
		/*
		 * // Create and set up the window. JFrame frame = new JFrame("Clinic Portal");
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.getContentPane();
		 */
		 

		 
		

		/*
		 * //Create main view card JPanel card1 = newPatient; cards.add(card1,
		 * "New Patient"); cl.show(cards, "New Patient");
		 */

		/*
		 * // add all cards to the JFrame frame.getContentPane().add(cards,
		 * BorderLayout.CENTER);
		 * 
		 * //TODO: Determine the best way to size the initial/subsequent frames
		 * //frame.pack(); frame.setBounds(100, 100, 550, 500);
		 * 
		 * //Display the window. frame.setVisible(true);
		 */

	
		
		
		PatientSearchJPanel searchPanel = new PatientSearchJPanel();
		  PatientSearchHandler patientHandler = new PatientSearchHandler(service,searchPanel);
		  
		  
			/*
			 * // pass in example Patient Detail view // PatientDetailHandler
			 * patientDetailHandler = new PatientDetailHandler(service, Long.valueOf(1)); //
			 * PatientDetailJPanel patientDetail = new
			 * PatientDetailJPanel(patientDetailHandler);
			 */
		  
		  
		  // add your JPanels to LinkedHashMap here
		  
		  JPanelList.put("New Patient", newPatient); //
		  //JPanelList.put("Patient Detail", patientDetail);
		  JPanelList.put("Patient Search", searchPanel);
		  
		  
		  
		  
		  
		  // create the card container and main view, pass the other frames
		  GUIStack app = new GUIStack(JPanelList);
		 
    }
}
