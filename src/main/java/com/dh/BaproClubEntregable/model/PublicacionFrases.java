package com.dh.BaproClubEntregable.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "publicacion_frases")
public class PublicacionFrases extends Publicacion {
	



	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	
	@Column(unique=true, nullable=false)
	private String id_frase;
	
	public PublicacionFrases(Integer id_perfil, Date fecha, String id_frase) {
		super(id_perfil, fecha);
		this.id_frase = id_frase;
	}

	public String getId_frase() {
		return id_frase;
	}

	public void setId_frase(String id_frase) {
		this.id_frase = id_frase;
	}
	
	
	
}
