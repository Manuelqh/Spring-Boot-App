package com.dawes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dawes.entidades.Usuario;
import com.dawes.repositorios.RolRepositorio;
import com.dawes.servicios.UsuarioServicio;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioServicio us;
	
	//Solo repositorio porque solo vamos a consultar
	@Autowired
	RolRepositorio rr;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("formularioUsuario")
	public String getUsuarioFormulario(Model model) {
		model.addAttribute("formularioUsuario", new Usuario());
		model.addAttribute("listaUsuarios", us.getAllUsruaios());
		model.addAttribute("roles", rr.findAll());
		// Para que se muestre primero la lista
		model.addAttribute("tablaLista","active");
		return "formulario-usuario/vista-usuario";
	}
}
