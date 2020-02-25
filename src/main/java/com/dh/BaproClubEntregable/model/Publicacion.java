package com.dh.BaproClubEntregable.model;

import java.sql.Date;
import java.util.List;

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
	private Integer idCuenta;
	private Date fecha;
	//private List<Usuario> corazones;
	private String tipoDePosteo;
	private String imagenDePosteo;
	
	public Publicacion(Integer id_perfil) {
		this.idCuenta = id_perfil;
		this.fecha = new Date(0);
	}
	
	public Publicacion() {
		this.fecha = new Date(0); 
	}

	public Integer getIdPerfil() {
		return idCuenta;
	}

	public void setIdPerfil(Integer id_perfil) {
		this.idCuenta = id_perfil;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		fecha = fecha;
	}

	/*public List<Usuario> getCorazones() {
		return corazones;
	}

	public void setCorazones(List<Usuario> corazones) {
		this.corazones = corazones;
	}*/

	public String getTipoDePosteo() {
		return tipoDePosteo;
	}

	public void setTipoDePosteo(String tipoDePosteo) {
		this.tipoDePosteo = tipoDePosteo;
	}

	public String getImagenDePosteo() {
		return imagenDePosteo;
	}

	public void setImagenDePosteo(String imagenDePosteo) {
		this.imagenDePosteo = imagenDePosteo;
	}
	
	

}
