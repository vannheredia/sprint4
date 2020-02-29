package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.BaproClubEntregable.model.Cuenta;
import com.dh.BaproClubEntregable.model.Usuario;
import com.sun.xml.bind.v2.model.core.ID;

public interface CuentaJpaRepository extends JpaRepository<Cuenta, Integer>{

	Cuenta findByUsuario (Usuario usuario);

}
