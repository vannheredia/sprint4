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
	
	private String descripcion;
	
	
	public Usuario() {
		super();
	}

	
	public Usuario(String nick, String nombre, String apellido, Date fechaDeNacimiento, String email,
			Integer sucursal, String contrasenia, String descripcion) {
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.sucursal = sucursal;
		this.contrasenia = contrasenia;
		
		this.descripcion = descripcion;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}


	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getSucursal() {
		return sucursal;
	}


	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	


}
