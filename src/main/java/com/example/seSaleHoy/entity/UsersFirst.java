package com.example.seSaleHoy.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersFirst implements UserDetails{
	//	class encargada de crear la seguridad
	//	determinar los privilegios de cada rol (autoridades)
		
	private String nameUser;	
	private String password;

	private Collection<? extends GrantedAuthority> authorities; //cambiamos de tipo Role a autoridades

	
	public UsersFirst(String nameUser, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nameUser = nameUser;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UsersFirst build(Users user) {
		//obtenemos una lista GrantedAuthority apartir de los roles
		//convertimos la clase rol en grantedAut.
		List<GrantedAuthority> authorities = user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(
				rol.getRol().name())).collect(Collectors.toList());
		
		return new UsersFirst(user.getNameUser(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
