package edu.usm.cos420.ConsultingRegister.service;

import java.util.Date;

import java.util.List;

import edu.usm.cos420.ConsultingRegister.domain.Visit;

/**
 * 
 * The Example1 Service Interface is based a design pattern which aims to
 * organize the functionality of the application into logical units that are
 * typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 *
 */
public interface VisitService {

	/**
	 * Add a randomly generated CItem element to the repository
	 */
	public void addAVisitInformation(Long iD, String date, boolean newOldCase, String bloodPressure, String pulse,
			String temperature, String weight, String respiration, String primaryDx, String secondaryDx,
			String treatment, boolean referral, String outcomeOfReferral, String cost, String note);

	/**
	 * return the list of CItems from the repository
	 */
	public List<Visit> getAll();

	/**
	 * Calculate the maximum ID value of elements in the repository
	 * 
	 * @return the maximum id of a CItem in the repository
	 */
	public Long maxCItemId();

}
