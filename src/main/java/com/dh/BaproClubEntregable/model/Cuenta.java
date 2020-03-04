package com.dh.BaproClubEntregable.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cuentas")
public class Cuenta {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@OneToOne
	@JoinColumn(nullable = false, name = "id_usuario")
	private Usuario usuario;

	@Cascade(CascadeType.REFRESH)
	@OneToMany(mappedBy = "unaCuenta")
	private List<Publicacion> publicacionesDelUsuario;

	@ManyToMany
	@JoinTable(
			  name = "seguimientos", 
			  joinColumns = @JoinColumn(name = "seguido_id"), 
			  inverseJoinColumns = @JoinColumn(name = "seguidor_id")
			  )
	private List<Cuenta> listaDeSeguidos;

	@ManyToMany(mappedBy = "listaDeSeguidos")
	private List<Cuenta> listaDeSeguidores;

	public Cuenta(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {

		this.usuario = usuario;
		// this.publicacionesDelUsuario = publicacionesDelUsuario;
	}

	public Cuenta() {
		listaDeSeguidos = new ArrayList<Cuenta>();
		listaDeSeguidores = new ArrayList<Cuenta>();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario unUsuario) {
		this.usuario = unUsuario;
	}

	// public List<Publicacion> getPublicacionesDelUsuario() {
	// return publicacionesDelUsuario;
	// }
	// public void setPublicacionesDelUsuario(List<Publicacion>
	// publicacionesDelUsuario) {
	// this.publicacionesDelUsuario = publicacionesDelUsuario;
	// }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void manejarSeguimiento(Cuenta solicitante) {
		this.agregarSeguidor(solicitante);
		solicitante.agregarSeguido(this);
	}
	
	private void agregarSeguidor(Cuenta seguidor) {
		listaDeSeguidores.add(seguidor);
	}
	
	private void agregarSeguido(Cuenta seguido) {
		listaDeSeguidos.add(seguido);
	}

}
