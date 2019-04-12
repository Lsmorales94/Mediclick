package com.mediclip.core.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mediclip.core.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TratamientoRepository extends  JpaRepository<Tratamiento, Integer>{

}
