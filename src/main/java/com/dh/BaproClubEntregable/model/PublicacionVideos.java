package com.dh.BaproClubEntregable.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "publicaciones_videos")
public class PublicacionVideos extends Publicacion{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private Integer ID;
	@Column(unique=true, nullable=false)
	private Integer Id_video;
	
	
	public PublicacionVideos(Integer id_perfil, Date fecha, Integer id_video) {
		super(id_perfil, fecha);
		Id_video = id_video;
	}


	public Integer getId_video() {
		return Id_video;
	}


	public void setId_video(Integer id_video) {
		Id_video = id_video;
	}
	
	

}
