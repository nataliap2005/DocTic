package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.DescargaModel;

@Repository
public interface IDescargaRepository extends JpaRepository<DescargaModel, Integer>{

    //Consulta para obtener todas las descargas de un usuario
    @Query ("SELECT d FROM DescargaModel d WHERE d.usuario.idUsuario = :idUsuario")
    List<DescargaModel> findDescargasByUsuario(@Param("idUsuario") int idUsuario);
    
    
}
