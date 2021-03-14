package edu.usm.cos420.ConsultingRegister.delegate;

import java.util.List;

import edu.usm.cos420.ConsultingRegister.domain.Patient;
import edu.usm.cos420.ConsultingRegister.service.PatientService;

public class PatientSearchHandler {
	private PatientService atMyService;
	
	public PatientSearchHandler(PatientService atMyService) {
		this.atMyService = atMyService;
	}
	public Long getNextID() {
		return atMyService.maxPatientID()+1;
	}
		public List<Patient> searchPatientByName(String name)
	{
		return atMyService.getPatientByName(name);
	}
	
	public List<Patient> searchPatientByFirstName(String name)
	{
		return atMyService.getPatientByFirstName(name);
	}
	
	public List<Patient> searchPatientByLastName(String name)
	{
		return atMyService.getPatientByLastName(name);
	}
	
	public Patient searchPatientByID(Long ID)
	{
		return atMyService.getPatient(ID);
	}
	public List<Patient> getAll()
	{
		return  atMyService.getAll();
	}
}
