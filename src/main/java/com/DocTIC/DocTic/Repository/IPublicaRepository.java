package com.DocTIC.DocTic.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.PublicaModel;

@Repository
public interface IPublicaRepository extends JpaRepository<PublicaModel, Integer> {

    //Consulta para obtener todas las publicaciones de un usuario
    @Query("SELECT p FROM PublicaModel p WHERE p.usuario.idUsuario = :idUsuario")
    List<PublicaModel> findPublicacionByUsuario(@Param("idUsuario") int idUsuario);

    
}
