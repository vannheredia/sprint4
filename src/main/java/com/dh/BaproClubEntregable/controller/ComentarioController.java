

//ipackage com.dh.BaproClubEntregable.controller;

package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.repository.ComentarioJpaRepository;

@RestController
public class ComentarioController {
	
	@Autowired
	private ComentarioJpaRepository comentarioJpaRepository;
	

	@GetMapping("subirComentario")
	public String getMiComentario(Model model) {
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);

		return "MiMuro";
	}
	
	@PostMapping("subirComentario")
	public String generarComentario(Comentario unComentario, Model model) {
		comentarioJpaRepository.save(unComentario); 
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);
		return "MiMuro";
	}

}
