package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class HomeController {
	
	@Autowired 
	private UsuarioJpaRepository usuarioJpaRepository;

	@GetMapping("index") //index es igual a comillas vacias
	public String getIndex() {
	return "index";
	}

	@GetMapping("/MiMuro")
	public String getMiMuro() {
	return "MiMuro";
	}

	@PostMapping("/login")
	public String login(Usuario usr , Model model) {
	Usuario usrLogueado = usuarioJpaRepository.findUserByMail(usr.getEmail());
	model.addAttribute("usuario", usrLogueado);	
	return "nuevoPerfil";
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


