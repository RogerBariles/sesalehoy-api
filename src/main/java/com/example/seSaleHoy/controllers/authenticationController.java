package com.example.seSaleHoy.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seSaleHoy.dto.JwtDTO;
import com.example.seSaleHoy.dto.UserLoginDTO;
import com.example.seSaleHoy.entity.Roles;
import com.example.seSaleHoy.entity.Users;
import com.example.seSaleHoy.enums.RolesName;
import com.example.seSaleHoy.security.jwt.JwtProvider;
import com.example.seSaleHoy.services.RoleService;
import com.example.seSaleHoy.services.UserService;

@RestController
@RequestMapping("/authentication")
@CrossOrigin
public class authenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping( name="newUser", path="user")
	public ResponseEntity<?> newUser(@RequestBody UserLoginDTO userNew, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario Incompleto");
		}
		
		
		if(this.userService.existsByNameUser(userNew.getUserName())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ya existente");
		}
		
		if(this.userService.existByEmail(userNew.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ya existente con el mismo email");
		}
		
		Users user = new Users(
				userNew.getUserName(),
				userNew.getEmail(),
				userNew.getNumero(),
				passwordEncoder.encode(userNew.getPassword()));
		
		Set<Roles> roles = new HashSet<>();
		roles.add(roleService.getByRolName(RolesName.ROLE_EMPLEADO).get());
		
		if(userNew.getRoles().contains("admin"))
			roles.add(roleService.getByRolName(RolesName.ROLE_ADMIN).get());
		if(userNew.getRoles().contains("super")) {
			roles.add(roleService.getByRolName(RolesName.ROLE_ADMIN).get());
			roles.add(roleService.getByRolName(RolesName.ROLE_SUPER_ADMIN).get());			
		}
			
		user.setRoles(roles);
		userService.save(user);
		
		
		return ResponseEntity.ok().body("usuario creado");
	};
	
	@PostMapping(name="login", path = "login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO loginUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credenciales incorrectas");
		}
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication,loginUser);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return ResponseEntity.ok().body(jwtDto);
	}
	
}
