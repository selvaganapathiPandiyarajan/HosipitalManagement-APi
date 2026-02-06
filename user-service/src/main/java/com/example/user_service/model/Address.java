package com.example.user_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
public class Address {
	public Address(Integer addressId, String fullAddress, String postalCode, String city, UserProfile userProfile,
			String country) {
		super();
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		City = city;
		this.user = userProfile;
		Country = country;
	}

	public UserProfile getUserProfile() {
		return user;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.user = userProfile;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer addressId;
private String fullAddress;
private String postalCode;
private String City;

public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public Address(Integer addressId, String fullAddress, String postalCode, String City, String Country,
		UserProfile user) {
	super();
	this.addressId = addressId;
	this.fullAddress = fullAddress;
	this.postalCode = postalCode;
	this.City = City;
	this.Country = Country;
	this.user = user;
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

public UserProfile getUser() {
	return user;
}

public void setUser(UserProfile user) {
	this.user = user;
}

private String Country;

@ManyToOne
@JoinColumn(name="user_id",nullable=false)
@JsonBackReference("user")
private UserProfile user;

}
