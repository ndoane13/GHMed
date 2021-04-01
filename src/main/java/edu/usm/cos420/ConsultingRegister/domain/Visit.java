package edu.usm.cos420.ConsultingRegister.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Visit implements Serializable {

	private static final long serialVersionUID = 7526472295622771666L;
	private static Long COUNTER = 0L;
	private String date;
	private boolean newOldCase;
	private String bloodPressure;
	private String Pulse;
	private String temperature;
	private String weight;
	private String respiration;
	private String primaryDx;
	private String secondaryDx;
	private String treatment;
	private boolean referral;
	private String OutcomeOfReferral;
	private String Cost;
	private String Note;
	private Long ID;

	public Visit( Long iD,String date, boolean newOldCase, String bloodPressure, String pulse, String temperature,
			String weight, String respiration, String primaryDx, String secondaryDx, String treatment,
			boolean referral, String outcomeOfReferral, String cost, String note) {

		this.date = date;
		this.newOldCase = newOldCase;
		this.bloodPressure = bloodPressure;
		this.Pulse = pulse;
		this.temperature = temperature;
		this.weight = weight;
		this.respiration = respiration;
		this.primaryDx = primaryDx;
		this.secondaryDx = secondaryDx;
		this.treatment = treatment;
		this.referral = referral;
		this.OutcomeOfReferral = outcomeOfReferral;
		this.Cost = cost;
		this.Note = note;
		this.ID = iD;
	}

	/**
	 * @return the iD
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the newOldCase
	 */
	public boolean getNewOldCase() {
		return newOldCase;
	}

	/**
	 * @param newOldCase the newOldCase to set
	 */
	public void setNewOldCase(boolean newOldCase) {
		this.newOldCase = newOldCase;
	}

	/**
	 * @return the bloodPressure
	 */
	public String getBloodPressure() {
		return bloodPressure;
	}

	/**
	 * @param bloodPressure the bloodPressure to set
	 */
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	/**
	 * @return the pulse
	 */
	public String getPulse() {
		return Pulse;
	}

	/**
	 * @param pulse the pulse to set
	 */
	public void setPulse(String pulse) {
		Pulse = pulse;
	}

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the respiration
	 */
	public String getRespiration() {
		return respiration;
	}

	/**
	 * @param respiration the respiration to set
	 */
	public void setRespiration(String respiration) {
		this.respiration = respiration;
	}

	/**
	 * @return the primaryDx
	 */
	public String getPrimaryDx() {
		return primaryDx;
	}

	/**
	 * @param primaryDx the primaryDx to set
	 */
	public void setPrimaryDx(String primaryDx) {
		this.primaryDx = primaryDx;
	}

	/**
	 * @return the secondaryDx
	 */
	public String getSecondaryDx() {
		return secondaryDx;
	}

	/**
	 * @param secondaryDx the secondaryDx to set
	 */
	public void setSecondaryDx(String secondaryDx) {
		this.secondaryDx = secondaryDx;
	}

	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the referral
	 */
	public boolean isReferral() {
		return referral;
	}

	/**
	 * @param referral the referral to set
	 */
	public void setReferral(boolean referral) {
		this.referral = referral;
	}

	/**
	 * @return the outcomeOfReferral
	 */
	public String getOutcomeOfReferral() {
		return OutcomeOfReferral;
	}

	/**
	 * @param outcomeOfReferral the outcomeOfReferral to set
	 */
	public void setOutcomeOfReferral(String outcomeOfReferral) {
		OutcomeOfReferral = outcomeOfReferral;
	}

	/**
	 * @return the cost
	 */
	public String getCost() {
		return Cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		Cost = cost;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return Note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	private Long generateID() {
		return COUNTER++;
	}

}
