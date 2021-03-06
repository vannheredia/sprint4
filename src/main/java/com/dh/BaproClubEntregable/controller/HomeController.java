package com.dh.BaproClubEntregable.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dh.BaproClubEntregable.SeguimientoService;
import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
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
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	
	@Autowired
	private SeguimientoService seguimientoService;
	
	
	@GetMapping("index")
	public String getIndex() {
	return "index";
	}
  
    @GetMapping("/MiMuro")
	public String getMiMuro(Model model, HttpServletRequest request) {

    	 List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);		
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);		
		
		Cuenta cuentaActual = cuentaJpaRepository.findByUsuario(usrLogueado);
		Set<Cuenta> listaDeSeguidos = cuentaActual.getListaDeSeguidos();
		model.addAttribute("Seguidos", listaDeSeguidos);
		
		
    
		 return "MiMuro";
	}

    
    @GetMapping("/sucundumsucundum")  //link para ir al perfil de los amigos desde el div listado de amigos. 
	public String getMiMuro(Usuario usr , Model model, HttpServletRequest request) {
//parte que busca la informacion en la DB
    	Usuario usrPerfil = usuarioJpaRepository.findByEmail(usr.getEmail());
		List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrPerfil.getId());	

//Parte que dibuja los modelos con el model and view 			
		model.addAttribute("publicaciones", publicaciones);
		model.addAttribute("usuario", usrPerfil);		
		return "nuevoPerfil";						
	}

    
	@PostMapping("/login")
	public String login(Usuario usr , Model model, HttpServletRequest request) {		
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(usr.getEmail());	
		if(usrLogueado == null) 
		{			
			return "index";
		}		
		
		if(usrLogueado.getContrasenia().equals(usr.getContrasenia())) 
		{
			List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());	
			HttpSession misession= request.getSession(true);
			misession.setAttribute("emaillogueado", usr.getEmail());	

			
			model.addAttribute("publicaciones", publicaciones);
			model.addAttribute("usuario", usrLogueado);		
			return "nuevoPerfil";						
			
		} 
		else 
		{
			return "index";
			
		}
		
	}
		
		
	@PostMapping("/buscamiamigo")
	public String buscamiamigo(Usuario usr , Model model) {		
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(usr.getEmail());
//		List<Publicacion> publicaciones = publicacionJpaRepository.findByUserId(usrLogueado.getId());	
//		model.addAttribute("publicaciones", publicaciones);
		model.addAttribute("usuario", usrLogueado);		
		return "nuevoPerfil";
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

	@GetMapping("/olvidoPassword")
	public String getOlvidoPassword(String email, String contrasenia) {
		return "olvidoPassword";
	}
	
	@PostMapping("olvidoPassword")
	public String olvidoPassword(String email, String contrasenia) {		
		
		Usuario usrBuscado = usuarioJpaRepository.findByEmail(email);	
//			
//		if(usrBuscado == null) 
//		{			
//			return "El email no se encuentra registrado";
//		}		
		
		usrBuscado.setContrasenia(contrasenia);

		usuarioJpaRepository.save(usrBuscado);
		return "index";
	}

	
	
}


