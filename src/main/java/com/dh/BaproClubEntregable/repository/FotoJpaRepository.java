package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.BaproClubEntregable.model.Foto;
import com.sun.xml.bind.v2.model.core.ID;

public interface FotoJpaRepository extends JpaRepository<Foto, ID> {

}
