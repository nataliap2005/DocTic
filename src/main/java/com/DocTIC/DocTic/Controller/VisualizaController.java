package com.DocTIC.DocTic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.VisualizaModel;
import com.DocTIC.DocTic.Service.IVisualizaService;

@RestController
@RequestMapping("/doctic/v1/visualiza")
public class VisualizaController {
    @Autowired IVisualizaService visualizaService;
    
    @PostMapping("/insertar")
    public ResponseEntity <String> crearVisualizacion(@RequestBody VisualizaModel visualiza){
        return new ResponseEntity<String>(visualizaService.insertarVisualiza(visualiza),HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerVisualizacion(@PathVariable int id){
        try{
            return new ResponseEntity<VisualizaModel>(visualizaService.buscarVisualizacionPorId(id),HttpStatus.OK);

        }catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    };
    
    @GetMapping("/listar")
    public ResponseEntity<List<VisualizaModel>> listarVisualizaciones(){
        return new ResponseEntity<List<VisualizaModel>>(visualizaService.listarVisualizaciones(),HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarVisualizaciones(@PathVariable int id){
        return new ResponseEntity<String>(visualizaService.eliminarVisualizacionPorId(id),HttpStatus.OK);
    }
}
