package com.DocTIC.DocTic.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ComentarioDTO;
import com.DocTIC.DocTic.Model.ComentarioModel;
import com.DocTIC.DocTic.Service.IComentarioService;

/**
 * [ComentarioController]
 * 
 * Esta clase actúa como el punto de entrada para todas las operaciones relacionadas con los comentarios. Funciona como un controlador REST, por lo que se encarga de recibir solicitudes HTTP relacionadas con los comentarios y generar las correspondientes respuestas.
 * 
 * 25-09-2024
 */
@RestController
@RequestMapping("/doctic/v1/comentarios")
public class ComentarioController {
    @Autowired IComentarioService comentarioService;
    
    @PostMapping("/insertar")
    public ResponseEntity<String> guardarComentario(@RequestBody ComentarioModel comentario){
        return new ResponseEntity<String>(comentarioService.crearComentario(comentario), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> burcarComentarioPorId(@PathVariable int id){
        try {
            ComentarioModel comentario = comentarioService.buscarComentarioPorId(id);
            ComentarioDTO comentarioDTO = new ComentarioDTO(comentario);

            return ResponseEntity.ok(comentarioDTO);
            
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ComentarioDTO>> mostrarComentarios(){
        List<ComentarioModel> comentarios = comentarioService.listarComentarios();
        List<ComentarioDTO> comentarioDTOs = comentarios.stream().map(ComentarioDTO::new).collect(Collectors.toList());
        return new ResponseEntity<List<ComentarioDTO>> (comentarioDTOs, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> alterarComentario(@RequestBody ComentarioModel comentario){
        return new ResponseEntity<String>(comentarioService.editarComentario(comentario), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> borrarComentario(@PathVariable int id){

        return new ResponseEntity<String>(comentarioService.eliminarComentario(id), HttpStatus.OK);
    }
    
}
