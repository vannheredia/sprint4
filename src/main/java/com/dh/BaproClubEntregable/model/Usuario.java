package com.dh.BaproClubEntregable.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "usuarios")
public class Usuario {
	


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	
	@Column(nullable=false)
	private String nombre;
	private String apellido;
	@Column(nullable=false)
	private Date fechaDeNacimiento;
	@Column(nullable=false)
	private String lugarDeNacimiento;
	@NotNull(message = "El mail es nulo o invalido")
	@Column(unique=true, nullable=false)
	private String email;
	@Column( nullable=false)
	private String contrasenia;
	@Column( nullable=false)
	private String resenia;
	private String urlFotoPerfil;
	private String urlFotoPortada; 
	private Cuenta cuentaDeUsuario;
	
	
	public Usuario(String nombre, String apellido, Date fechaDeNacimiento, String lugarDeNacimiento, String email,
			String contrasenia, String resenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.lugarDeNacimiento = lugarDeNacimiento;
		this.email = email;
		this.contrasenia = contrasenia;
		this.resenia = resenia;
	}

	
	public Usuario() {
		super();
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


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getDescripcion() {
		return resenia;
	}


	public void setDescripcion(String descripcion) {
		this.resenia = descripcion;
	}


	public String getLugarDeNacimiento() {
		return lugarDeNacimiento;
	}


	public void setLugarDeNacimiento(String lugarDeNacimiento) {
		this.lugarDeNacimiento = lugarDeNacimiento;
	}


	public String getResenia() {
		return resenia;
	}


	public void setResenia(String resenia) {
		this.resenia = resenia;
	}


	public Integer getId() {
		return id;
	}


	public String getUrlFotoPerfil() {
		return urlFotoPerfil;
	}


	public void setUrlFotoPerfil(String urlFotoPerfil) {
		this.urlFotoPerfil = urlFotoPerfil;
	}


	public String getUrlFotoPortada() {
		return urlFotoPortada;
	}


	public void setUrlFotoPortada(String urlFotoPortada) {
		this.urlFotoPortada = urlFotoPortada;
	}


	public Cuenta getCuentaDeUsuario() {
		return cuentaDeUsuario;
	}


	public void setCuentaDeUsuario(Cuenta cuentaDeUsuario) {
		this.cuentaDeUsuario = cuentaDeUsuario;
	}
	
	


}
