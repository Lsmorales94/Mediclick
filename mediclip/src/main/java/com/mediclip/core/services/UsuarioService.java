package com.mediclip.core.services;

import com.mediclip.core.entities.TipoUsuario;
import com.mediclip.core.entities.Usuario;
import com.mediclip.core.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.mediclip.core.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository UsuarioRepository;
        private TipoUsuarioRepository TipoUsuarioRepository;

    public Usuario Save(Usuario usuario){
        return UsuarioRepository.save(usuario);
    }
    
    public List<TipoUsuario> List(){
        return TipoUsuarioRepository.findAll();
    }
    
    public List<Usuario> ListarUsuario(){
        return UsuarioRepository.findAll();
    }
    
    public Optional<Usuario> findOne(Integer id){
        return this.UsuarioRepository.findById(id);
    }
       
    public Usuario findByCorreoAndPass(String email, String password) {
         return UsuarioRepository.findByCorreoAndPass(email, password);
    }
    
    public Usuario findByCorreo(String email) {
         return UsuarioRepository.findByCorreo(email);
    }
}
