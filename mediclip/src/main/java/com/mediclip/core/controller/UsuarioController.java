/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediclip.core.controller;

import com.mediclip.core.entities.TipoUsuario;
import com.mediclip.core.entities.Usuario;
import com.mediclip.core.repositories.UsuarioRepository;
import com.mediclip.core.services.UsuarioService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britney guzman
 */
@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
       
    @Autowired
    UsuarioService usuarioService;
    
       
    @CrossOrigin(origins="*")
    @GetMapping(value = "login/email/{email}/password/{password}")
    public  ResponseEntity<Usuario> login(@Valid @PathVariable String email,@Valid @PathVariable String password){
        
        Usuario user = this.usuarioService.findByCorreoAndPass(email,password);
        return new ResponseEntity<>(user, HttpStatus.OK);   
    }
    
    @CrossOrigin(origins="*")
    @GetMapping(value = "/getTipousuario") 
    public ResponseEntity<List<TipoUsuario>> getTipousuario (){        
        return new ResponseEntity<>(usuarioService.List(), HttpStatus.OK);
    }
    
    @CrossOrigin(origins="*")
    @PostMapping(value = "/registrar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario user){
       
        Usuario usr = this.usuarioService.findByCorreo(user.getCorreo());
            if(usr !=null){
               
                throw new EntityNotFoundException("El usuario se encuentra registrado");
            }
        return new ResponseEntity<>(usuarioService.Save(user), HttpStatus.CREATED);    
    }
    
}
