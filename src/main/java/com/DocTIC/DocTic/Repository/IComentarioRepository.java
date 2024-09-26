package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.ComentarioModel;

/**
 * [IComentarioRepository]
 * 
 * Esta interfaz extiende de JpaRepository y proporciona un conjunto de métodos predefinidos para realizar operaciones CRUD.
 * 
 * 25-09-2024
 */

@Repository
public interface IComentarioRepository extends JpaRepository<ComentarioModel, Integer>{
    
}
