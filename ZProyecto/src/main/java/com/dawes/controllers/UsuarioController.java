package com.dawes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/formularioUsuario")
	//@valid valida los campos de las entidades
	//BindingResult: Contendra la informacion del resultado entre el mapeo del formulario html y el objeto Java User.
	public String crearUsuario(@Valid @ModelAttribute("formularioUsuario")Usuario usuario,BindingResult result, ModelMap model) {
		//Si el resultado tiene errores
		if(result.hasErrors()) {
			model.addAttribute("formularioUsuario", usuario);
			model.addAttribute("tablaFormulario","active");
		}else {
			try {
				us.crearUsuario(usuario);
				model.addAttribute("formularioUsuario", new Usuario());
				model.addAttribute("tablaLista","active");
			}catch(Exception e) {
				model.addAttribute("formularioErrorMessage", e.getMessage());
				model.addAttribute("formularioUsuario", usuario);
				model.addAttribute("tablaFormulario","active");
				model.addAttribute("listaUsuarios", us.getAllUsruaios());
				model.addAttribute("roles", rr.findAll());
				}
			}
		
		model.addAttribute("listaUsuarios", us.getAllUsruaios());
		model.addAttribute("roles", rr.findAll());
		return "formulario-usuario/vista-usuario";
	}
}
