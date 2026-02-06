package com.example.HospitalDetails.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="doctor_details")
public class doctorDetails {
	
		    @Id
	    private Long doctorid;

	    private String doctorname;
	    private String doctordept;
	    private String doctorloc;
	    private String doctoremail;
	    private String password;

	    private Long doctorphone;

	    private BigDecimal salary;
	    private BigDecimal basicsalary;
	    private BigDecimal hra;
	    private BigDecimal allowance;
	    private BigDecimal deductions;
	    private BigDecimal grosssalary;
	    private BigDecimal netsalary;

	    private String doctoraddress;
	    private String speacification;

	    private String doj; // 👈 keep String for now (important!)

		public Long getDoctorid() {
			return doctorid;
		}

		public void setDoctorid(Long doctorid) {
			this.doctorid = doctorid;
		}

		public String getDoctorname() {
			return doctorname;
		}

		public void setDoctorname(String doctorname) {
			this.doctorname = doctorname;
		}

		public String getDoctordept() {
			return doctordept;
		}

		public void setDoctordept(String doctordept) {
			this.doctordept = doctordept;
		}

		public String getDoctorloc() {
			return doctorloc;
		}

		public void setDoctorloc(String doctorloc) {
			this.doctorloc = doctorloc;
		}

		public String getDoctoremail() {
			return doctoremail;
		}

		public void setDoctoremail(String doctoremail) {
			this.doctoremail = doctoremail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Long getDoctorphone() {
			return doctorphone;
		}

		public void setDoctorphone(Long doctorphone) {
			this.doctorphone = doctorphone;
		}

		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

		public BigDecimal getBasicsalary() {
			return basicsalary;
		}

		public void setBasicsalary(BigDecimal basicsalary) {
			this.basicsalary = basicsalary;
		}

		public BigDecimal getHra() {
			return hra;
		}

		public void setHra(BigDecimal hra) {
			this.hra = hra;
		}

		public BigDecimal getAllowance() {
			return allowance;
		}

		public void setAllowance(BigDecimal allowance) {
			this.allowance = allowance;
		}

		public BigDecimal getDeductions() {
			return deductions;
		}

		public void setDeductions(BigDecimal deductions) {
			this.deductions = deductions;
		}

		public BigDecimal getGrosssalary() {
			return grosssalary;
		}

		public void setGrosssalary(BigDecimal grosssalary) {
			this.grosssalary = grosssalary;
		}

		public BigDecimal getNetsalary() {
			return netsalary;
		}

		public void setNetsalary(BigDecimal netsalary) {
			this.netsalary = netsalary;
		}

		public String getDoctoraddress() {
			return doctoraddress;
		}

		public void setDoctoraddress(String doctoraddress) {
			this.doctoraddress = doctoraddress;
		}

		public String getSpeacification() {
			return speacification;
		}

		public void setSpeacification(String speacification) {
			this.speacification = speacification;
		}

		public String getDoj() {
			return doj;
		}

		public void setDoj(String doj) {
			this.doj = doj;
		}

		public doctorDetails(Long doctorid, String doctorname, String doctordept, String doctorloc, String doctoremail,
				String password, Long doctorphone, BigDecimal salary, BigDecimal basicsalary, BigDecimal hra,
				BigDecimal allowance, BigDecimal deductions, BigDecimal grosssalary, BigDecimal netsalary,
				String doctoraddress, String speacification, String doj) {
			super();
			this.doctorid = doctorid;
			this.doctorname = doctorname;
			this.doctordept = doctordept;
			this.doctorloc = doctorloc;
			this.doctoremail = doctoremail;
			this.password = password;
			this.doctorphone = doctorphone;
			this.salary = salary;
			this.basicsalary = basicsalary;
			this.hra = hra;
			this.allowance = allowance;
			this.deductions = deductions;
			this.grosssalary = grosssalary;
			this.netsalary = netsalary;
			this.doctoraddress = doctoraddress;
			this.speacification = speacification;
			this.doj = doj;
		}

		public doctorDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
	

}
