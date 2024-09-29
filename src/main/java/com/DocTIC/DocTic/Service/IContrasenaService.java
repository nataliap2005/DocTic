package com.DocTIC.DocTic.Service;
import com.DocTIC.DocTic.Model.ContrasenaModel;

import java.util.List;

public interface IContrasenaService {
    String insertarhistorialContrasena(ContrasenaModel historialContrasenaData);
    
    ContrasenaModel obtenerHistContrasena (int historialContrasenaId);

    List <ContrasenaModel> listarHistorialContrasena();
    
}


