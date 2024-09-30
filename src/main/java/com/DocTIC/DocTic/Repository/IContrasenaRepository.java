package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.ContrasenaModel;

@Repository
public interface IContrasenaRepository extends JpaRepository <ContrasenaModel, Integer> {

    /* Consulta para obtener el historial de contraseñas por usuario 

     @Query("SELECT c FROM ContrasenaModel c WHERE c.usuario.idUsuario = :idUsuario")
    List<ContrasenaModel> findHistorialContrasenasByUsuario(@Param("idUsuario") int idUsuario);
    */

    /*Consulta para obtener el historial de contraseñas por usuario de forma más especifica*/
    @Query("SELECT c.idHistorial, c.usuario.nombre, c.contrasena, c.fecha, c.estado " +
    "FROM ContrasenaModel c WHERE c.usuario.idUsuario = :idUsuario")
    List<Object[]> findHistorialContrasenasByUsuario(@Param("idUsuario") int idUsuario);
}