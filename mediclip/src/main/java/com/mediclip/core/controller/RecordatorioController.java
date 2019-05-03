/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediclip.core.controller;

import com.mediclip.core.Exception.FailCreateException;
import com.mediclip.core.common.Menssage;
import com.mediclip.core.entities.Recordatorio;
import com.mediclip.core.entities.Usuario;
import com.mediclip.core.repositories.RecordatorioRepository;
import com.mediclip.core.repositories.UsuarioRepository;
import com.mediclip.core.services.RecordatorioService;
import com.mediclip.core.services.UsuarioService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author britney guzman
 */
@Controller
@CrossOrigin
@RequestMapping("/recordatorios")
public class RecordatorioController {
    
    @Autowired 
    RecordatorioService recordatorioService;
    
    @Autowired 
    RecordatorioRepository recordatorioRepository;    
    
    @Autowired
    UsuarioRepository usuarioRepository;    
    
    @Autowired
    UsuarioService usuarioService;
    
        
    //Agregar Recordatorio a un usuario Registrado
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/usuario/{usuario_id}/agregarRecordatorio")
    public ResponseEntity<Recordatorio> agregarRecordatorio(@Valid @PathVariable Integer usuario_id,
                               @Valid @RequestBody Recordatorio recordatorio) {
          return usuarioRepository.findById(usuario_id)
                  .map(usuario -> {
                      recordatorio.setUsuario(usuario);
                      return new ResponseEntity<>(recordatorioRepository.save(recordatorio), HttpStatus.CREATED);                      
                  }).orElseThrow(() -> new FailCreateException("No se encontró el usuario con id "+usuario_id));      
    }
    
    //lista los  recordatorios de un usuario
    @GetMapping("/usuario/{usuario_id}/listarRecordatorios")
    public ResponseEntity<List<Recordatorio>> listarRecordatoriobyUsuarioId (@Valid @PathVariable Integer usuario_id){
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);

        if (!user.isPresent()) {
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }   	
        return new ResponseEntity<>( recordatorioRepository.findByUsuarioId(usuario_id), HttpStatus.OK);   
    }
    
    //Actualiza Recordatorio
    @PutMapping("/usuarioId/{usuario_id}/recordatorioId/{recordatorio_Id}")
    public ResponseEntity<Recordatorio> updateRecordatorio(@PathVariable Integer usuario_id,
    						   @PathVariable Integer recordatorio_Id,
    						   @Valid @RequestBody Recordatorio recordatorioUpdated) {
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);
        if (user.isPresent()) {
            
            return recordatorioRepository.findById(recordatorio_Id)
                .map(recordatorio -> {
                    recordatorio.setRecordatorioDescripcion(recordatorioUpdated.getRecordatorioDescripcion());
                    recordatorio.setRecordatorioFecha(recordatorioUpdated.getRecordatorioFecha());
                    
                     return new ResponseEntity<>(recordatorioRepository.save(recordatorio), HttpStatus.ACCEPTED); 
                }).orElseThrow(() -> new EntityNotFoundException("No se pudo encontrar el Recordatorio "+recordatorio_Id));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
    }
    
    //Borra Recordatorio
    @DeleteMapping("/usuarioId/{usuarioId}/recordatorioId/{recordatorioId}")
    public ResponseEntity<Menssage> deleteRecordatorio(@PathVariable Integer usuarioId,
    							   @PathVariable Integer recordatorioId) {
    	
    	Optional<Usuario> user = this.usuarioService.findOne(usuarioId);
        if (user.isPresent()) {
    	
            return recordatorioRepository.findById(recordatorioId)
                    .map(tarea -> {
                        recordatorioRepository.delete(tarea);
                        return new ResponseEntity<Menssage>(new Menssage("eliminada"),HttpStatus.ACCEPTED);
                    }).orElseThrow(() -> new EntityNotFoundException("Recordatorio no encontrado !"));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario id "+usuarioId);
    }
}
