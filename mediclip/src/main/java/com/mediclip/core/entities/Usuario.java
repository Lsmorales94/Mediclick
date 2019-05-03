package com.mediclip.core.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    int id;
     
    @Column(name = "usr_nombre", nullable = false)
    String nombre;

    @Column(name = "usr_apellido", nullable = false)
    String apellido;

    @Column(name = "usr_correo", nullable = false)
    String correo;

    @Column(name = "usr_pass", nullable = false)
    String pass;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Recordatorio> recordatorio;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_tusuario")
    TipoUsuario tipoUsuario;

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String apellido, String correo, String pass, Set<Recordatorio> recordatorio, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
        this.recordatorio = recordatorio;
        this.tipoUsuario = tipoUsuario;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Recordatorio> getTareas() {
        return recordatorio;
    }

    public void setTareas(Set<Recordatorio> tareas) {
        this.recordatorio = tareas;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
