package com.app.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.domain.Usuario;
import com.app.domain.enums.Perfil;
import com.app.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuRepository;
	@Autowired
	private BCryptPasswordEncoder pe;

	public void instantiateDatabase() {

		Usuario usu1 = new Usuario();
		usu1.setNome("Joao");
		usu1.setEmail("jao@gmail.com");
		usu1.setSenha(pe.encode("12345"));
		usu1.addPerfil(Perfil.ADMIN);
		Usuario usu2 = new Usuario();
		usu2.setNome("Maria");
		usu2.setEmail("maria@gmail.com");
		usu2.setSenha(pe.encode("12345"));
		usu2.addPerfil(Perfil.USUARIO);

		usuRepository.saveAll(Arrays.asList(usu1,usu2));
	}

	@Bean
	public boolean Database() throws ParseException {
		instantiateDatabase();
		return true;
	}
}
