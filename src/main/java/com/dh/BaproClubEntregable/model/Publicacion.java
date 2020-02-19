package com.dh.BaproClubEntregable.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "publicaciones")
public class Publicacion {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	@Column(nullable=false)
	private Integer idPerfil;
	private Date fecha;
	
	public Publicacion(Integer id_perfil) {
		this.idPerfil = id_perfil;
		this.fecha = new Date(0);
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer id_perfil) {
		this.idPerfil = id_perfil;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		fecha = fecha;
	}
	
	

}
