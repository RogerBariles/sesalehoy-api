package com.example.seSaleHoy.services;

import java.util.List;
import java.util.Optional;

import com.example.seSaleHoy.dao.UsersDao;
import com.example.seSaleHoy.entity.Users;


import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional
public class UserService {

	@Autowired
	UsersDao userDao;
	
	public Users getByNameUser(String nameUser) {
		Users use = userDao.findByNameUser(nameUser);
		return use;
	}
	
	public boolean existsByNameUser(String nameUser) {
		return userDao.existsByNameUser(nameUser);
	}
	
	public boolean existByEmail(String email) {
		return this.userDao.existsByEmail(email);
	}
	
	public void save(Users user) {
		userDao.save(user);
	}
	
	public List<Users> findAll() {
		return userDao.findAll();
	}
	
	public Users findById(Long id) {
		try {
			return userDao.findByid(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean delete(Users user) {
		try {
			userDao.delete(user);
			return true;
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error id no debe ser null. Error: " + e);
		} catch (PersistenceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor. Error: " + e);
		}
	}
	
}
