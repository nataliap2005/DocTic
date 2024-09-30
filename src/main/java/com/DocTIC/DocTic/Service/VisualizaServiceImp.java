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

/**
 * [VisualizaServiceImp]
 * 
 *Se define la clase `VisualizaServiceImp`, que implementa la interfaz `IVisualizaService` 
 *y se encarga de gestionar las operaciones relacionadas con las visualizaciones en la aplicación DocTIC, 
 *utilizando el repositorio `IVisualizaRepository` para interactuar con la base de datos. 
 *La clase incluye métodos para insertar una nueva visualización, 
 *buscar una visualización por su ID (lanzando una excepción si no se encuentra), listar todas las visualizaciones 
 *y eliminar una visualización por su ID, también manejando excepciones en caso de que no exista. 
 *Además, proporciona un método para obtener las visualizaciones realizadas por un usuario específico, 
 *retornando los resultados en un formato de lista de mapas que contiene detalles como el nombre del usuario, 
 *el nombre del documento, la fecha y la hora de la visualización. La clase está anotada con `@Service`, 
 *lo que indica que es un componente de servicio dentro del contexto de Spring.
 *
 * 27-09-2024
 */

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
 }
        