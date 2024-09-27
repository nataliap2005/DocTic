package com.DocTIC.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.HistorialContrasenaModel;
import com.DocTIC.DocTic.Repository.IHistorialcontrasenaRepository;

@Service
public class HistorialContrasenaImp implements IHistorialcontrasenaService {
    @Autowired IHistorialcontrasenaRepository historialcontrasenaRepository;


    @Override
    public String insertarhistorialContrasena(HistorialContrasenaModel historialContrasenaData){

        historialcontrasenaRepository.save(historialContrasenaData);

        return "Éxito al guardar el historial de contraseña, ID " + historialContrasenaData.getIdHistorial();
    };
    

    @Override 
    public HistorialContrasenaModel obtenerHistContrasena (int historialContrasenaId){
        Optional <HistorialContrasenaModel> historial =  historialcontrasenaRepository.findById(historialContrasenaId);

        return historial.orElseThrow(()-> new RecursoNoEncontradoException("¡Error! El historial contraseña del id no fue encontrado o es erróneo."));
    };

}
