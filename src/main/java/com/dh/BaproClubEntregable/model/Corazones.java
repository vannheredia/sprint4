package com.dh.BaproClubEntregable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "corazones")
public class Corazones {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer ID;
	@Column(unique=true, nullable=false)
	private Integer id_usuario;
	private Integer id_publicacion;
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_publicacion() {
		return id_publicacion;
	}
	public void setId_publicacion(Integer id_publicacion) {
		this.id_publicacion = id_publicacion;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public Corazones(Integer iD, Integer id_usuario, Integer id_publicacion) {
		super();
		ID = iD;
		this.id_usuario = id_usuario;
		this.id_publicacion = id_publicacion;
	}
	
	

}
