package com.DocTIC.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Model.ComentarioModel;
import com.DocTIC.DocTic.Repository.IComentarioRepository;


/**
 * [ComentarioServiceImp]
 * 
 * Esta clase implementa la interfaz [IComentarioService] y se encarga de la lógica de negocio relacionada con la gestión de comentarios. Proporciona los métodos necesarios para realizar las operaciones CRUD sobre los comentarios. 
 * 
 * 25-09-2024
 */

@Service
public class ComentarioServiceImp implements IComentarioService{
    
    @Autowired IComentarioRepository comentarioRepository;
    
    /**
     * [crearComentario]
     * 
     * Este método se encarga de crear un nuevo comentario en el sistema.
     * 
     * 25-09-2024
     */
    @Override
    public String crearComentario(ComentarioModel comentario) {
        comentarioRepository.save(comentario);
        return "El comentario con id " + comentario.getIdComentario() + " fue creado con éxito.";
    } 
        
}
