package com.DocTIC.DocTic.Controller;

import java.util.List;

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
import com.DocTIC.DocTic.Model.PublicaModel;
import com.DocTIC.DocTic.Service.IPublicaService;
/**
 * [PublicaController]
 * 
 * Este controlador gestiona todas las operaciones relacionadas con la entidad Publica,
 * que representa la publicación de documentos por los usuarios en la aplicación DocTIC.
 * Proporciona endpoints REST para insertar, obtener, listar, editar y eliminar publicaciones.
 * 
 * 28-09-2024
 * */

@RestController
@RequestMapping("/doctic/v1/publica")
public class PublicaController {
    @Autowired IPublicaService publicaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearPublicacion(@RequestBody PublicaModel publica){
        return new ResponseEntity<String>(publicaService.insertarPublica(publica), HttpStatus.OK);
    }

@GetMapping("/obtener/{id}")
public ResponseEntity<?> obtenerPublicacion(@PathVariable int id){
    try{
        return new ResponseEntity<PublicaModel> (publicaService.buscarPublicaPorId(id), HttpStatus.OK);

    }catch (RecursoNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
};

@GetMapping("/listar")
public ResponseEntity<List<PublicaModel>> listarPublicaciones(){
    return new ResponseEntity<List<PublicaModel>>(publicaService.listarPublicaciones(), HttpStatus.OK);
}

@PutMapping("/editar")
public ResponseEntity<String> editarPublicacion(@RequestBody PublicaModel PublicaModel){
    return new ResponseEntity<String>(publicaService.editarPublica(PublicaModel), HttpStatus.OK);
}

@DeleteMapping("/eliminar/{id}")
public ResponseEntity<String> eliminarPublicaciones(@PathVariable int id){
    return new ResponseEntity<String>(publicaService.eliminarPublicaPorId(id), HttpStatus.OK);
}
}
