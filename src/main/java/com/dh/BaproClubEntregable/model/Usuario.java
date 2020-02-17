package com.dh.BaproClubEntregable.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class Usuario {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer ID;
	
	@Column(unique=true, nullable=false)
	private String nick;
	private String nombre;
	private String apellido;
	@Column( nullable=false)
	private Date fechaDeNacimiento;
	@Column(unique=true, nullable=false)
	private String email;
	@Column( nullable=false)
	private Integer sucursal;
	@Column( nullable=false)
	private String contrasenia;
	private String fotoDePerfil;
	private String descripcion;
	
	
	public Usuario(String nick, String nombre, String apellido, Date fechaDeNacimiento, String email,
			Integer sucursal, String contrasenia, String fotoDePerfil, String descripcion) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.sucursal = sucursal;
		this.contrasenia = contrasenia;
		this.fotoDePerfil = fotoDePerfil;
		this.descripcion = descripcion;
	}
	
	
	
	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}



	protected String getNick() {
		return nick;
	}



	protected void setNick(String nick) {
		this.nick = nick;
	}



	protected String getNombre() {
		return nombre;
	}



	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected String getApellido() {
		return apellido;
	}



	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}



	protected Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}



	protected void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}



	protected String getEmail() {
		return email;
	}



	protected void setEmail(String email) {
		this.email = email;
	}



	protected Integer getSucursal() {
		return sucursal;
	}



	protected void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}



	protected String getContrasenia() {
		return contrasenia;
	}



	protected void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	protected String getFotoDePerfil() {
		return fotoDePerfil;
	}



	protected void setFotoDePerfil(String fotoDePerfil) {
		this.fotoDePerfil = fotoDePerfil;
	}



	protected String getDescripcion() {
		return descripcion;
	}



	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	



}
