package com.dh.BaproClubEntregable;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Publicacion;
import com.dh.BaproClubEntregable.model.Usuario;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;
import com.dh.BaproClubEntregable.repository.UsuarioJpaRepository;

@Service
public class SeguimientoService {
	
	@Autowired
	CuentaJpaRepository cuentaJpaRepository;
	@Autowired 
	private UsuarioJpaRepository usuarioJpaRepository;
	
//	List<Publicacion> findByUserId(Integer Id); 
	
	
		
	public void agregarSeguidor(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguida.agregarSeguidor(cuentaSeguidora);
		cuentaJpaRepository.save(cuentaSeguida);
	}


	public void agregarSeguido(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguidora.agregarSeguido(cuentaSeguida);
		cuentaJpaRepository.save(cuentaSeguidora);
	}
	
	public void eliminarSeguidor(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		usuarioJpaRepository.eliminarSeguidor(cuentaSeguida.getId(), cuentaSeguidora.getId());
//		cuentaSeguida.eliminarSeguidor(cuentaSeguidora);
//		cuentaJpaRepository.delete(cuentaSeguida);
	}
	
//	public void eliminarSeguido(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
//		usuarioJpaRepository.eliminarSeguidor(cuentaSeguidora.getId(), cuentaSeguida.getId());
//		cuentaSeguidora.eliminarSeguido(cuentaSeguida);
//		cuentaJpaRepository.delete(cuentaSeguidora);
	}

//
//	public void eliminarTodosLosSeguidos(Cuenta cuentaSeguidora,Set<Cuenta> seguidosEliminar, Cuenta Cuenta){
//		cuentaSeguidora.eliminarTodosLosSeguidos(Set<Cuenta> seguidosEliminar);
//		cuentaJpaRepository.deleteAll(seguidosEliminar);
//	}
//	
	
	
		
	

