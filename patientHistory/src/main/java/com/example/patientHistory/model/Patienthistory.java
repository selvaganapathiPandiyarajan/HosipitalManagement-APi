package com.example.patientHistory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Builder
@Table(name = "patient_history")
public class Patienthistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer historyId;
private String email;
private Integer age;
private Double temp;
private Double bP;
private Double weight;
private String symtoms;
private String percerption;
private String appointmentDate;
private String nextAppointmentDate;
private Integer doctorId;
private String   doctorName;
private String  doctorDesignation;
private String   patientDetails;
private Integer amount;
private String icuNo;
public String getIcuNo() {
	return icuNo;
}
public void setIcuNo(String icuNo) {
	this.icuNo = icuNo;
}
public Integer getHistoryId() {
	return historyId;
}
public void setHistoryId(Integer historyId) {
	this.historyId = historyId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Double getTemp() {
	return temp;
}
public void setTemp(Double temp) {
	this.temp = temp;
}
public Double getbP() {
	return bP;
}
public void setbP(Double bP) {
	this.bP = bP;
}
public Double getWeight() {
	return weight;
}
public void setWeight(Double weight) {
	this.weight = weight;
}
public String getSymtoms() {
	return symtoms;
}
public void setSymtoms(String symtoms) {
	this.symtoms = symtoms;
}
public String getPercerption() {
	return percerption;
}
public void setPercerption(String percerption) {
	this.percerption = percerption;
}
public String getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(String appointmentDate) {
	this.appointmentDate = appointmentDate;
}
public String getNextAppointmentDate() {
	return nextAppointmentDate;
}
public void setNextAppointmentDate(String nextAppointmentDate) {
	this.nextAppointmentDate = nextAppointmentDate;
}
public Integer getDoctorId() {
	return doctorId;
}
public void setDoctorId(Integer doctorId) {
	this.doctorId = doctorId;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getDoctorDesignation() {
	return doctorDesignation;
}
public void setDoctorDesignation(String doctorDesignation) {
	this.doctorDesignation = doctorDesignation;
}
public String getPatientDetails() {
	return patientDetails;
}
public void setPatientDetails(String patientDetails) {
	this.patientDetails = patientDetails;
}
public Patienthistory() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public Patienthistory(Integer historyId, String email, Integer age, Double temp, Double bP, Double weight,
		String symtoms, String percerption, String appointmentDate, String nextAppointmentDate, Integer doctorId,
		String doctorName, String doctorDesignation, String patientDetails, String icuNo, Integer amount) {
	super();
	this.historyId = historyId;
	this.email = email;
	this.age = age;
	this.temp = temp;
	this.bP = bP;
	this.weight = weight;
	this.symtoms = symtoms;
	this.percerption = percerption;
	this.appointmentDate = appointmentDate;
	this.nextAppointmentDate = nextAppointmentDate;
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.doctorDesignation = doctorDesignation;
	this.patientDetails = patientDetails;
	this.icuNo = icuNo;
	this.amount = amount;
}

}
