package com.dh.BaproClubEntregable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dh.BaproClubEntregable.model.Publicacion;
import com.sun.xml.bind.v2.model.core.ID;

public interface PublicacionJpaRepository extends JpaRepository<Publicacion, ID> {
	
	@Query ("SELECT p from Publicacion p inner join Cuenta c on p.idCuenta = c.id where c.Usuario.id = ?1")
	List<Publicacion> findByUserId(Integer Id); 
}
