package com.DocTIC.DocTic.Service;

import java.util.List;
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
    public String editarVisualizacion(VisualizaModel visualiza){
        Optional<VisualizaModel> visualizacionEditada = visualizaRepository.findById(visualiza.getIdVisualiza());

        if (visualizacionEditada.isPresent()) {
            visualizaRepository.save(visualiza);
            return "La visualización con ID " + visualiza.getIdVisualiza() + " fue actualizada con éxito.";
        } else {
            throw new RecursoNoEncontradoException("¡Error! No se encontró una visualización con el ID " + visualiza.getIdVisualiza() + ". Verifique el ID que está ingresando.");
        }
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
}
        