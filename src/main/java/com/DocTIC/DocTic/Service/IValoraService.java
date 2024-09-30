package com.DocTIC.DocTic.Service;

import java.util.List;

import com.DocTIC.DocTic.Model.ValoraModel;

public interface IValoraService {

    String crearValoracion(ValoraModel valoracion);

    ValoraModel obtenerValoracionById(int valoracionId);

    List<ValoraModel> obtenerValoraciones();

    ValoraModel editarValoracion(ValoraModel valoracion);

    String eliminarValoracion(int valoracionId);
    
    List<ValoraModel> findValoracionByUsuario(int idUsuario);    
}
