package com.dh.BaproClubEntregable.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class PublicacionController {
	
	@Autowired
	private PublicacionJpaRepository publicacionJpaRepository;
	
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	

	@PostMapping("/subirPublicacion")
	public String generarPublicacion(Publicacion unaPublicacion, @RequestParam("archivosubido")MultipartFile file,Model model, HttpServletRequest request, 
			BindingResult bindingResult, RedirectAttributes redirAttrs
			)throws IOException 
	{		
		if(bindingResult.hasErrors()) {
			return "perfil";}
		
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);	
		unaPublicacion.setUnaCuenta(cuentaJpaRepository.findByUsuario(usrLogueado));	
		
	
	String carpeta = ".//src//main//resources//static//subidasUsuarios//";	
	if(!file.isEmpty()) {		
		byte[] bytes = file.getBytes();
		Path path =Paths.get(carpeta + file.getOriginalFilename());
		Files.write(path, bytes);		
		unaPublicacion.setImagenDePosteo("/subidasUsuarios/" + file.getOriginalFilename());   
	}			

		publicacionJpaRepository.save(unaPublicacion); 
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);
		return "MiMuro";
	}
		

}
