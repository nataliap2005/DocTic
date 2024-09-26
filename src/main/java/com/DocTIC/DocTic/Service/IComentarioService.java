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
    String crearComentario(ComentarioModel comentario);
    ComentarioModel buscarComentarioPorId(int comentarioId);
    List<ComentarioModel> listarComentarios();
  
}
