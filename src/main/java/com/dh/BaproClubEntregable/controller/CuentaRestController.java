package com.dh.BaproClubEntregable.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;

@RestController
public class CuentaRestController {
	
	@Autowired
	private CuentaJpaRepository cuentaJpaRepository;

	public void publicacionNueva (Integer idUsuario) {
		Publicacion unaPublicacion = new Publicacion(idUsuario);
		
	}	
	
	
	
	
	

}
