package com.example.seSaleHoy.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.seSaleHoy.enums.RolesName;
import com.sun.istack.NotNull;

@Table
@Entity
public class Roles {

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolesName rolName;
	
	public Roles() {
		super();
	}
	
	public Roles(RolesName rolName) {
		super();
		this.rolName = rolName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolesName getRol() {
		return rolName;
	}

	public void setRol(RolesName rol) {
		rolName = rol;
	}
	
	
	
}
