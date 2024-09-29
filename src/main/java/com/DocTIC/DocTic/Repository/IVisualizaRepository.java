package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.VisualizaModel;

@Repository
public interface IVisualizaRepository extends JpaRepository <VisualizaModel, Integer> {

    /* 
     @Query("SELECT v FROM VisualizaModel v " +
           "JOIN v.documento d " +
           "JOIN v.usuario u " +
           "WHERE u.idUsuario = :idUsuario")
    List<VisualizaModel> findVisualizacionesByUsuario(@Param("idUsuario") int idUsuario);
    */
    @Query("SELECT u.nombre, d.nombre, v.fecha, v.hora " +
           "FROM VisualizaModel v " +
           "JOIN v.documento d " +
           "JOIN v.usuario u " +
           "WHERE u.idUsuario = :idUsuario")
    List<Object[]> findVisualizacionesByUsuario(@Param("idUsuario") int idUsuario);
}
