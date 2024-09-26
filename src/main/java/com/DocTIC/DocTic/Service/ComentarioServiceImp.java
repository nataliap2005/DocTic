package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
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
    
    @Override
    public String crearComentario(ComentarioModel comentario) {
        comentarioRepository.save(comentario);
        return "El comentario se creó con éxito ID: " + comentario.getIdComentario();
    }

    @Override
    public ComentarioModel buscarComentarioPorId(int comentarioId) {
       Optional<ComentarioModel> comentarioRecuperado = comentarioRepository.findById(comentarioId);

       return comentarioRecuperado.orElseThrow(()-> new RecursoNoEncontradoException("¡Error! El comentario con el lid " + comentarioId + " no existe en la base de datos o es incorrecto."));
    } 

    @Override
    public List<ComentarioModel> listarComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public String editarComentario(ComentarioModel comentario) {
        comentarioRepository.save(comentario);
        return "Éxito al actualizar el comentario con ID " + comentario.getIdComentario(); 
    }

    @Override
    public String eliminarComentario(int comentarioId) {

        List<ComentarioModel> comentariosHijos = comentarioRepository.findBySubIdComentario(comentarioId);
        System.out.println("--- Entrando a eliminar comentarios...");

        for (ComentarioModel comentarioHijo : comentariosHijos) {
            
            System.out.println("--- Se encontró el comentario hijo con ID: "+comentarioHijo.getIdComentario().toString());
            
            comentarioRepository.deleteById(comentarioHijo.getIdComentario());
        }

        comentarioRepository.deleteById(comentarioId);
        return "Éxito al aliminar el comentario con ID " + comentarioId;
    }
}
