package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.DescargaModel;
import com.DocTIC.DocTic.Repository.IDescargaRepository;

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
}