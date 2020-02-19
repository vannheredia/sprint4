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
	private Integer id;
	@Column(unique=true, nullable=false)
	private Integer idUsuario;
	private Integer idPublicacion;
	
	public Corazones(Integer iD, Integer id_usuario, Integer id_publicacion) {
		id = iD;
		this.idUsuario = id_usuario;
		this.idPublicacion = id_publicacion;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer id_usuario) {
		this.idUsuario = id_usuario;
	}
	public Integer getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(Integer id_publicacion) {
		this.idPublicacion = id_publicacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer iD) {
		id = iD;
	}
	
	
}
