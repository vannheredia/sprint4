//package com.dh.BaproClubEntregable.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.dh.BaproClubEntregable.model.Cuenta;
//import com.dh.BaproClubEntregable.model.Usuario;
//import com.dh.BaproClubEntregable.model.Vinculo;
//import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
//import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;
//import com.dh.BaproClubEntregable.repository.VinculosJpaRepository;
//
//public class VinculoController {
//
//	@Autowired
//	CuentaJpaRepository cuentaJpaRepository; 
//	@Autowired
//	VinculosJpaRepository vinculosJpaRepository; 
//	@Autowired
//	UsuarioJpaRepository usuarioJpaRepository;
//	
//	@PostMapping("seguir")
//	public String agregarSeguidor(Cuenta cuentaSeguidora ,Cuenta cuentaASeguir, Model model, HttpServletRequest request){			
//		
//		HttpSession misession= request.getSession(true);
//		String mailLogueado = misession.getAttribute("emaillogueado").toString();
//		Usuario usrLogueado = usuarioJpaRepository.findByEmail(mailLogueado);
//		cuentaSeguidora.setCuentaSeguidora(cuentaJpaRepository.findByUsuario(usrLogueado) );
//			
//		Vinculo vinculoSeguido  = new Vinculo();
//		
//		vinculoSeguido.setCuentaSeguidora(cuentaSeguidora);
//		vinculoSeguido.setIdCuentaASeguir(cuentaASeguir);	
//		
//		vinculosJpaRepository.save(vinculoSeguido);							
//		
//		Cuenta cuentaActual = cuentaJpaRepository.findByUsuario(usrLogueado);
//		Set<Cuenta> listaDeSeguidos = cuentaActual.getListaDeSeguidos();
//		model.addAttribute("Seguidos", listaDeSeguidos);   
//		
//		
//		return "MiMuro";		
//		}
//	
//	
//	
//	
//	
//}
