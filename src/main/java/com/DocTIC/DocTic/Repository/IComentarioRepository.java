package com.DocTIC.DocTic.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.ComentarioModel;
import java.util.List;

/**
 * [IComentarioRepository]
 * 
 * Esta interfaz extiende de JpaRepository y proporciona un conjunto de métodos predefinidos para realizar operaciones CRUD.
 * 
 * 25-09-2024
 */

@Repository
public interface IComentarioRepository extends JpaRepository<ComentarioModel, Integer>{

        /**
         * [findBySubIdComentario]
         * 
         * Este método se encarga de encontrar todos los comentarios hijos por su subIdComentario.
         * 
         * 26-09-2024
         */

        List<ComentarioModel> findBySubIdComentario(int subIdComentario);
}
