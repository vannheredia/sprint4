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
//import com.patugarte.logindemo.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;


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
	public String getMiMuro(Model model) {
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);
    	 return "MiMuro";
	}

	@PostMapping("/login")
	public String login(Usuario usr , Model model, HttpServletRequest request) {	
		//metodo de validacion de usurio y contrasenia subido al Slack por Pat		
		String mailIngresado = usr.getEmail();		
		String contraseniaIngresada = usr.getContrasenia();				
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(usr.getEmail());	
		if(usrLogueado == null) {			
			return "index";
		}		
		if(usrLogueado.getContrasenia().equals(contraseniaIngresada)) {
			model.addAttribute("userName", usrLogueado.getEmail());			
			List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());	
			model.addAttribute("publicaciones", publicaciones);
			model.addAttribute("usuario", usrLogueado);		
			HttpSession misession= request.getSession(true);
			misession.setAttribute("emaillogueado", usr.getEmail());	
			return "nuevoPerfil";						
			} else {
			return "index";
			}
		}
		
		
		
	/*  CODIGO PARA MOSTRAR EL NUEVOPERFIL CUANDO USR SE LOGUEA		
	Usuario usrLogueado = usuarioJpaRepository. findByEmail(usr.getEmail());	
	List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());	
	model.addAttribute("publicaciones", publicaciones);
	model.addAttribute("usuario", usrLogueado);		
	HttpSession misession= request.getSession(true);
	misession.setAttribute("emaillogueado", usr.getEmail());	
	return "nuevoPerfil";
	}
	*/

	@PostMapping("/buscamiamigo")
	public String buscamiamigo(Usuario usr , Model model) {		
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(usr.getEmail());
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
	public String getPerfil(Model model ,HttpServletRequest request) {		
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(mailLogueado);
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


