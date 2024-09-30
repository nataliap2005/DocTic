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
import com.DocTIC.DocTic.Model.DocumentoModel;
import com.DocTIC.DocTic.Service.IDocumentoService;
/**
 * [DocumentoController]
 * 
 * Este controlador gestiona todas las operaciones relacionadas con los documentos
 * en la aplicación DocTIC. Proporciona endpoints REST para crear, obtener, editar,
 * listar y eliminar documentos.
 * 
 *  25-09-2024
 * **/
@RestController
@RequestMapping("/doctic/v1/documentos")
public class DocumentoController {

    @Autowired
    private IDocumentoService documentoService;

    // Crear un nuevo documento
    @PostMapping("/insertar")
    public ResponseEntity<String> crearDocumento(@RequestBody DocumentoModel documento) {
        return new ResponseEntity<>(documentoService.crearDocumento(documento), HttpStatus.CREATED);
    }

    // Obtener un documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDocumentoPorId(@PathVariable int id) {
        try {
            DocumentoModel documento = documentoService.buscarDocumentoPorId(id);
            return ResponseEntity.ok(documento);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Listar todos los documentos
    @GetMapping("/listarDocumentos")
    public ResponseEntity<List<DocumentoModel>> mostrarDocumentos() {
        return new ResponseEntity<>(documentoService.listarDocumentos(), HttpStatus.OK);
    }

    // Editar un documento
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarDocumento(@PathVariable int id, @RequestBody DocumentoModel documentoNuevo) {
        try {
            documentoService.editarDocumento(id, documentoNuevo);
            return new ResponseEntity<>("El documento con id " + id + " fue actualizado con éxito.", HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un documento por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDocumento(@PathVariable int id) {
        try {
            documentoService.eliminarDocumento(id);
            return ResponseEntity.ok("Documento con ID " + id + " eliminado con éxito.");
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
