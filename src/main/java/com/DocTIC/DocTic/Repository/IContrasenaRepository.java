package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.ContrasenaModel;
/**
 * IContrasenaRepository es una interfaz que extiende JpaRepository para proporcionar
 * operaciones CRUD sobre la entidad ContrasenaModel. Además, contiene consultas
 * personalizadas para obtener el historial de contraseñas por usuario.
 * Además, esta interfaz incluye consultas personalizadas con JPQL (Java Persistence Query Language)
 * para obtener el historial de contraseñas por usuario.
 *
 * @see JpaRepository
 * @see ContrasenaModel
 */

@Repository
public interface IContrasenaRepository extends JpaRepository <ContrasenaModel, Integer> {

     /**
     * Consulta para obtener el historial de contraseñas de un usuario específico.
     * Esta consulta devuelve una lista de objetos con los campos: idHistorial, nombre del usuario, 
     * contraseña, fecha de cambio, y estado de la contraseña.
     *
     * @param idUsuario El identificador del usuario del cual se quiere obtener el historial de contraseñas.
     * @return Una lista de arreglos de objetos (Object[]) 
     * 
     *  29-09-2024
     */
    @Query("SELECT c.idHistorial, c.usuario.nombre, c.contrasena, c.fecha, c.estado " +
    "FROM ContrasenaModel c WHERE c.usuario.idUsuario = :idUsuario")
    List<Object[]> findHistorialContrasenasByUsuario(@Param("idUsuario") int idUsuario);
}