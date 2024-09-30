package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.DescargaModel;

/**
 * IDescargaRepository es una interfaz que extiende JpaRepository para proporcionar
 * operaciones CRUD sobre la entidad DescargaModel. Esta interfaz le permite interactuar
 * con la base de datos de manera sencilla y eficaz, sin necesidad de escribir SQL manual.
     
 * @see JpaRepository
 * @see DescargaModel
 * 
 * 16-09-2024
 */

@Repository

public interface IDescargaRepository extends JpaRepository<DescargaModel, Integer>{
    
}
