package com.example.seSaleHoy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seSaleHoy.entity.Users;

public interface UsersDao extends JpaRepository<Users, Long>{

	Users findByNameUser(String nameUser);
	boolean existsByNameUser(String nameUser);
	boolean existsByEmail(String email);
	List<Users> findAll();
	void deleteById(Long id);
	Users findByid(Long id);
	void delete(Users user);
}
