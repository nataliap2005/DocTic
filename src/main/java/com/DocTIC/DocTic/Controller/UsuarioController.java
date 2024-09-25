package com.DocTIC.DocTic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DocTIC.DocTic.Service.IUsuarioService;


@RestController
@RequestMapping("/doctic/v1/usuarios")
public class UsuarioController {
    @Autowired IUsuarioService usuarioService;
}
