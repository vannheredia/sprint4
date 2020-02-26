package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class HomeController {
	
	@Autowired 
	private UsuarioJpaRepository usuarioJpaRepository;
	@Autowired 
	private PublicacionJpaRepository publicacionJpaRepository;

	@GetMapping("index") //index es igual a comillas vacias
	public String getIndex() {
	return "index";
	}

  /* 
   * ya esta este Get en comentarioController. borramos para que no rompa todo*/
     @GetMapping("/MiMuro")
	public String getMiMur(Model model) {
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);
    	 return "MiMuro";
	}

	@PostMapping("/login")
	public String login(Usuario usr , Model model) {
	
		
	Usuario usrLogueado = usuarioJpaRepository.findUserByMail(usr.getEmail());
	List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());
	
	model.addAttribute("publicaciones", publicaciones);
	model.addAttribute("usuario", usrLogueado);	
	
	return "nuevoPerfil";
	}
	

	@PostMapping("/buscamiamigo")
	public String buscamiamigo(Usuario usr , Model model) {
	
		
	Usuario usrLogueado = usuarioJpaRepository.findUserByMail(usr.getEmail());
	List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());
	
	model.addAttribute("publicaciones", publicaciones);
	model.addAttribute("usuario", usrLogueado);	
	
	return "nuevoPerfil";
	}
	
	
	@GetMapping("/uploadFile")     //prueba de boton para subir imagenes desde pc
		public String renderizarUploadFile() {
		return "uploadFile";
	}
	
	
	@GetMapping("/contacto")
	public String getContacto() {
	return "contacto";
	}
	
	@GetMapping("/perfil")
	public String getPerfil(Model model) {
	
		Usuario usrLogueado = usuarioJpaRepository.findUserByMail("adalovelace@gmail.com");
		List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());
		
		model.addAttribute("publicaciones", publicaciones);
		model.addAttribute("usuario", usrLogueado);	
		return "nuevoPerfil";
	}
	
	@GetMapping("/faq")
	public String getFaq() {
	return "faq";
	}

	}


