package edu.usm.cos420.ConsultingRegister;



import edu.usm.cos420.ConsultingRegister.delegate.NewPatientJPanel;



import edu.usm.cos420.ConsultingRegister.delegate.PatientDetailHandler;

import edu.usm.cos420.ConsultingRegister.delegate.PatientSearchHandler;
import edu.usm.cos420.ConsultingRegister.delegate.PatientSearchJPanel;

import java.util.LinkedHashMap;

import javax.swing.JPanel;

import edu.usm.cos420.ConsultingRegister.delegate.GUIStack;
import edu.usm.cos420.ConsultingRegister.delegate.NewPatientHandler;

import edu.usm.cos420.ConsultingRegister.service.PatientService;
import edu.usm.cos420.ConsultingRegister.service.impl.PatientService1;

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
		
		// instantiate your Handlers and JPanels here
		PatientService service = new PatientService1();
		NewPatientHandler newPatientHandler = new NewPatientHandler(service);
		NewPatientJPanel newPatient = new NewPatientJPanel(newPatientHandler);
		
		PatientSearchHandler patientHandler = new PatientSearchHandler(service);
		PatientSearchJPanel searchPanel = new PatientSearchJPanel(patientHandler);
		
		// pass in example Patient Detail view
//		PatientDetailHandler patientDetailHandler = new PatientDetailHandler(service, Long.valueOf(1));
//		PatientDetailJPanel patientDetail = new PatientDetailJPanel(patientDetailHandler);
		
		
		// add your JPanels to LinkedHashMap here
		
		JPanelList.put("New Patient", newPatient);
//		JPanelList.put("Patient Detail", patientDetail);
		JPanelList.put("Patient Search", searchPanel);
		
		
		
		
		
		// create the card container and main view, pass the other frames
		GUIStack app = new GUIStack(JPanelList);
    }
}
