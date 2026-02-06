package com.example.Hospitialdetails.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctorlist")
public class Doctorlist {
	
	@Id
	private Integer id;
	private Long doctorid;
    private String doctorname;
    private String doctordept;
    private String doctorloc;
    private String doctoremail;
    private String password;
    private String doctorphone;
    private Double basicsalary;
    private Double hra;
    private Double allowance;
    private Double deductions;
    private Double grosssalary;
    private Double netsalary;
    private Integer month;
    private String doctoraddress;
    private String speacification;

    private String doj; // 👈 keep String for now (important!)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getDoctorphone() {
		return doctorphone;
	}

	public void setDoctorphone(String doctorphone) {
		this.doctorphone = doctorphone;
	}

	public double getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(double basicsalary) {
		this.basicsalary = basicsalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getGrosssalary() {
		return grosssalary;
	}

	public void setGrosssalary(double grosssalary) {
		this.grosssalary = grosssalary;
	}

	public double getNetsalary() {
		return netsalary;
	}

	public void setNetsalary(double netsalary) {
		this.netsalary = netsalary;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
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

	public Doctorlist(Integer id, Long doctorid, String doctorname, String doctordept, String doctorloc,
			String doctoremail, String password, String doctorphone, double basicsalary, double hra, double allowance,
			double deductions, double grosssalary, double netsalary, Integer month, String doctoraddress,
			String speacification, String doj) {
		super();
		this.id = id;
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.doctordept = doctordept;
		this.doctorloc = doctorloc;
		this.doctoremail = doctoremail;
		this.password = password;
		this.doctorphone = doctorphone;
		this.basicsalary = basicsalary;
		this.hra = hra;
		this.allowance = allowance;
		this.deductions = deductions;
		this.grosssalary = grosssalary;
		this.netsalary = netsalary;
		this.month = month;
		this.doctoraddress = doctoraddress;
		this.speacification = speacification;
		this.doj = doj;
	}

	public Doctorlist() {
		super();
		// TODO Auto-generated constructor stub
	}

}
