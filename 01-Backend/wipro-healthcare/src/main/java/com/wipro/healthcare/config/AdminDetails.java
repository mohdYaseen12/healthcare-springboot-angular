package com.wipro.healthcare.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wipro.healthcare.entities.Admin;

public class AdminDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String adminEmail;
	private String adminPassword;
	private List<GrantedAuthority> authorities;

	public AdminDetails(Admin admin) {
		adminEmail = admin.getEmail();
		adminPassword = admin.getPassword();
		authorities = Arrays.stream(admin.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return adminPassword;
	}

	@Override
	public String getUsername() {
		return adminEmail;
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