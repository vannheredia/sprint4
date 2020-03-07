package com.dh.BaproClubEntregable.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.BaproClubEntregable.SeguimientoService;
import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.model.Vinculos;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.PublicacionJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;
import com.dh.BaproClubEntregable.repository.VinculosJpaRepository;

@Controller
public class SeguimientoController {
	
	@Autowired
	private VinculosJpaRepository vinculosJpaRepository;
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	@Autowired 
	private PublicacionJpaRepository publicacionJpaRepository;
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;
	
	@Autowired
	private SeguimientoService seguimientoService;
	
	@GetMapping("seguir")
	public String getSeguir() {
		return "MiMuro";
	}
	
	@PostMapping("seguir")
	public String seguirUsuario(Integer idCuentaASeguir, Model model, HttpServletRequest request) {
				
		HttpSession misession= request.getSession(true);
		String mailLogueado = misession.getAttribute("emaillogueado").toString();
		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);
		
		Cuenta cuentaActual = cuentaJpaRepository.findByUsuario(usrLogueado);
		Optional<Cuenta> optionalCuentaASeguir = cuentaJpaRepository.findById(idCuentaASeguir);
		
//		if(!optionalCuentaASeguir.isPresent())
//			throw new RuntimeException("Cuenta a Seguir Invalida");
		
		seguimientoService.agregarSeguidor(cuentaActual,optionalCuentaASeguir.get());
		seguimientoService.agregarSeguido(cuentaActual,optionalCuentaASeguir.get());
		return "redirect:/MiMuro";
	}
	

	public void updateCuentas(Cuenta cuenta) {
		cuentaJpaRepository.delete(cuenta);
		cuentaJpaRepository.save(cuenta);
	}
	
}
