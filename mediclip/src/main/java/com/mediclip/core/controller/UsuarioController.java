/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediclip.core.controller;

import com.mediclip.core.Exception.FailCreateException;
import com.mediclip.core.entities.TipoUsuario;
import com.mediclip.core.entities.Usuario;
import com.mediclip.core.repositories.UsuarioRepository;
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
    
    @Autowired
    UsuarioRepository usuarioRepository;
    

    //registra usuario 
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/registrar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario user) {

        Usuario usr = this.usuarioService.findByCorreo(user.getCorreo());
        if (usr != null) {

            throw new EntityNotFoundException("El usuario se encuentra registrado");
        }
        return new ResponseEntity<>(usuarioService.Save(user), HttpStatus.CREATED);
    }

    //valida usuario y contraseña
    @CrossOrigin(origins = "*")
    @GetMapping(value = "login/email/{email}/password/{password}")
    public ResponseEntity<Usuario> login(@Valid @PathVariable String email, @Valid @PathVariable String password) {

        Usuario user = this.usuarioService.findByCorreoAndPass(email, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //lista los tipos de usuario  * ***** error  ****
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getTipousuario")
    public ResponseEntity<List<TipoUsuario>> getTipousuario() {
        return new ResponseEntity<>(usuarioService.List(), HttpStatus.OK);
    }

    //lista los usuarios registrados
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Usuario>> List() {
        return new ResponseEntity<>(usuarioService.ListarUsuario(), HttpStatus.OK);
    }

    //busca un usuario por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findOne(@Valid @PathVariable Integer id) {

        Optional<Usuario> user = this.usuarioService.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

    //Actualiza los datos del usuario
    @PutMapping("/usuarioId/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer id,
            @Valid @RequestBody Usuario usuarioUpdated) {
        return usuarioService.findOne(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioUpdated.getNombre());
                    usuario.setApellido(usuarioUpdated.getApellido());
                    usuario.setPass(usuarioUpdated.getPass());
                    usuario.setCorreo(usuarioUpdated.getCorreo());
                    usuario.setTipoUsuario(usuarioUpdated.getTipoUsuario());

                    return new ResponseEntity<>(usuarioService.Save(usuario), HttpStatus.ACCEPTED);
                }).orElseThrow(() -> new FailCreateException("No se pudo actualizar el usuario con id " + id));
    }
    
    @DeleteMapping("/usuarioId/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return usuarioService.findOne(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + id));
    }

}
