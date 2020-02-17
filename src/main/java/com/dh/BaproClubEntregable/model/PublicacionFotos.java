package com.dh.BaproClubEntregable.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "publicaciones")
public class PublicacionFotos extends Publicacion{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer ID;
	@Column(unique=true, nullable=false)
	public Integer id_foto;

	public PublicacionFotos(Integer id_perfil, Date fecha,Integer unId_foto) {
		super(id_perfil, fecha);
		id_foto = unId_foto;
		
	}

	public Integer getId_foto() {
		return id_foto;
	}

	public void setId_foto(Integer id_foto) {
		this.id_foto = id_foto;
	}
	
	

}
