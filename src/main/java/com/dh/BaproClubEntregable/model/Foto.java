package com.dh.BaproClubEntregable.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Fotos")

public class Foto {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer ID;
	
	@Column( nullable=false)
	private String src;
	private String descripcion;
	private Integer id_usuario;
	private Date fecha;
	
	public Foto(String src, String descripcion, Integer id_usuario, Date fecha) {
		super();
		this.src = src;
		this.descripcion = descripcion;
		this.id_usuario = id_usuario;
		this.fecha = fecha;
	}
	
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
