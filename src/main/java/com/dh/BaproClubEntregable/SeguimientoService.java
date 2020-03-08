package com.dh.BaproClubEntregable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.repository.CuentaJpaRepository;

@Service
public class SeguimientoService {
	
	@Autowired
	CuentaJpaRepository cuentaJpaRepository;
	
	public void agregarSeguidor(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguida.agregarSeguidor(cuentaSeguidora);
		cuentaJpaRepository.save(cuentaSeguida);
	}


	public void agregarSeguido(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguidora.agregarSeguido(cuentaSeguida);
		cuentaJpaRepository.save(cuentaSeguidora);
	}
	
	public void eliminarSeguidor(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguida.eliminarSeguidor(cuentaSeguidora);
		cuentaJpaRepository.delete(cuentaSeguida);
	}


	public void eliminarSeguido(Cuenta cuentaSeguida,Cuenta cuentaSeguidora){
		cuentaSeguidora.eliminarSeguido(cuentaSeguida);
		cuentaJpaRepository.delete(cuentaSeguidora);
	}

	
	
}
