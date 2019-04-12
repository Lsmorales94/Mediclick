package com.mediclip.core.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tratamiento")
public class Tratamiento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tr_id")
	long id;
	
	@Column(name = "tr_nombre", nullable = false)
	String nombre;

	@Column(name = "tr_descripcion")
	String descripcion;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tr_enfermedad")
	Enfermedad enfermedad;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tr_usuario")
	Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tr_medicamento", nullable = false)
	Medicamento medicamento[];
	
	
}
