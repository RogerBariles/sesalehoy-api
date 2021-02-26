package com.example.seSaleHoy.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class UserLoginDTO {

	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	private String email;
	private String numero;
	private Set<String> roles = new HashSet<>();
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
