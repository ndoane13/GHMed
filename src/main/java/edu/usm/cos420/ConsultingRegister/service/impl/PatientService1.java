package edu.usm.cos420.ConsultingRegister.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.usm.cos420.ConsultingRegister.dao.domain.PatientDao;
import edu.usm.cos420.ConsultingRegister.domain.Patient;
import edu.usm.cos420.ConsultingRegister.service.PatientService;

/**
 * 
 * The Example1 Service Layer Implementation is based a design pattern which
 * aims to organize the functionality of the application into logical units that
 * are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 *
 */
public class PatientService1 implements PatientService {

	PatientDao dao;

	/**
	 * Default Constructor creates a default CItemDao object
	 */
	public PatientService1() {
		this.dao = new PatientDao();
	}

	/**
	 * Constructor with the DAO provided
	 * 
	 * @param dao
	 *            Data Access Object to use in the service
	 */
	public PatientService1(PatientDao dao) {
		this.dao = dao;
	}
	
	
	
	public void addPatient(Long nhisID, String first, String last, 
    		String address, int phoneNumber, String birthdate, char sex) {
		
		Long id = this.maxPatientID() + 1; 
		Patient patient = new Patient(id, nhisID, first, last, address, 
				phoneNumber, birthdate, sex);
		dao.add(patient);
	}

	public List<Patient> getAll()
	{
		return dao.list();
	}
	
	/**
	 * Calculate the maximum ID value of elements in the repository
	 * 
	 * @return the maximum id of a CItem in the repository
	 */

	public Long maxPatientID() {
		List<Patient> clist = dao.list();
		Long max = 0L;
		if (clist.isEmpty())
			return max;
		else {
		Iterator<Patient> iter = clist.iterator();
   		 max = iter.next().getId();
   		 while (iter.hasNext())
   		 {
   			 Patient anItem = iter.next();
   			 if (anItem.getId() > max)
   			     max = anItem.getId();
   		 }
   		 return max;	
		}
	}

	@Override
	public Patient getPatient(Long ID) {
		// TODO Auto-generated method stub
		return dao.find(ID);
	}
	
	
	
	public List<Patient> getPatientByName(String name)
	{
		List<Patient> temp = dao.list();
		List<Patient> returnList = new ArrayList<Patient>();

		
		for (int i = 0; i < temp.size(); ++i)
		{
			Patient cur = temp.get(i);
			if (!((cur.getName().compareTo(name)) != 0))
			{
				returnList.add(cur);
			}
		}
		
		return returnList;
	}
	
	
	public List<Patient> getPatientByFirstName(String name)
	{
		List<Patient> temp = dao.list();
		List<Patient> returnList = new ArrayList<Patient>();

		
		for (int i = 0; i < temp.size(); ++i)
		{
			Patient cur = temp.get(i);
			if (!((cur.getFirstName().compareTo(name)) != 0))
			{
				returnList.add(cur);
			}
		}
		
		return returnList;
	}
	
	public List<Patient> getPatientByLastName(String name)
	{
		List<Patient> temp = dao.list();
		List<Patient> returnList = new ArrayList<Patient>();
		for (int i = 0; i < temp.size(); ++i)
		{
			Patient cur = temp.get(i);
			if (!((cur.getLastName().compareTo(name)) != 0))
			{
				returnList.add(cur);
			}
		}
		
		return returnList;
	}
}
