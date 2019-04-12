package com.mediclip.core.repositories;

import com.mediclip.core.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends  JpaRepository<Usuario, Integer>{

    public Usuario findByCorreoAndPass(String email, String password);

    public Usuario findByCorreo(String email);

}
