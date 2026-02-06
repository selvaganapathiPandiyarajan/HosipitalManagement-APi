package com.example.user_service.Dto;

import com.example.user_service.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
public class CredentialDto {

	private Integer credentialId;
	private String username;
	private String password;
	private Role role;
	private Boolean isEnabled;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentailsNonExpired;

	@JsonProperty("user")
	private UserDto userdto;

	public CredentialDto(Integer credentialId, String username, String password, Role role, Boolean isEnabled,
			Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentailsNonExpired,
			@NotNull UserDto userdto) {
		super();
		this.credentialId = credentialId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isEnabled = isEnabled;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentailsNonExpired = isCredentailsNonExpired;
		this.userdto = userdto;
	}

	public CredentialDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public UserDto getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
}
