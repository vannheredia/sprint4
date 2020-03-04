package com.dh.BaproClubEntregable.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Controller
public class CuentaController {
	
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository; 

	@PostMapping("cerrarSesion")
	public String cerrarSesion(Usuario usr , Model model, HttpServletRequest request) {	
		HttpSession misession= request.getSession(true);
		misession.invalidate();
		return "index";
	
		}
		
	
	
	
	
	

}
