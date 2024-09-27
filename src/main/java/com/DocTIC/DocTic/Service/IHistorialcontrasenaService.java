package com.DocTIC.DocTic.Service;

import com.DocTIC.DocTic.Model.HistorialContrasenaModel;

public interface IHistorialcontrasenaService {
    String insertarhistorialContrasena(HistorialContrasenaModel historialContrasenaData);
    
    HistorialContrasenaModel obtenerHistContrasena (int historialContrasenaId);

}
