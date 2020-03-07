package com.dh.BaproClubEntregable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	private Set<Cuenta> listaDeSeguidos;

	@ManyToMany(mappedBy = "listaDeSeguidos")
	private Set<Cuenta> listaDeSeguidores;

	public Cuenta(Usuario usuario, List<Publicacion> publicacionesDelUsuario) {
		this.usuario = usuario;
		listaDeSeguidos = (Set<Cuenta>)new ArrayList<Cuenta>();
		listaDeSeguidores = (Set<Cuenta>)new ArrayList<Cuenta>();
		// this.publicacionesDelUsuario = publicacionesDelUsuario;
	}

	public Cuenta() {
		
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

//	public List<Publicacion> getPublicacionesDelUsuario() {
//		return publicacionesDelUsuario;
//	}
//
//	public void setPublicacionesDelUsuario(List<Publicacion> publicacionesDelUsuario) {
//		this.publicacionesDelUsuario = publicacionesDelUsuario;
//	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
//	public void manejarSeguimiento(Cuenta solicitante) {
//		this.agregarSeguidor(solicitante);
//		solicitante.agregarSeguido(this);
//	}
	
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void agregarSeguidor(Cuenta seguidor) {
		if(!listaDeSeguidores.add(seguidor)) {
			listaDeSeguidores.remove(seguidor);
		}
		
	}

	public void agregarSeguido(Cuenta seguido) {
		if(!listaDeSeguidos.add(seguido)) {
		listaDeSeguidos.add(seguido);
	}
		}
}
