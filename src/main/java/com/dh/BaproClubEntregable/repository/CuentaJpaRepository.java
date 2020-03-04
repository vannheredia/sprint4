package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Usuario;
import com.sun.xml.bind.v2.model.core.ID;

public interface CuentaJpaRepository extends JpaRepository<Cuenta, Integer>{
	
	Cuenta findByUsuario (Usuario usuario);

//
//	@Query ("UPDATE Cuenta c SET :unaCuenta")
//	void updateCuenta(@Param("unaCuenta") Cuenta unaCuenta);

	@Transactional
	@Modifying
	@Query("UPDATE Cuenta c SET c = :cuenta")
	void actualizarCuenta(@Param("cuenta") Cuenta cuenta);
	
	
}
