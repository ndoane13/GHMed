package edu.usm.cos420.ConsultingRegister.dao.domain;

import java.util.List;

import java.util.Map;

import com.google.gson.reflect.TypeToken;

import edu.usm.cos420.ConsultingRegister.dao.GenericDao;
import edu.usm.cos420.ConsultingRegister.dao.JsonDao;
import edu.usm.cos420.ConsultingRegister.domain.Visit;

import java.lang.reflect.Type;

/**
 * 
 * A Data Access Object specifically for CItem entities
 * 
 */
public class VisitDao {
	private GenericDao<Long, Visit> VisitDao;

	/**
	 * Default constructor creates an Json file called citem.json TypeToken allows
	 * the GSON parser to map to/from JSON to objects
	 */
	public VisitDao() {
		Type t = new TypeToken<Map<Long, Visit>>() {
		}.getType();
		VisitDao = new JsonDao<>("Visit.json", t);
	}

	/**
	 * Constructor where the filename is provided
	 */
	public VisitDao(String fileName) {
		Type t = new TypeToken<Map<Long, Visit>>() {
		}.getType();
		VisitDao = new JsonDao<>(fileName, t);
	}

	/**
	 * Support for other DAOs is provided
	 * 
	 * @param dao a Data Access Object class that implements GenericDao<Long,CItem>
	 */
	public VisitDao(GenericDao<Long, Visit> dao) {
		VisitDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * 
	 * @return a DAO that implements GenericDao<Long,CItem>
	 */
	public GenericDao<Long, Visit> getCItemDao() {
		return VisitDao;
	}

	/**
	 * Add a CItem to the DAO repository
	 * 
	 * @param entity any CItem object
	 */
	public void add(Visit entity) {
		VisitDao.add(entity.getID(), entity);
	}

	/**
	 * Update a CItem in the DAO repository
	 * 
	 * @param entity any CItem object
	 */
	public void update(Visit entity) {
		VisitDao.update(entity.getID(), entity);
	}

	/**
	 * Remove a CItem in the DAO repository
	 * 
	 * @param id of the CItem object to remove
	 */

	public void remove(Long id) {
		VisitDao.remove(id);
	}

	/**
	 * Find a CItem in the DAO repository
	 * 
	 * @param id of the CItem object to locate
	 * @return the CItem with id field equal to key
	 */
	public Visit find(Long key) {
		return VisitDao.find(key);
	}

	/**
	 * Generate a list of CItems in the DAO repository
	 * 
	 * @return List of CItems
	 */

	public List<Visit> list() {
		return VisitDao.list();
	}

}
