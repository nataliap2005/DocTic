package com.DocTIC.DocTic.Service;
import com.DocTIC.DocTic.Model.ContrasenaModel;

import java.util.List;
import java.util.Map;

public interface IContrasenaService {
    String insertarhistorialContrasena(ContrasenaModel historialContrasenaData);
    
    ContrasenaModel obtenerHistContrasena (int historialContrasenaId);

    List <ContrasenaModel> listarHistorialContrasena();

    void actualizarContrasenaInactiva(int idUsuario, int idHistorial);
    

    // List<ContrasenaModel> obtenerHistorialContrasenasPorUsuario(int idUsuario);
    List<Map<String, Object>> getHistorialContrasenasByUsuario(int idUsuario);
    
}


