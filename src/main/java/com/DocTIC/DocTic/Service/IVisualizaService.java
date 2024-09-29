package com.DocTIC.DocTic.Service;

import java.util.List;

import com.DocTIC.DocTic.Model.VisualizaModel;

public interface IVisualizaService {
    String insertarVisualiza(VisualizaModel visualiza);

    VisualizaModel buscarVisualizacionPorId(int idVisualiza);

    List<VisualizaModel> listarVisualizaciones();

    String eliminarVisualizacionPorId(int idVisualiza);
}