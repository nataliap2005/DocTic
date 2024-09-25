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
import com.DocTIC.DocTic.Model.UsuarioModel;
import com.DocTIC.DocTic.Service.IUsuarioService;

@RestController
@RequestMapping("/doctic/v1/usuarios")
public class UsuarioController {
    @Autowired IUsuarioService usuarioService;
    @PostMapping("/insertar")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioModel usuario){
         return new ResponseEntity<String>(usuarioService.registroUsuario(usuario),HttpStatus.OK);
}
@GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable int id){
        try {
            UsuarioModel Usuario = usuarioService.buscarUsuarioPorId(id);
            return ResponseEntity.ok(Usuario);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioModel>> mostrarUsuarios(){
        return new ResponseEntity<List<UsuarioModel>>(usuarioService.listarUsuarios(),HttpStatus.OK);
    }
}
