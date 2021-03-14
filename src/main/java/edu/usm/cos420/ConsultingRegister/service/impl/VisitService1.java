package edu.usm.cos420.ConsultingRegister.service.impl;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.ConsultingRegister.dao.domain.VisitDao;

import edu.usm.cos420.ConsultingRegister.domain.Visit;
import edu.usm.cos420.ConsultingRegister.service.VisitService;

/**
 * 
 * The Example1 Service Layer Implementation is based a design pattern which
 * aims to organize the functionality of the application into logical units that
 * are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 *
 */
public class VisitService1 implements VisitService {

	VisitDao dao;

	/**
	 * Default Constructor creates a default CItemDao object
	 */
	public VisitService1() {
		this.dao = new VisitDao();
	}

	/**
	 * Constructor with the DAO provided
	 * 
	 * @param dao Data Access Object to use in the service
	 */
	public VisitService1(VisitDao dao) {
		this.dao = dao;
	}

	/**
	 * Add a generated Visit element to the repository
	 */

	public void addAVisitInformation( Long iD, String date, boolean newOldCase, String bloodPressure, String pulse,
			String temperature, String weight, String respiration, String primaryDx, String secondaryDx,
			String treatment, boolean referral, String outcomeOfReferral, String cost, String note ) {

		Visit visit = new Visit(iD,date, newOldCase, bloodPressure, pulse, temperature, weight, respiration, primaryDx,
				secondaryDx, treatment, referral, outcomeOfReferral, cost, note );
		dao.add(visit);
	}

	/**
	 * Calculate the maximum ID value of elements in the repository
	 * 
	 * @return the maximum id of a CItem in the repository
	 */

	@Override
	public List<Visit> getAll() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public Long maxCItemId() {
		// TODO Auto-generated method stub
		return null;
	}

}
