package com.DocTIC.DocTic.Service;
import com.DocTIC.DocTic.Model.ContrasenaModel;

import java.util.List;
import java.util.Map;

public interface IContrasenaService {
    String insertarhistorialContrasena(ContrasenaModel historialContrasenaData);
    
    ContrasenaModel obtenerHistContrasena (int historialContrasenaId);

    List <ContrasenaModel> listarHistorialContrasena();

    // List<ContrasenaModel> obtenerHistorialContrasenasPorUsuario(int idUsuario);
    List<Map<String, Object>> getHistorialContrasenasByUsuario(int idUsuario);
    
}


