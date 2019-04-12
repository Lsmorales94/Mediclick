package com.mediclip.core.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mediclip.core.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends  JpaRepository<TipoUsuario, Integer>{

}
