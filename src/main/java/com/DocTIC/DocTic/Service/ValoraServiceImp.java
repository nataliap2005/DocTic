package com.DocTIC.DocTic.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.ConflictoDatosExcepcion;
import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ValoraModel;
import com.DocTIC.DocTic.Repository.IValoraRepository;

/**
 * [ValoraServiceImp]
 * 
 *Se define el servicio `ValoraServiceImp`, que implementa la interfaz `IValoraService` para gestionar las valoraciones en la aplicación DocTIC. 
 *Se utiliza la anotación `@Service` para indicar que es un componente de servicio, y se inyecta automáticamente una instancia de `IValoraRepository` 
 *para interactuar con la base de datos. El servicio ofrece métodos para crear, obtener, editar y eliminar valoraciones. 
 *Al intentar crear o editar una valoración, se manejan excepciones para capturar conflictos de datos mediante `JpaSystemException`, 
 *lanzando excepciones personalizadas como `ConflictoDatosExcepcion` o `RecursoNoEncontradoException` 
 *cuando se producen errores o se intenta acceder a valoraciones que no existen. 
 *Además, el servicio permite la recuperación de todas las valoraciones existentes.
 *
 * 27-09-2024
 */


@Service
public class ValoraServiceImp implements IValoraService{

    @Autowired IValoraRepository valoraRepository;

    String errorResourceMessage(int idValoracion){
        return "¡Error! la valoración con ID " + idValoracion + " no existe en la base de datos o es incorecta.";
    }

    @Override
    public String crearValoracion(ValoraModel valoracion) {
        try {
            valoraRepository.save(valoracion);
            return "¡Éxito al guardar la valoración. ID de valoracion: "+valoracion.getIdValora();
        } catch (Exception e) {
            if (e.getClass() == JpaSystemException.class) {
                throw new ConflictoDatosExcepcion("¡Error! Conflicto de datos: "+ e.getMessage());
            }else{
                throw new RuntimeException("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        } 
    }

    @Override
    public ValoraModel obtenerValoracionById(int valoracionId) {
        return valoraRepository.findById(valoracionId).orElseThrow(()-> new RecursoNoEncontradoException(errorResourceMessage(valoracionId)));
    }

    @Override
    public List<ValoraModel> obtenerValoraciones() {
        return valoraRepository.findAll();
    }


    @Override
    public ValoraModel editarValoracion(ValoraModel valoracion) {
        valoraRepository.findById(valoracion.getIdValora()).orElseThrow(()-> new RecursoNoEncontradoException(errorResourceMessage(valoracion.getIdValora())));

        try {
            return valoraRepository.save(valoracion);
        } catch (Exception e) {
            if (e.getClass() == JpaSystemException.class) {
                throw new ConflictoDatosExcepcion("¡Error! Conflicto de datos: " + e.getMessage());
            }else{
                throw new RuntimeException("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        } 
    }

    @Override
    public String eliminarValoracion(int valoracionId) {
       valoraRepository.findById(valoracionId).orElseThrow(()-> new RecursoNoEncontradoException(errorResourceMessage(valoracionId)
       ));
       valoraRepository.deleteById(valoracionId);
       return "Exito al eliminar la valoración con ID "+  valoracionId;
    }

    @Override
    public List<ValoraModel> findValoracionByUsuario(int idUsuario){
        return valoraRepository.findValoracionByUsuario(idUsuario);
    }
}
