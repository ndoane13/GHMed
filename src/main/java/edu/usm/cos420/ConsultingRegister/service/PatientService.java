package edu.usm.cos420.ConsultingRegister.service;

import java.util.List;

import edu.usm.cos420.ConsultingRegister.domain.Patient;

public interface PatientService {
	
    public void addPatient(Long nhisID, String first, String last, 
    		String address, int phoneNumber, String birthdate, char sex);
	/**
	 * return the list of CItems from the repository
	 */
    
    public List<Patient> getAll();
    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxPatientID();
	public Patient getPatient(Long id);
	
	public List<Patient> getPatientByName(String name);
	public List<Patient> getPatientByFirstName(String name);
	public List<Patient> getPatientByLastName(String name);


}
