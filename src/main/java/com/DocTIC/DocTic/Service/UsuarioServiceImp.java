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
    public UsuarioModel buscarUsuarioPorId(int usuarioId) {
        Optional<UsuarioModel> UsuarioRecuperadado = usuarioRepository.findById(usuarioId);
        return UsuarioRecuperadado.orElseThrow(()-> new RecursoNoEncontradoException
        ("Error! El Usuario con el Id "+usuarioId+", no existe en la BD o el id incorrecto"));
    }
    @Override
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    @Override
    public String registroUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);// hace el llamado al crud interno
        return "El Usuario "+usuario.getNombre()+ " fue creado con exito";
    }
    @Override
    public String editarUsuario(int usuarioId, UsuarioModel usuarioNuevo) {
        Optional<UsuarioModel> UsuarioEncontrado = usuarioRepository.findById(usuarioId);
       
        if (UsuarioEncontrado.isPresent()) {
            UsuarioModel usuario = UsuarioEncontrado.get();
            usuario.setNombre(usuarioNuevo.getNombre());
            usuario.setNumDocumento(usuarioNuevo.getNumDocumento());
            usuario.setNickname(usuarioNuevo.getNickname());
            usuario.setEmail(usuarioNuevo.getEmail());
            usuario.setCiudad(usuarioNuevo.getCiudad());
            usuario.setDepartamento(usuarioNuevo.getDepartamento());
            usuario.setPreguntaSecreta(usuarioNuevo.getPreguntaSecreta());
            usuario.setRespuestaSecreta(usuarioNuevo.getRespuestaSecreta());   
            usuarioRepository.save(usuario);

            return "El usuario con id "+usuarioId+" fue editado con exito"; 
        } else {
            return null;
        }
    }
    @Override
    public void eliminarUsuarioPorId(int usuarioId) {
       usuarioRepository.deleteById(usuarioId); 
    }
}
