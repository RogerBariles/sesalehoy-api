package com.example.seSaleHoy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seSaleHoy.entity.Roles;
import com.example.seSaleHoy.enums.RolesName;

public interface RoleDao extends JpaRepository<Roles, Long>{
	
	Optional<Roles> findByRolName(RolesName rolName);

}
