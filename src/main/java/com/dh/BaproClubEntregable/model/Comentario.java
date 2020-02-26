package com.dh.BaproClubEntregable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	@Column
	private String comentario;
	private Integer idPublicacion;
	

	public Comentario() {
		super();
	}
	public Comentario(String comentario, Integer idPublicacion) {
		super();
		this.idPublicacion = idPublicacion;
		this.comentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
