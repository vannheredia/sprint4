package com.dh.BaproClubEntregable.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@PostMapping("subirPublicacion")	//gestiona las publicaciones del perfil y del muro. 
	public String generarPublicacion(Publicacion unaPublicacion, Model model, HttpServletRequest request) {
		
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);
		unaPublicacion.setUnaCuenta(cuentaJpaRepository.findByUsuario(usrLogueado) );

		
		publicacionJpaRepository.save(unaPublicacion); 
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);
		return "MiMuro";
	}
		


}
