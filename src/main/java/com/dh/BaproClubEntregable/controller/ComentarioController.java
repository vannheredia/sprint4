

//ipackage com.dh.BaproClubEntregable.controller;

package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.repository.ComentarioJpaRepository;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;

@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioJpaRepository comentarioJpaRepository;
	@Autowired 
	private PublicacionJpaRepository publicacionJpaRepository;


	@GetMapping("subirComentario")
	public String getMiComentario(Model model) {
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);

		return "MiMuro";
	}
	
	@PostMapping("subirComentario")
	public String generarComentario(Comentario MiComentario, Model model) {
		comentarioJpaRepository.save(MiComentario);		
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);
		
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();  //se tiene que volver a llamar a las publicaciones 
		model.addAttribute("publicaciones", publicacionesDelUsuario);
		
		return "MiMuro";
	}

}
