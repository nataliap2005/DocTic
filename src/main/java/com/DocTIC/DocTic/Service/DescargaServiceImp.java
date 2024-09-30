package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.DescargaModel;
import com.DocTIC.DocTic.Repository.IDescargaRepository;

/**
 * [DescargaServiceImp]
 * 
 *Se define la implementación del servicio DescargaServiceImp, 
 *que maneja la lógica relacionada con las descargas de documentos en la aplicación DocTIC. 
 *Utiliza el repositorio IDescargaRepository para interactuar con la base de datos mediante las operaciones CRUD. 
 *El servicio permite insertar una nueva descarga, buscar una descarga por su ID, listar todas las descargas 
 *y eliminar una descarga por su ID. Si no se encuentra una descarga, lanza la excepción personalizada RecursoNoEncontradoException, 
 *proporcionando mensajes específicos para cada caso de error.
 * 
 * 25-09-2024
 */

@Service

public class DescargaServiceImp implements IDescargaService {
    @Autowired IDescargaRepository descargaRepository;

    @Override 
    public String insertarDescarga(DescargaModel descarga){
        descargaRepository.save(descarga);
        return "La descarga se creó con éxito ID: "+ descarga.getIdDescarga();
    }

    @Override 
    public DescargaModel buscarDescargaPorId(int idDescarga){
        Optional<DescargaModel> descargaEncontrada = descargaRepository.findById(idDescarga);
        return descargaEncontrada.orElseThrow(()-> new RecursoNoEncontradoException("No se encontró la descarga con ID "+idDescarga+" ,verificar el ID"));
    }

    @Override 
    public List<DescargaModel> listarDescargas(){
        return descargaRepository.findAll();
    }
  
    @Override 
    public String eliminarDescargaPorId(int idDescarga){
        Optional<DescargaModel> descarga = descargaRepository.findById(idDescarga);
        if (descarga.isPresent()) {

            descargaRepository.deleteById(idDescarga);
            return"Éxito al eliminar la descarga con ID " + idDescarga;
        } else {
            throw new RecursoNoEncontradoException("No se encontró la descarga con Id " + idDescarga);
        }
    }

    @Override
    public List<DescargaModel> obtenerDescargasPorUsuario(int idUsuario){
        return descargaRepository.findDescargasByUsuario(idUsuario);
    }

    @Override
    public String eliminarDescargasUsuario(int idUsuario) {
        
         List<Integer> ids = new ArrayList<>();

        for (DescargaModel descarga : descargaRepository.findDescargasByUsuario(idUsuario)) {
            ids.add(descarga.getIdDescarga());
        }

        descargaRepository.deleteAllById(ids);

        return "Se eliminó el historial de descargas del usuario con ID " + idUsuario;
    }
}