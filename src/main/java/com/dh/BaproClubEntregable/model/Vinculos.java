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
	private Integer ID;
	
	@Column( nullable=false)
	private Integer ID_usuario;
	private Integer ID_usuarioSeguido;

	public Vinculos(Integer iD_usuario, Integer iD_usuarioSeguido) {
		super();
		ID_usuario = iD_usuario;
		ID_usuarioSeguido = iD_usuarioSeguido;
	}

	public Integer getID_usuario() {
		return ID_usuario;
	}

	public void setID_usuario(Integer iD_usuario) {
		ID_usuario = iD_usuario;
	}

	public Integer getID_usuarioSeguido() {
		return ID_usuarioSeguido;
	}

	public void setID_usuarioSeguido(Integer iD_usuarioSeguido) {
		ID_usuarioSeguido = iD_usuarioSeguido;
	}
	
	
	
}
