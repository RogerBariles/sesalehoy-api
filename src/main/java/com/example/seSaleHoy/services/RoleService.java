package com.example.seSaleHoy.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seSaleHoy.dao.RoleDao;
import com.example.seSaleHoy.entity.Roles;
import com.example.seSaleHoy.enums.RolesName;

@Service
@Transactional
public class RoleService {

	@Autowired
	RoleDao roleDao;
	
	public Optional<Roles> getByRolName(RolesName rolName) {
		return roleDao.findByRolName(rolName);
	}
	
	public void save(Roles rol) {
		roleDao.save(rol);
	}

}
