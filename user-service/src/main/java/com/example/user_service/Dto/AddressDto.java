package com.example.user_service.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder

public class AddressDto {

	private Integer addressId;
	private String fullAddress;
	private String postalCode;
	private String City;
	private String Country;
	@JsonProperty("user")
	private UserDto userdto;

	public AddressDto(Integer addressId, String fullAddress, String postalCode, String city, String country,
			UserDto userdto) {
		super();
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		City = city;
		Country = country;
		this.userdto = userdto;
	}


	public UserDto getUserdto() {
		return userdto;
	}


	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}


	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getFullAddress() {
		return fullAddress;
	}


	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String City) {
		this.City = City;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String Country) {
		this.Country = Country;
	}


	public AddressDto(Integer addressId, String fullAddress, String postalCode, String city, String country) {
		super();
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		City = city;
		Country = country;
	}




}
