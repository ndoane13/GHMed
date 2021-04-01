package edu.usm.cos420.ConsultingRegister.controller;

import edu.usm.cos420.ConsultingRegister.domain.Patient;
import edu.usm.cos420.ConsultingRegister.service.PatientService;

public class PatientDetailHandler {
	public Patient patient;
	private PatientService service;
	

	public PatientDetailHandler(PatientService service, Long patientID) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.patient = service.getPatient(patientID);
	}

}
