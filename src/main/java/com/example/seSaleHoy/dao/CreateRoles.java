package com.example.seSaleHoy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.seSaleHoy.entity.Roles;
import com.example.seSaleHoy.enums.RolesName;
import com.example.seSaleHoy.services.RoleService;

@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
		/*Roles rolAdmin = new Roles(RolesName.ROLE_ADMIN);
		Roles rolSuperAdmin = new Roles(RolesName.ROLE_SUPER_ADMIN);
		Roles rolUser = new Roles(RolesName.ROLE_EMPLEADO);
		
		roleService.save(rolAdmin);
		roleService.save(rolSuperAdmin);
		roleService.save(rolUser);*/
	}

}
