package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.UsuarioModel;
import com.DocTIC.DocTic.Repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired IUsuarioRepository usuarioRepository;
    
    
    @Override
    public UsuarioModel buscarUsuarioPorId(int UsuarioId) {
        Optional<UsuarioModel> UsuarioRecuperadado = usuarioRepository.findById(UsuarioId);
        return UsuarioRecuperadado.orElseThrow(()-> new RecursoNoEncontradoException
        ("Error! El Usuario con el Id "+UsuarioId+", no existe en la BD o el id incorrecto"));
    }
    @Override
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    @Override
    public String registroUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);// hace el llamado al crud interno
        return "El Usuario "+usuario.getNombre()+
               " "+usuario.getNombre()+ " fue creado con exito";
    }
    @Override
    public UsuarioModel editarUsuario(UsuarioModel usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarUsuario'");
    }
    @Override
    public void eliminarUsuario(int usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
    }
}
