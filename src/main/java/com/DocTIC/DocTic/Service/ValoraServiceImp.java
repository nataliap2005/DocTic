package com.DocTIC.DocTic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.ConflictoDatosExcepcion;
import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ValoraModel;
import com.DocTIC.DocTic.Repository.IValoraRepository;


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

   
    
}
