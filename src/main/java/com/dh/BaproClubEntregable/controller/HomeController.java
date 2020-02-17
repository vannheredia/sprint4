package com.dh.BaproClubEntregable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(" ") //index es igual a comillas vacias
	public String getHome() {
	return "index";
	}

	@GetMapping("/registro")
	public String getRegistro() {
	return "registro";
	}

	@GetMapping("/MiMuro")
	public String getMiMuro() {
	return "MiMuro";
	}

	@GetMapping("/contacto")
	public String getContacto() {
	return "contacto";
	}
	
	@GetMapping("/perfil")
	public String getPerfil() {
	return "nuevoPerfil";
	}

	}


