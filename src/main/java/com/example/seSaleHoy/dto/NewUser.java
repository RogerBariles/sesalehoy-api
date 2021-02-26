package com.example.seSaleHoy.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NewUser {

	@NotBlank
	private String nameUser;
	
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

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
