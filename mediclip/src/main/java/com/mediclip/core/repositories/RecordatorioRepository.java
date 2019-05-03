package com.mediclip.core.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mediclip.core.entities.Recordatorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordatorioRepository extends  JpaRepository<Recordatorio, Integer>{
     List<Recordatorio> findByUsuarioId(Integer usuarioId);
}
