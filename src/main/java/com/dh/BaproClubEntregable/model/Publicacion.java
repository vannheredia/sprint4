package com.dh.BaproClubEntregable.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "publicaciones")
public class Publicacion {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	@ManyToOne()
	private Cuenta unaCuenta;
	private Date fecha;
	//private List<Usuario> corazones;
	private String texto;
	private String imagenDePosteo;
	//private List<Comentario> unaListadeComentarios;
	

	public Publicacion() {
		super();
	}

	public Publicacion(Cuenta unaCuenta, String texto, String imagenDePosteo) {
		super();
		this.unaCuenta = unaCuenta;
		this.fecha = new Date(0);
		this.texto = texto;
		this.imagenDePosteo = imagenDePosteo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cuenta getUnaCuenta() {
		return unaCuenta;
	}
	public void setUnaCuenta(Cuenta unaCuenta) {
		this.unaCuenta = unaCuenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImagenDePosteo() {
		return imagenDePosteo;
	}
	public void setImagenDePosteo(String imagenDePosteo) {
		this.imagenDePosteo = imagenDePosteo;
	}
	
	
	
	
	
	/*public List<Usuario> getCorazones() {
		return corazones;
	}

	public void setCorazones(List<Usuario> corazones) {
		this.corazones = corazones;
	}*/



}
