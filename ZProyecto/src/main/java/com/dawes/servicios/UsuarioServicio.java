package com.dawes.servicios;

import javax.validation.Valid;

import com.dawes.entidades.Usuario;

public interface UsuarioServicio {

	public Iterable<Usuario> getAllUsruaios();

	public Usuario crearUsuario(Usuario usuario) throws Exception;
}
