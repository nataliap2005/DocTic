package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.ConflictoDatosExcepcion;
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

        if(comentario.getIdComentario() == null){
            
            List<ComentarioModel> comentarios = comentarioRepository.findAll();

            if (comentarios.isEmpty()) {
                comentario.setIdComentario(1);
                                                
            }else{
                Integer lastIdInDb = comentarios.getLast().getIdComentario(); 
                comentario.setIdComentario(lastIdInDb+1); 
            }        
            comentarioRepository.save(comentario);
            return "El comentario se creó con éxito ID: " + comentario.getIdComentario();

     
        }else{
            try {
                System.out.println("--- Intentando");
                comentarioRepository.save(comentario);
                return "El comentario se creó con éxito ID: " + comentario.getIdComentario();

            } catch (Exception e) {
                System.out.println("--- tipo de exception: " + e.getClass().toString());

                throw new ConflictoDatosExcepcion("¡Error! No se pudo crear el comentario con ID " + comentario.getIdComentario() + ". Es posible que el ID del comentario sea igual subIdComentario.");
            }    
        }
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

        Optional <ComentarioModel> comentarioDB = comentarioRepository.findById(comentario.getIdComentario());

        if (comentarioDB.isPresent()) {
            comentarioRepository.save(comentario);
            return "Éxito al actualizar el comentario con ID " + comentario.getIdComentario();      
        }else{
            throw new RecursoNoEncontradoException("¡Error! El comentario con ID " + comentario.getIdComentario() + " no existe en la base de datos o es incorrecto.")  ;
        }
    }

    @Override
    public String eliminarComentario(int comentarioId) {

        Optional<ComentarioModel> comentario = comentarioRepository.findById(comentarioId);
        
        if (comentario.isPresent()) {
            
            List<ComentarioModel> comentariosHijos = comentarioRepository.findBySubIdComentario(comentarioId);

        for (ComentarioModel comentarioHijo : comentariosHijos) {
                        
            comentarioRepository.deleteById(comentarioHijo.getIdComentario());
        }

        comentarioRepository.deleteById(comentarioId);
        
        return "Éxito al aliminar el comentario con ID " + comentarioId;
            
        } else {
            return "¡Error! No exise un comentario con ID " + comentarioId;
        }        
    }
}
