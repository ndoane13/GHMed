package edu.usm.cos420.ConsultingRegister.dao.domain;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import edu.usm.cos420.ConsultingRegister.dao.GenericDao;
import edu.usm.cos420.ConsultingRegister.dao.JsonDao;
import edu.usm.cos420.ConsultingRegister.domain.Patient;

import java.lang.reflect.Type;

/**
 * 
 * @author Nick Doane<br>
 * Data access object for person entities
 *
 */
public class PatientDao {

    private GenericDao<Long,Patient> patientDao;
    
    public PatientDao()
    {
        Type t = new TypeToken<Map<Long, Patient>>(){}.getType(); 
        patientDao = new JsonDao<>("patient.json",t); 
    }
    
    public PatientDao(GenericDao<Long,Patient> dao){
        patientDao = dao;
    }
    
    public GenericDao<Long, Patient> getPatientDao(){
        return patientDao;
    }
    
    public void add(Patient entity){
        patientDao.add(entity.getId(), entity);
    }
    
    public void update(Patient entity){
        patientDao.update(entity.getId(), entity);
    }
    
    public void remove(Long ID){
        patientDao.remove(ID);
    }
    
    public Patient find(Long key){
        return patientDao.find(key);
    }
    
    public List<Patient> list(){
        return patientDao.list();
    }
}
