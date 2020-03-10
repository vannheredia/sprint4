package com.dh.BaproClubEntregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dh.BaproClubEntregable.model.Usuario;

@Repository()
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail (String email);
	
	Usuario findUserById (Usuario usrLogueado);

	@Transactional
	@Modifying
	@Query(value = "delete from seguimientos where seguido_id = :seguidoId and seguidor_id = :seguidorId",nativeQuery =true)
	public void eliminarSeguidor(@Param("seguidoId") Integer seguidoId,@Param("seguidorId") Integer seguidorId);
	
	
	
	
			
}