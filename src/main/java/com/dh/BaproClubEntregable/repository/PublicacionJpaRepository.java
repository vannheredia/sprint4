package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.BaproClubEntregable.model.Publicacion;
import com.sun.xml.bind.v2.model.core.ID;

public interface PublicacionJpaRepository extends JpaRepository<Publicacion, ID> {

}
