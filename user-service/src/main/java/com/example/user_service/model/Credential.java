package com.example.user_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Builder

public class Credential {
	public Credential() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Credential(Integer credentialId, String username, String password, Role role, Boolean isEnabled,
			Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentailsNonExpired,
			UserProfile user) {
		super();
		this.credentialId = credentialId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isEnabled = isEnabled;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentailsNonExpired = isCredentailsNonExpired;
		this.user = user;
	}
	public Integer getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Boolean getIsAccountNonExpired() {
		return isAccountNonExpired;
	}
	public void setIsAccountNonExpired(Boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}
	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public Boolean getIsCredentailsNonExpired() {
		return isCredentailsNonExpired;
	}
	public void setIsCredentailsNonExpired(Boolean isCredentailsNonExpired) {
		this.isCredentailsNonExpired = isCredentailsNonExpired;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer credentialId;
	@Column(unique =true)
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	private Boolean isEnabled;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentailsNonExpired;
	@OneToOne
	@JoinColumn(name="user_id",nullable=false)
    @JsonBackReference("credential")
	private UserProfile user;

}
