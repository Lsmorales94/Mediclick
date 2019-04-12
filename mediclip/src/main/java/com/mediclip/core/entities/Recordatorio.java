package com.mediclip.core.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "recordatorio")
public class Recordatorio implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rec_id")
	long id;
	
	@Column(name = "rec_descripcion")
	String descripcion;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rec_tratamiento")
	Tratamiento tratamiento;

	public Recordatorio() {
		
	}
	
	public Recordatorio(long id, String descripcion, Tratamiento tratamiento) {
		this.id = id;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

}
