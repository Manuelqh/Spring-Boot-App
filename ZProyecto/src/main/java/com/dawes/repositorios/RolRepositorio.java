package com.dawes.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.entidades.Rol;

@Repository
public interface RolRepositorio extends CrudRepository<Rol, Long> {

	
}
