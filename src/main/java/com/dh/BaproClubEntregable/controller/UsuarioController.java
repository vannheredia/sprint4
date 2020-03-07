package com.dh.BaproClubEntregable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	
	
	@GetMapping("todosLosUsuarios")
	public List <Usuario> getUsuario(){
		List <Usuario> usuarios = usuarioJpaRepository.findAll();
		return usuarios;
	}
	
	
	@GetMapping("{id}")
	public Usuario getUsuario(@PathVariable("id")int id) {
		Usuario unUsuario = usuarioJpaRepository.getOne(id);
		return unUsuario;
	}
	
	
	@DeleteMapping("{id}")
	public void deleteUsuario(@PathVariable("id")int id) {
		usuarioJpaRepository.deleteById(id);;
	}
	
	
	@GetMapping("/registro")
	public String getFormularioRegistro() {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String guardarUsuario(Usuario unUsuario) {
		Cuenta cuentaDeUsuario = new Cuenta();		
		Usuario nuevoUsuario = usuarioJpaRepository.save(unUsuario);		
		cuentaDeUsuario.setUsuario(nuevoUsuario);		
		cuentaJpaRepository.save(cuentaDeUsuario);
		return "index";
	}

}
