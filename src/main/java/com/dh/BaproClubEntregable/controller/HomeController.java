package com.dh.BaproClubEntregable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("index") //index es igual a comillas vacias
	public String getIndex() {
	return "index";
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
	
	@GetMapping("/faq")
	public String getFaq() {
	return "faq";
	}

	}


