package com.example.user_service.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder

public class BookAppointmentDto {
	private Integer AppointmentId;
	private String name;
	private String email;
	private String phone;
    private String doctorDest;
    public BookAppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookAppointmentDto(Integer appointmentId, String name, String email, String phone, String doctorDest,
			String doctorName, String dOP, @NotNull UserDto userdto) {
		super();
		AppointmentId = appointmentId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doctorDest = doctorDest;
		this.doctorName = doctorName;
		DOP = dOP;
		this.userdto = userdto;
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

	public UserDto getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}

	private String doctorName;
    private String DOP;
    
    @JsonProperty("user")
	@NotNull
	private UserDto userdto;

}
