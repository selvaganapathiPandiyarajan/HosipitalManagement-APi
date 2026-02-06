package com.example.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
public class BookAppointment {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer AppointmentId;
	public BookAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookAppointment(Integer appointmentId, String name, String email, String phone, String doctorDest,
			String doctorName, String dOP) {
		super();
		AppointmentId = appointmentId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doctorDest = doctorDest;
		this.doctorName = doctorName;
		DOP = dOP;
	}

	public Integer getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		AppointmentId = appointmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDoctorDest() {
		return doctorDest;
	}

	public void setDoctorDest(String doctorDest) {
		this.doctorDest = doctorDest;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDOP() {
		return DOP;
	}

	public void setDOP(String dOP) {
		DOP = dOP;
	}



	private String name;
	private String email;
	private String phone;
    private String doctorDest;
    private String doctorName;
    private String DOP;
	
  
}
