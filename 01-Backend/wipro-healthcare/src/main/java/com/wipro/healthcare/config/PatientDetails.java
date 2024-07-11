package com.wipro.healthcare.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wipro.healthcare.entities.Patient;

public class PatientDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String patientEmail;
	private String patientPassword;
	private List<GrantedAuthority> authorities;

	public PatientDetails(Patient patient) {
		patientEmail = patient.getEmail();
		patientPassword = patient.getPassword();
		authorities = Arrays.stream(patient.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return patientPassword;
	}

	@Override
	public String getUsername() {
		return patientEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}