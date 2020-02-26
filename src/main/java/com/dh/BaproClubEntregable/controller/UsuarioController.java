package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	
	//Crear Usuario
	@PostMapping("nuevoUsuario")
	public Usuario insertarUsuario(@RequestBody Usuario unUsuario) {
		Usuario nuevoUsuario = usuarioJpaRepository.save(unUsuario);
		return nuevoUsuario;
	}

	//Obtener Todos los usuarios
	@GetMapping("todosLosUsuarios")
	public List <Usuario> getUsuario(){
		List <Usuario> usuarios = usuarioJpaRepository.findAll();
		return usuarios;
	}
	
	//Obtener Usuario por ID
	@GetMapping("{id}")
	public Usuario getUsuario(@PathVariable("id")int id) {
		Usuario unUsuario = usuarioJpaRepository.getOne(id);
		return unUsuario;
	}
	
	//Eliminar Usuarios
	@DeleteMapping("{id}")
	public void deleteUsuario(@PathVariable("id")int id) {
		usuarioJpaRepository.deleteById(id);;
	}
	
	
	//Editar Usuario
	
	@GetMapping("/registro")
	public String getFormularioRegistro() {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String guardarUsuario(Usuario unUsuario) {
		this.usuarioJpaRepository.save(unUsuario);
		return "registro-exitoso";
	}

}
