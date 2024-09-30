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

import com.DocTIC.DocTic.Exception.ConflictoDatosExcepcion;
import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ValoraModel;
import com.DocTIC.DocTic.Service.IValoraService;

/**
 * [ValoraController]
 * 
 * Este controlador gestiona todas las operaciones relacionadas con la entidad ValoraModel, 
 * que representa las valoraciones hechas por los usuarios en la aplicación DocTIC.
 * Proporciona endpoints REST para insertar, obtener, editar y eliminar valoraciones.
 * 
 * 28-09-2024
 * **/

@RestController
@RequestMapping("/doctic/v1/valoraciones")
public class ValoraController {
    @Autowired IValoraService valoraService;

    @PostMapping("/insertar")
    public ResponseEntity<?> postValoracion(@RequestBody ValoraModel valoracion) {
        try {
            return ResponseEntity.ok(valoraService.crearValoracion(valoracion));
        } catch (Exception e) {
            if(e.getClass() == ConflictoDatosExcepcion.class) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
            }
        }              
    }
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> getValoracionById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(valoraService.obtenerValoracionById(id));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }
    
    @GetMapping("/obtener")
    public List<ValoraModel> getValoraciones() {
        return valoraService.obtenerValoraciones();
       
    }

    @PutMapping("/editar")
    public ResponseEntity<?> putValoracion(@RequestBody ValoraModel valoracion) {
        try {
            return ResponseEntity.ok(valoraService.editarValoracion(valoracion));
        } catch (Exception e) {
            if (e.getClass() == RecursoNoEncontradoException.class) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());                
            }else if(e.getClass() == ConflictoDatosExcepcion.class) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarValoracion(@PathVariable int id) {

        try {
            return ResponseEntity.ok(valoraService.eliminarValoracion(id));
            
        } catch (RecursoNoEncontradoException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
               
    }

    @GetMapping("/obtener/usuario/{id}")
    public ResponseEntity<?> getValoracionByUsuario(@PathVariable int id){
        return ResponseEntity.ok(valoraService.findValoracionByUsuario(id));
    }
}
