package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.VisualizaModel;

@Repository
public interface IVisualizaRepository extends JpaRepository <VisualizaModel, Integer> {

       /**
 * IVisualizaRepository interfaz gestiona la interacción
 * con la base de datos para rastrear las visualizaciones de documentos por parte de los usuarios.
 *
 * Además, esta interfaz incluye una consulta personalizada para obtener todas las visualizaciones
 * de documentos realizadas por un usuario específico.
 *
 * Consulta personalizada:
 * - Devuelve una lista de objetos que contienen el nombre del usuario, el nombre del documento,
 *   la fecha y la hora en que fue visualizado.
 *
 * @param idUsuario El identificador del usuario del cual se quiere obtener las visualizaciones.
 * @return Una lista de arreglos de objetos (Object[])
 
 * @see JpaRepository
 * @see VisualizaModel
 * 29-09-2024
 */

    @Query("SELECT u.nombre, d.nombre, v.fecha, v.hora " +
           "FROM VisualizaModel v " +
           "JOIN v.documento d " +
           "JOIN v.usuario u " +
           "WHERE u.idUsuario = :idUsuario")
    List<Object[]> findVisualizacionesByUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT v FROM VisualizaModel v WHERE v.usuario.idUsuario = :idUsuario")
    List<VisualizaModel> findAllVisualizacionesByUsuario(@Param("idUsuario") int idUsuario);


}
