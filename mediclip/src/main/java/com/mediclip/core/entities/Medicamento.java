package com.mediclip.core.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "med_id")
	long id;

	@Column(name = "med_nombre", nullable = false)
	String nombre;

	@Column(name = "med_dosis")
	int dosis;

	@Column(name = "med_posologia")
	int posologia;

	public Medicamento() {

	}

	public Medicamento(long id, String nombre, int dosis, int posologia) {
		this.id = id;
		this.nombre = nombre;
		this.dosis = dosis;
		this.posologia = posologia;
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

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getPosologia() {
		return posologia;
	}

	public void setPosologia(int posologia) {
		this.posologia = posologia;
	}
}
