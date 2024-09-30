package com.DocTIC.DocTic.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.ValoraModel;

/**
 * IValoraRepository es una interfaz que extiende JpaRepository para proporcionar
 * operaciones CRUD sobre la entidad ValoraModel. Esta interfaz gestiona la interacción
 * con la base de datos para almacenar y recuperar valoraciones realizadas por los usuarios
 * sobre documentos.
 * @see JpaRepository
 * @see ValoraModel
 * 
 * 16-09-2024
 */
@Repository
public interface IValoraRepository extends JpaRepository<ValoraModel, Integer>{

   @Query("SELECT v FROM ValoraModel v WHERE v.usuario.idUsuario = :idUsuario")
    List<ValoraModel> findValoracionByUsuario(@Param("idUsuario") int idUsuario);
    
}
