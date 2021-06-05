package com.dawes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.entidades.Usuario;
import com.dawes.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicio {

	@Autowired
	UsuarioRepositorio ur;
	
	//Mostrar todos los usuarios
	@Override
	public Iterable<Usuario> getAllUsruaios() {
		return ur.findAll();
	}

	
}
