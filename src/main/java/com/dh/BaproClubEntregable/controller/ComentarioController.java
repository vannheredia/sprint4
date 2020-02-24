package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.repository.ComentarioJpaRepository;

@RestController
public class ComentarioController {
	
	@Autowired
	private ComentarioJpaRepository comentarioJpaRepository;
	
	@PostMapping("/MiMuro")
	public String generarComentario(Comentario unComentario) {
		comentarioJpaRepository.save(unComentario);
		return "MiMuro";
	}
	

}
