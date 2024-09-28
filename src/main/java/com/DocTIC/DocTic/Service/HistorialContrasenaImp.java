package com.DocTIC.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
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

    @Override
    public List<HistorialContrasenaModel> listarHistorialContrasena() {
        return historialcontrasenaRepository.findAll();
    
    }
    @Override
    public String editarHistContrasena(HistorialContrasenaModel hcontrasena){
        Optional<HistorialContrasenaModel> HistorialContrasenaEcontrado = historialcontrasenaRepository.findById(hcontrasena.getIdHistorial());

        if (HistorialContrasenaEcontrado.isPresent()){
            historialcontrasenaRepository.save(hcontrasena);
            return "El historial contraseña con ID "+ hcontrasena.getIdHistorial()+" fue editado con exito";
        } else{
            throw new RecursoNoEncontradoException("El historial de contraseña con ID " + hcontrasena.getIdHistorial() +" no se encuentra en la base de datos o es erróneo." );
        }
    }
    @Override
    public void eliminarHistContrasenaPorId(int historialContrasenaId) {
        historialcontrasenaRepository.deleteById(historialContrasenaId);
    }   
}



