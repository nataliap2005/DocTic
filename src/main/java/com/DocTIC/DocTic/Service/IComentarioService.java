package com.DocTIC.DocTic.Service;

import java.util.List;

import com.DocTIC.DocTic.Model.ComentarioModel;

/**
 * [IComentarioService]
 * 
 * Interfaz que define las operaciones relacionadas con la gestión de comentarios
 * 
 * 25-09-2024
 */

public interface IComentarioService{
   /**
     * [crearComentario]
     * 
     * Este método se encarga de crear un nuevo comentario en el sistema.
     * 
     * 25-09-2024
     */

    String crearComentario(ComentarioModel comentario);

     /**
     * [buscarComentarioPorId]
     * 
     * Este método se encarga de buscar y recuperar un comentario por su id.
     * 
     * 25-09-2024
     */

    ComentarioModel buscarComentarioPorId(int comentarioId);

    /**
     * [listarComentarios]
     * 
     * Este método se encarga de recuperar todos los comentarios de la base de datos.
     * 
     * 25-09-2024
     */

    List<ComentarioModel> listarComentarios();

    /**
     * [editarComentario]
     * 
     * Este método se encarga de editar un comentario existente en la base de datos.
     * 
     * 25-09-2024
     */
    String editarComentario(ComentarioModel comentario);

    /**
     * [eliminarComentario]
     * 
     * Este método se encarga de eliminar un comentario de la base de datos.
     * 
     * 26-09-2024
     */
    
    String eliminarComentario(int comentarioId);
}
