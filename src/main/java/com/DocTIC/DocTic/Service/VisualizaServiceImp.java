package com.DocTIC.DocTic.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.VisualizaModel;
import com.DocTIC.DocTic.Repository.IVisualizaRepository;

@Service

public class VisualizaServiceImp implements IVisualizaService {
    @Autowired IVisualizaRepository visualizaRepository;

    @Override
    public String insertarVisualiza(VisualizaModel visualiza){
        visualizaRepository.save(visualiza);
        return "Se ha creado visualización con ID"+visualiza.getIdVisualiza();
    }

    @Override
    public VisualizaModel buscarVisualizacionPorId(int idVisualiza){
        Optional <VisualizaModel> VisualizacionEncontrada = visualizaRepository.findById(idVisualiza);
        return VisualizacionEncontrada.orElseThrow(()->new RecursoNoEncontradoException("No se encontró la visualización con ID "+idVisualiza+"Por favor verifica que el ID que ingresaste es correcto."));
    }

    @Override
    public List<VisualizaModel> listarVisualizaciones(){
        return visualizaRepository.findAll();
    }


    @Override
public String eliminarVisualizacionPorId(int idVisualiza) {
    Optional<VisualizaModel> visualizacionEliminada = visualizaRepository.findById(idVisualiza);

    if (visualizacionEliminada.isPresent()) {
        visualizaRepository.deleteById(idVisualiza);
        return "La visualización con ID " + idVisualiza + " fue eliminada con éxito.";
    } else {
        throw new RecursoNoEncontradoException("¡Error! No se encontró una visualización con ID " + idVisualiza + ".");
    }
}

// @Override
//     public List<VisualizaModel> obtenerVisualizacionesPorUsuario(int idUsuario) {
//         return visualizaRepository.findVisualizacionesByUsuario(idUsuario);
//     }


 @Override
    public List<Map<String, Object>> getVisualizacionesByUsuario(int idUsuario) {
        List<Object[]> results = visualizaRepository.findVisualizacionesByUsuario(idUsuario);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> data = new HashMap<>();
            data.put("nombreUsuario", row[0]);
            data.put("nombreDocumento", row[1]);
            data.put("fecha", row[2]);
            data.put("hora", row[3]);
            response.add(data);
        }

        return response;
    }

    @Override
    public String eliminarVisualizacionByUsuario(int idUsuario) {
        List<Integer> ids = new ArrayList<>();

        for (VisualizaModel valoracion : visualizaRepository.findAllVisualizacionesByUsuario(idUsuario)) {
            ids.add(valoracion.getIdVisualiza());
        }

        visualizaRepository.deleteAllById(ids);

        return "Se eliminó el historial de visualizaciones del usuario con ID "+ idUsuario;
    }

 }
        