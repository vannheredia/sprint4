

//ipackage com.dh.BaproClubEntregable.controller;

package com.dh.BaproClubEntregable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.ComentarioJpaRepository;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioJpaRepository comentarioJpaRepository;
	@Autowired 
	private PublicacionJpaRepository publicacionJpaRepository;
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;


	@GetMapping("subirComentario/{publicaciones.id}")
	public String getMiComentario(Model model) {
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);

		return "redirect:/MiMuro";
	}
	
	@PostMapping("subirComentario/{pub.id}")
	public String generarComentario(Comentario MiComentario, Model model, HttpServletRequest request) {
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);
		MiComentario.setUnaCuenta(cuentaJpaRepository.findByUsuario(usrLogueado) );
		
		comentarioJpaRepository.save(MiComentario);		
		System.out.println(MiComentario.toString());
		List<Comentario>  unaListaDeComentarios = comentarioJpaRepository.findAll();
		model.addAttribute("comentarios", unaListaDeComentarios);
		
		List<Publicacion>  publicacionesDelUsuario = publicacionJpaRepository.findAll();  //se tiene que volver a llamar a las publicaciones 
		model.addAttribute("publicaciones", publicacionesDelUsuario);
		
		return "redirect:/MiMuro";
	}
	@PostMapping("eliminarComentario")
	public String eliminarComentario(Comentario uncomentario, Model model) {
	comentarioJpaRepository.delete(uncomentario);
	return "redirect:/MiMuro";
		
		
	}
}
