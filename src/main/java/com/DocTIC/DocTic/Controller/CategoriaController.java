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
import com.DocTIC.DocTic.Model.CategoriaModel;
import com.DocTIC.DocTic.Service.ICategoriaService;

@RestController
@RequestMapping("/doctic/v1/categorias")
public class CategoriaController {

    @Autowired ICategoriaService categoriaService;
    
    @PostMapping("/insertar")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaModel categoria){
        return new ResponseEntity<String> (categoriaService.insertarCategoria(categoria), HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerCategoria(@PathVariable int id){
        try {
            return new ResponseEntity<CategoriaModel> (categoriaService.buscarCategoriaPorId(id), HttpStatus.OK);
            
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            
        }
    }; 

    @GetMapping("/obtener")
    public ResponseEntity<List<CategoriaModel>> obtenerCategorias(){
        return  new ResponseEntity<List<CategoriaModel>>(categoriaService.obtenerCategorias(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
        return new ResponseEntity<String>(categoriaService.eliminarCategoriaPorId(id), HttpStatus.OK);

    }
    
}
