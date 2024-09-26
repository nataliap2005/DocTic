package com.DocTIC.DocTic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
