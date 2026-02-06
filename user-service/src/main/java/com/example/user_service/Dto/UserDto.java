package com.example.user_service.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
public class UserDto {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String bloodGroup;
	
	
	@JsonProperty("credential")
	@NotNull
	private CredentialDto credentialdto;
	@JsonProperty("address")
	@NotNull
	private List<AddressDto> address;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public CredentialDto getCredentialdto() {
		return credentialdto;
	}
	public void setCredentialdto(CredentialDto credentialdto) {
		this.credentialdto = credentialdto;
	}
	public List<AddressDto> getAddress() {
		return address;
	}
	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}
	
	public UserDto(Integer userId, String firstName, String lastName, String email, String phone, String bloodGroup,
			@NotNull CredentialDto credentialdto, @NotNull List<AddressDto> address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.bloodGroup = bloodGroup;
		this.credentialdto = credentialdto;
		this.address = address;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
