package com.dawes.servicios;

import java.util.Optional;

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
	
	private boolean checkUsernameAvailable(Usuario usuario) throws Exception {
		Optional<Usuario> usuarioFound = ur.findByUsername(usuario.getNombre());
		if (usuarioFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}
	
	private boolean checkPasswordValid(Usuario usuario) throws Exception{
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			throw new Exception("Las constrasenas no son iguales");
		}
		return true;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		if(checkUsernameAvailable(usuario) && checkPasswordValid(usuario)) {
			usuario = ur.save(usuario);
		}
		return usuario;
	}

	
}
