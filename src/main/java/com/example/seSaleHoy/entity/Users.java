package com.example.seSaleHoy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Table
@Entity
public class Users {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameUser;
	private String email;
	private String numero;
	private String password;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_rol",
			joinColumns = @JoinColumn(name ="user_rol"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Roles> roles = new HashSet<>();
	
	public Users(String nameUser, String email, String numero, String password) {
		super();
		this.nameUser = nameUser;
		this.email = email;
		this.numero = numero;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}	
}
