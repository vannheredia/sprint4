package com.dh.BaproClubEntregable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "vinculos")

public class Vinculos {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	
	@Column( nullable=false)
	private Integer idUsuario;
	private Integer idUsuarioSeguido;

	public Vinculos(Integer iD_usuario, Integer iD_usuarioSeguido) {
		idUsuario = iD_usuario;
		idUsuarioSeguido = iD_usuarioSeguido;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer iD_usuario) {
		idUsuario = iD_usuario;
	}

	public Integer getIdUsuarioSeguido() {
		return idUsuarioSeguido;
	}

	public void setIdUsuarioSeguido(Integer iD_usuarioSeguido) {
		idUsuarioSeguido = iD_usuarioSeguido;
	}
	
	
	
}
