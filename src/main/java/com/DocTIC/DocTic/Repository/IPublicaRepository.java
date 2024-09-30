package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.PublicaModel;
/**
Esta interfaz permite la gestión de la relación entre los documentos y sus autores en la base de datos.
 * Esta interfaz puede ser utilizada para gestionar qué usuarios han publicado o co-autorado
 * un documento.
 * 
 * @see JpaRepository
 * @see PublicaModel
 * 
 * 16-09-2024
 */
@Repository

public interface IPublicaRepository extends JpaRepository<PublicaModel, Integer> {
    
}
