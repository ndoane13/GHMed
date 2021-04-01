package edu.usm.cos420.ConsultingRegister.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class PatientDTO {
	
	public String transferType;  
    private Long outpatientId;
    public String nhisId; 
    public String firstName;  
    public String lastName;  
    public String Address;  
    public String phoneNumber; 
    public String birthdate;   
    public char sex;
    public ArrayList<Long> guardians;        
    public ArrayList<Long> dependents;     
    public HashMap<String, String> fieldErrors;
    

	public PatientDTO(Long ID) {
		transferType  = "";  
	    outpatientId = ID;
	    nhisId = ""; 
	    firstName = "";  
	    lastName = "";  
	    Address = "";  
	    phoneNumber = ""; 
	    birthdate = "";   
	    sex = 'f';
	    guardians = new ArrayList<Long>();        
	    dependents = new ArrayList<Long>();     
	    fieldErrors = new HashMap<String, String>();

	}

}
