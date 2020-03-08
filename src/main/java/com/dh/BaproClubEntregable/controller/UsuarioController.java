package com.dh.BaproClubEntregable.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String guardarUsuario(Usuario unUsuario, BindingResult bindingResult, RedirectAttributes redirAttrs, 
			@RequestParam("urlFotoPerfil")MultipartFile file)throws IOException {
//		if(bindingResult.hasErrors()) {
//			return "registro";}
//		
		//ruta en java de la carpeta donde guarda las imagenes 
		String carpeta = ".//src//main//resources//static//subidasUsuarios//";
		//si la imagen la subi, por que puede ser opcional 
		if(!file.isEmpty()) {
			//aqui subo la imagen de la carpeta
			byte[] bytes = file.getBytes();
			Path path =Paths.get(carpeta + file.getOriginalFilename());
			Files.write(path, bytes);
			//luego le guardo la imagen , 
			unUsuario.setUrlFotoPerfil("/subidasUsuarios/" + file.getOriginalFilename());
		}		
		Cuenta cuentaDeUsuario = new Cuenta();		
		Usuario nuevoUsuario = usuarioJpaRepository.save(unUsuario);		
		cuentaDeUsuario.setUsuario(nuevoUsuario);		
		cuentaJpaRepository.save(cuentaDeUsuario);
		
		redirAttrs.addFlashAttribute("mensajeRegistro", "Gracias por registrarte en BaproClub!!");
		
		return "index";
	}

}
