package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.config.MyUserDetails;
import com.app.domain.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private com.app.repositories.UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usu = repo.findByEmail(email);
		if (usu == null) {
			throw new UsernameNotFoundException(email);
		}
		return new MyUserDetails(usu.getId(), usu.getEmail(), usu.getSenha(), usu.getPerfis());
	}
}
