package com.dh.BaproClubEntregable.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer id;
	
	@OneToOne
	@JoinColumn(nullable=false, name="id_usuario")
	private Usuario Usuario;
	
	@OneToMany(mappedBy = "unaCuenta")
	private List<Publicacion> publicacionesDelUsuario;
	
	
	public Cuenta(Usuario unUsuario, List<Publicacion> publicacionesDelUsuario) {
		super();
		this.Usuario = unUsuario;
		//this.publicacionesDelUsuario = publicacionesDelUsuario;
	}
	public Cuenta() {
		super();
	}

	public Usuario getUnUsuario() {
		return Usuario;
	}
	public void setUnUsuario(Usuario unUsuario) {
		this.Usuario = unUsuario;
	}
	//public List<Publicacion> getPublicacionesDelUsuario() {
		//return publicacionesDelUsuario;
	//}
	//public void setPublicacionesDelUsuario(List<Publicacion> publicacionesDelUsuario) {
		//this.publicacionesDelUsuario = publicacionesDelUsuario;
	//}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
