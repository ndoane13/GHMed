package edu.usm.cos420.ConsultingRegister.delegate;

import edu.usm.cos420.ConsultingRegister.service.PatientService;

/**
 *   A Controller class to process UI input
 *   
 */	 
public class NewPatientHandler {

	private PatientService atMyService; 
	
	/**
	 * Constructor : pass in a service class which can provide access to cItem operations. 
	 * @param view 
	 * @param service
	 */
	public NewPatientHandler(PatientService service)
	{
		this.atMyService = service;
	}

	public Long getNextID() {
		return atMyService.maxPatientID() + 1;
	}

	/*
	 * Long id, Long nhisId, String first, String last, 
    		String Address, int phoneNumber, String birthdate, char sex, 
    		String guardian, String dependent
	 */
	public void addNewPatient(Long nhisID, String first, String last, 
    		String address, int phoneNumber, String birthdate, char sex) {
		
		// we should construct the patient in the service because it has access
		// to the next PatientID value
    	atMyService.addPatient(nhisID, first, last, address, phoneNumber, birthdate, sex);
	}
	  
}
