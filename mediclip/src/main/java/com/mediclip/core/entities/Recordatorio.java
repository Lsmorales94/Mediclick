/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediclip.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author britney guzman
 */

@Entity
@Table(name="recordatorio")
public class Recordatorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Recordatorio")
    private Integer id;

    @Column(name = "recordatorio_fecha")
    private Date recordatorioFecha;
    
    @Column(name = "recordatorio_descripcion")
    private String recordatorioDescripcion;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;
        

    public Recordatorio() {
    }

    public Recordatorio(Integer id, Date recordatorioFecha, String recordatorioDescripcion, Usuario usuario) {
        this.id = id;
        this.recordatorioFecha = recordatorioFecha;
        this.recordatorioDescripcion = recordatorioDescripcion;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordatorioFecha() {
        return recordatorioFecha;
    }

    public void setRecordatorioFecha(Date recordatorioFecha) {
        this.recordatorioFecha = recordatorioFecha;
    }

    public String getRecordatorioDescripcion() {
        return recordatorioDescripcion;
    }

    public void setRecordatorioDescripcion(String recordatorioDescripcion) {
        this.recordatorioDescripcion = recordatorioDescripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
}
