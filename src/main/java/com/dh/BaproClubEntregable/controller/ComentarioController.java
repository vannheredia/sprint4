

//ipackage com.dh.BaproClubEntregable.controller;

package com.dh.BaproClubEntregable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.repository.ComentarioJpaRepository;

@RestController
public class ComentarioController {
	
	@Autowired
	private ComentarioJpaRepository comentarioJpaRepository;
	
	@GetMapping("/MiMuro")
	public String getMiMuro() {
	return "MiMuro";
	}
	
	@PostMapping("/MiMuro")
	public String generarComentario(Comentario unComentario) {
		comentarioJpaRepository.save(unComentario);
		return "MiMuro";
	}
	

}
