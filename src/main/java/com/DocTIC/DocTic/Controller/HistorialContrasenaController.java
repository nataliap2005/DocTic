package com.DocTIC.DocTic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.HistorialContrasenaModel;
import com.DocTIC.DocTic.Service.IHistorialcontrasenaService;

@RestController
@RequestMapping("/doctic/v1/historial_contrasena")

public class HistorialContrasenaController {
    @Autowired IHistorialcontrasenaService historialcontrasenaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> guardarHistorialContrasena(@RequestBody HistorialContrasenaModel hContrasenaModel){

        return new ResponseEntity<String>(historialcontrasenaService.insertarhistorialContrasena(hContrasenaModel), HttpStatus.OK);
    } 

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerHistorialContrasenaId(@PathVariable int id){
        try {
            HistorialContrasenaModel hContrasena = historialcontrasenaService.obtenerHistContrasena(id);
            return ResponseEntity.ok(hContrasena);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
}
