package com.dawes.repositorios;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	public Set<Usuario> findByUsername(String username);
	
	//public Optional findByIdAndPassword(Long id, String pasword);
}
