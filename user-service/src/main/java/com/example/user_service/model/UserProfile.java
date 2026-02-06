package com.example.user_service.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
public class UserProfile {
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	public UserProfile(Integer userId, String firstName, String lastName, String email, String phone, String bloodGroup,
			String dOB, List<Address> address, Credential credential) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.bloodGroup = bloodGroup;
		DOB = dOB;
		this.address = address;
				this.credential = credential;
	}
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
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public UserProfile(Integer userId, String firstName, String lastName, String email, String phone, String bloodGroup,
			String dOB, List<Address> address, List<Patienthistory> pateientHistory, Credential credential) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.bloodGroup = bloodGroup;
		this.DOB = dOB;
		this.address = address;
		this.pateientHistory = pateientHistory;
		this.credential = credential;
	}
	public List<Patienthistory> getPateientHistory() {
		return pateientHistory;
	}
	public void setPateientHistory(List<Patienthistory> pateientHistory) {
		this.pateientHistory = pateientHistory;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	private String lastName;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank(message = "Phone number is required")
	@Pattern(
	    regexp = "^[6-9]\\d{9}$",
	    message = "Invalid phone number"
	)
	private String phone;
	private String bloodGroup;
	private String DOB;
	@OneToMany(mappedBy="user", cascade =CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
    @JsonManagedReference()
	private List<Address> address;
	@OneToMany(mappedBy="user", cascade =CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonManagedReference()
	private List<Patienthistory> pateientHistory;
	@OneToOne(mappedBy="user",cascade =CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonManagedReference()
	private Credential credential;
	public static Optional<UserProfile> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	} 
}
