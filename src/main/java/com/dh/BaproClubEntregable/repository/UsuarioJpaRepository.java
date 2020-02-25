package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dh.BaproClubEntregable.model.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findUserByMail(String Mail);
	
}