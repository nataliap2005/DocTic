package com.DocTIC.DocTic.Service;
import com.DocTIC.DocTic.Model.UsuarioModel;
import java.util.List;


public interface IUsuarioService {
 //definir todos los métodos abstractos de las operaciones CRUD
    //definiriamos los métodos de la lógica del negocio
    String registroUsuario(UsuarioModel usuario);
    UsuarioModel buscarUsuarioPorId(int usuarioId);
    List<UsuarioModel> listarUsuarios();
    // editar usuario existente
    String editarUsuario(int usuarioId, UsuarioModel usuario);
    //--  eliminar por id
    void eliminarUsuarioPorId(int usuarioId);
}
