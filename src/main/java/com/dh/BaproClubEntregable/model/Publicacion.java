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
	private Integer ID;
	@Column( nullable=false)
	private Integer id_perfil;
	private Date Fecha;
	
	public Publicacion(Integer id_perfil, Date fecha) {
		super();
		this.id_perfil = id_perfil;
		Fecha = fecha;
	}

	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	

}
