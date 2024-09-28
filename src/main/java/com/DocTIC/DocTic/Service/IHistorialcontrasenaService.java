package com.DocTIC.DocTic.Service;
import com.DocTIC.DocTic.Model.HistorialContrasenaModel;

import java.util.List;

public interface IHistorialcontrasenaService {
    String insertarhistorialContrasena(HistorialContrasenaModel historialContrasenaData);
    
    HistorialContrasenaModel obtenerHistContrasena (int historialContrasenaId);

    List <HistorialContrasenaModel> listarHistorialContrasena();

    String editarHistContrasena(HistorialContrasenaModel historialContrasena);
    
    void eliminarHistContrasenaPorId(int historialContrasenaId);
}


