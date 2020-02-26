package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;



@Controller
public class PublicacionController {
	
	@Autowired
	private PublicacionJpaRepository publicacionJpaRepository;
	
	@GetMapping("subirPublicacion")
		public String getMiMuro() {
		return "MiMuro";
		}
	
	@PostMapping("subirPublicacion")
	public String generarPublicacion(Publicacion unaPublicacion, Model model) {
		publicacionJpaRepository.save(unaPublicacion); 
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();
		model.addAttribute("publicaciones", publicacionesDelUsuario);
		return "MiMuro";
	}
	
	

}
