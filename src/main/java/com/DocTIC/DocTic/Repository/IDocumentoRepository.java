package com.DocTIC.DocTic.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DocTIC.DocTic.Model.DocumentoModel;

/**
 * IDocumentoRepository es una interfaz que extiende JpaRepository para proporcionar
 * operaciones CRUD sobre la entidad DocumentoModel. 
 *
 * @see JpaRepository
 * @see DocumentoModel
 * 16-09-2024
 */

public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario.
}
  

