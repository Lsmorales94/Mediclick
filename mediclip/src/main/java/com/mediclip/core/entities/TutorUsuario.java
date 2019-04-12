package com.mediclip.core.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tutor_usuario")
public class TutorUsuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tut_id")
	long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tut_tutor")
	Usuario tutor;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente")
	Usuario paciente;

	public TutorUsuario() {
		
	}
	
	public TutorUsuario(long id, Usuario tutor, Usuario paciente) {
		this.id = id;
		this.tutor = tutor;
		this.paciente = paciente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getTutor() {
		return tutor;
	}

	public void setTutor(Usuario tutor) {
		this.tutor = tutor;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}
	
}
