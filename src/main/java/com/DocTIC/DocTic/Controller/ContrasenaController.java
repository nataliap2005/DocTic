package com.DocTIC.DocTic.Controller;

import java.util.List;
import java.util.Map;

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

/**
 * [ContrasenaController]
 * 
 * Este controlador gestiona las operaciones relacionadas con el historial de contraseñas
 * de los usuarios. Permite insertar, obtener, y listar contraseñas, así como realizar consultas
 * específicas sobre el historial de contraseñas de un usuario.
 * 
 * Endpoints disponibles:
 * - POST /insertar: Inserta una nueva entrada en el historial de contraseñas.
 * - GET /obtener/{id}: Obtiene una entrada del historial de contraseñas por su ID.
 * - GET /listar: Obtiene todas las entradas del historial de contraseñas.
 * - GET /historial/{id}: Consulta el historial de contraseñas de un usuario específico.
 * 
 * 29-09-2024
 */
@RestController
@RequestMapping("/doctic/v1/contrasena")

public class ContrasenaController {
    @Autowired IContrasenaService contrasenaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> guardarHistorialContrasena(@RequestBody ContrasenaModel hContrasenaModel){

        return new ResponseEntity<String>(contrasenaService.insertarhistorialContrasena(hContrasenaModel), HttpStatus.OK);
    } 

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerHistorialContrasenaId(@PathVariable int id){
        try {
            ContrasenaModel hContrasena = contrasenaService.obtenerHistContrasena(id);
            return ResponseEntity.ok(hContrasena);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ContrasenaModel>> mostrarHistContrasena(){
        return new ResponseEntity<List<ContrasenaModel>>(contrasenaService.listarHistorialContrasena(),HttpStatus.OK);
    }
    /* devuelve los datos de la consulta */
    // @GetMapping("/historial/{id}")
    // public ResponseEntity<List<ContrasenaModel>> obtenerHistorialContrasenas(@PathVariable("id") int idUsuario) {
    //     List<ContrasenaModel> historial = contrasenaService.obtenerHistorialContrasenasPorUsuario(idUsuario);
    //     return ResponseEntity.ok(historial);
    // }

    /* devuelve los datos de la consulta que definimos que queriamos especificamente 
    que retornar  
    */

    @GetMapping("/historial/{id}")
    public ResponseEntity<List<Map<String, Object>>> getHistorialContrasenasByUsuario(@PathVariable("id") int idUsuario) {
        List<Map<String, Object>> historial = contrasenaService.getHistorialContrasenasByUsuario(idUsuario);
        return ResponseEntity.ok(historial);
    }
}
    