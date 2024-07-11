package com.wipro.healthcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wipro.healthcare.util.JwtAuthFilterUtil;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthFilterUtil authFilter;

	@Bean
	UserDetailsService userDetailsService() {
		return new UserInfoDetailsService();
	}

	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests.requestMatchers("/swagger-ui/**", "/swagger-resources/**",
						"/admin/authenticate", "/admin/save", "/admin/update/*", "/admin/saveDoctor",
						"/admin/updateDoctor/*", "/admin/getAllDoctor", "/admin/deleteDoctor/*", "/admin/getDoctor/*",
						"/admin/getPatient/*", "/admin/getAllPatient", "/admin/updatePatient/*",
						"/admin/deletePatient/*", "/admin/getRecord/*", "/appointment/bookAppointment",
						"/appointment/update/*", "/appointment/getAppointmentById/*", "/appointment/delete/*",
						"/doctor/authenticate", "/doctor/viewDoctor/*", "/doctor/getAllConsultations",
						"/doctor/viewAppointments/*", "/doctor/upcomingAppointments/*", "/doctor/conductConsultation/*",
						"/doctor/medicalRecord/*", "/doctor/getConsultation/*", "/doctor/consultations","/doctor/deleteConsultation/*",
						"/medicalRecord/save", "/medicalRecord/patientRecord/*", "/medicalRecord/doctorRecord/*",
						"/medicalRecord/getAllMedicalRecords", "/medicalRecord/update/*", "/medicalRecord/delete/*",
						"/patient/authenticate", "/patient/save", "/patient/updatePatient/*", "/patient/viewPatient/*",
						"/patient/fetchDoctor/*", "/patient/appointmentStatus/*").permitAll().anyRequest()
						.authenticated())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
