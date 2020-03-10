package com.dh.BaproClubEntregable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.BaproClubEntregable.model.Comentario;
import com.dh.BaproClubEntregable.model.Cuenta;
import com.sun.xml.bind.v2.model.core.ID;


public interface ComentarioJpaRepository extends JpaRepository<Comentario, Integer> {

	List<Comentario> findAllById (Cuenta id); 

}
