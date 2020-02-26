package com.dh.BaproClubEntregable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	
	@Column
	private String unComentario;
	@ManyToOne()
	private Publicacion unaPublicacion;
	

	public Comentario() {
		super();
	}
	public Comentario(String comentario, Publicacion idPublicacion) {
		super();
		this.unaPublicacion = idPublicacion;
		this.unComentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Publicacion getIdPublicacion() {
		return unaPublicacion;
	}
	public void setIdPublicacion(Publicacion idPublicacion) {
		this.unaPublicacion = idPublicacion;
	}
	public String getComentario() {
		return unComentario;
	}
	public void setComentario(String comentario) {
		this.unComentario = comentario;
	}
	
	
	
}
