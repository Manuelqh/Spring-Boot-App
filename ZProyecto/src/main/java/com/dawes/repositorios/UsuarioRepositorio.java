package com.dawes.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	public Optional<Usuario> findByUsername(String username);
	
	//public Optional findByIdAndPassword(Long id, String pasword);
}
