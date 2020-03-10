package com.dh.BaproClubEntregable.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.BaproClubEntregable.SeguimientoService;
import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	@Autowired
	private PublicacionJpaRepository publicacionJpaRepository; 
	@Autowired
	private SeguimientoService seguimientoService;
	
	
//	
//	@GetMapping("todosLosUsuarios")
//	public List <Usuario> getUsuario(){
//		List <Usuario> usuarios = usuarioJpaRepository.findAll();
//		return usuarios;
//	}
//		
//	@GetMapping("{id}")
//	public Usuario getUsuario(@PathVariable("id")int id) {
//		Usuario unUsuario = usuarioJpaRepository.getOne(id);
//		return unUsuario;
//	}	
//	
//	@DeleteMapping("{id}")
//	public void deleteUsuario(@PathVariable("id")int id) {
//		usuarioJpaRepository.deleteById(id);;
//	}
//		
	
	@GetMapping("/registro")
	public String getFormularioRegistro() {
		return "registro";
	}
	//ALTA DE USUARIOS MEDIANTE EL FORM DE REGISTRO
	@PostMapping("/registro")
	public String guardarUsuario(Usuario unUsuario, BindingResult bindingResult, RedirectAttributes redirAttrs, 
			@RequestParam("urlFotoPerfil")MultipartFile file)throws IOException
		{
//		if(bindingResult.hasErrors()) {
//			return "registro";
//		}
		
		String carpeta = ".//src//main//resources//static//subidasUsuarios//";
		
		if(!file.isEmpty()) {
			
			byte[] bytes = file.getBytes();
			Path path =Paths.get(carpeta + file.getOriginalFilename());
			Files.write(path, bytes);
			
			unUsuario.setUrlFotoPerfil("/subidasUsuarios/" + file.getOriginalFilename());
		}	
		
//		intento de subir foto de portada. consultar con profe. 	DOS ARCHIVOS CON DISTINTA FINALIDAD EN EL MISMO FORM PROBLEMA CON ESTO. 	
//		 @RequestParam("urlFotoPortada")MultipartFile filePortada
//		if(!filePortada.isEmpty()) {
//			
//			byte[] bytes = filePortada.getBytes();
//			Path path =Paths.get(carpeta + filePortada.getOriginalFilename());
//			Files.write(path, bytes);
//			
//			unUsuario.setUrlFotoPortada("/subidasUsuarios/" +filePortada.getOriginalFilename());		
		
		Cuenta cuentaDeUsuario = new Cuenta();		
		Usuario nuevoUsuario = usuarioJpaRepository.save(unUsuario);		
		cuentaDeUsuario.setUsuario(nuevoUsuario);		
		cuentaJpaRepository.save(cuentaDeUsuario);
		
//		redirAttrs.addFlashAttribute("mensajeRegistro", "Gracias por registrarte en BaproClub!!");
		
		return "index";		
		}
	
	
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuarios(Usuario user, Model model ,HttpServletRequest request , Integer idCuentaASeguir) {		
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository. findByEmail(mailLogueado);
	//	Integer usId = usrLogueado.getId();
		Cuenta cuentaEliminar= cuentaJpaRepository.findByUsuario(usrLogueado);		
		
		
		List<Publicacion> publicacionEliminar =  publicacionJpaRepository.findByUserId(usrLogueado.getId());
		publicacionJpaRepository.deleteAll(publicacionEliminar);		
		

		cuentaEliminar.borrarListaDeSeguidores();
		cuentaEliminar.borrarListaDeSeguidos();
		
		cuentaJpaRepository.save(cuentaEliminar);
	
		cuentaJpaRepository.delete(cuentaEliminar);	
		
		
		usuarioJpaRepository.delete(usrLogueado);
//		usuarioJpaRepository.eliminarSeguidor(cuentaEliminar.getId(), cuentaSeguida.getId());
		return "index";	
		
	}
	
	
	
}
	

