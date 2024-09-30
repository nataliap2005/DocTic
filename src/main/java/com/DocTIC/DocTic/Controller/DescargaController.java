package com.DocTIC.DocTic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.server.RSocketServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocTIC.DocTic.Model.DescargaModel;
import com.DocTIC.DocTic.Service.IDescargaService;


/**
 * [DescargaController]
 * 
 * Este controlador gestiona todas las operaciones relacionadas con las descargas
 * en la aplicación DocTIC. Proporciona endpoints REST para insertar, obtener,
 * listar y eliminar descargas de documentos por parte de los usuarios.
 * 
 * 29-09-2024
 *  */

@RestController
@RequestMapping("/doctic/v1/descarga")
public class DescargaController {
    @Autowired IDescargaService descargaService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearDescarga(@RequestBody DescargaModel descarga){
        return new ResponseEntity<String>(descargaService.insertarDescarga(descarga), HttpStatus.OK);
    }
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerDescarga(@PathVariable int id){
        try{
            return new ResponseEntity<DescargaModel> (descargaService.buscarDescargaPorId(id), HttpStatus.OK);

        }catch (RSocketServerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    };

    @GetMapping("/listar")
    public ResponseEntity<List<DescargaModel>> listarDescargas(){
        return new ResponseEntity<List<DescargaModel>>(descargaService.listarDescargas(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDescargas(@PathVariable int id){
        return new ResponseEntity<String>(descargaService.eliminarDescargaPorId(id), HttpStatus.OK);
    }
}
