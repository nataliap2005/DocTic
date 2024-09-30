package com.DocTIC.DocTic.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //Consulta para obtener todas las publicaciones de un usuario
    @Query("SELECT p FROM PublicaModel p WHERE p.usuario.idUsuario = :idUsuario")
    List<PublicaModel> findPublicacionByUsuario(@Param("idUsuario") int idUsuario);

    
}
