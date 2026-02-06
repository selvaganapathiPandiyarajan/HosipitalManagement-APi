package com.example.AppoitmentDetails.Dto;

public class ApoointmentDto {
	private Integer appointmentId;
	private String username;
	private String phoneno;
	private String city;
	private String doctorname;
	private String dctordept;
	private String status;
	private String appointmentdate;
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDctordept() {
		return dctordept;
	}
	public void setDctordept(String dctordept) {
		this.dctordept = dctordept;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public ApoointmentDto(Integer appointmentId, String username, String phoneno, String city, String doctorname,
			String dctordept, String status, String appointmentdate) {
		super();
		this.appointmentId = appointmentId;
		this.username = username;
		this.phoneno = phoneno;
		this.city = city;
		this.doctorname = doctorname;
		this.dctordept = dctordept;
		this.status = status;
		this.appointmentdate = appointmentdate;
	}
	public ApoointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
