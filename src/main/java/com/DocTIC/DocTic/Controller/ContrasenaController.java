package com.DocTIC.DocTic.Controller;

import java.util.List;
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
import com.DocTIC.DocTic.Model.ContrasenaModel;
import com.DocTIC.DocTic.Service.IContrasenaService;

@RestController
@RequestMapping("/doctic/v1/contrasena")

public class ContrasenaController {
    @Autowired IContrasenaService historialcontrasenaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> guardarHistorialContrasena(@RequestBody ContrasenaModel hContrasenaModel){

        return new ResponseEntity<String>(historialcontrasenaService.insertarhistorialContrasena(hContrasenaModel), HttpStatus.OK);
    } 

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerHistorialContrasenaId(@PathVariable int id){
        try {
            ContrasenaModel hContrasena = historialcontrasenaService.obtenerHistContrasena(id);
            return ResponseEntity.ok(hContrasena);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ContrasenaModel>> mostrarHistContrasena(){
        return new ResponseEntity<List<ContrasenaModel>>(historialcontrasenaService.listarHistorialContrasena(),HttpStatus.OK);
    }
}
    