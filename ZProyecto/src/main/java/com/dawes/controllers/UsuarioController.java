package com.dawes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("formularioUsuario")
	public String getUsuarioFormulario() {
		return "formulario-usuario/vista-usuario";
	}
}
