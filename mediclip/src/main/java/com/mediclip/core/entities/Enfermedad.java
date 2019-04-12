package com.mediclip.core.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "enfermedad")
public class Enfermedad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enf_id")
	long id;
	
	@Column(name = "enf_nombre", nullable = false)
	String nombre;
	
	@Column(name = "enf_descripcion")
	String descripcion;

	public Enfermedad() {
		
	}
	
	public Enfermedad(long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
