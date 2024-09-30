package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.PublicaModel;
import com.DocTIC.DocTic.Repository.IPublicaRepository;

/**
 * [PublicServiceImp]
 * 
 *Se define una clase de servicio llamada `PublicServiceImp`, que implementa la interfaz `IPublicaService`
 *para gestionar operaciones relacionadas con las publicaciones en la aplicación DocTIC. 
 *Se utiliza la anotación `@Service` para indicar que es un componente de servicio dentro del contexto de Spring. 
 *La clase inyecta un repositorio (`IPublicaRepository`) mediante la anotación `@Autowired`, 
 *lo que le permite realizar operaciones de acceso a datos. 
 *Incluye métodos para insertar (`insertarPublica`), buscar (`buscarPublicaPorId`), listar (`listarPublicaciones`), 
 *editar (`editarPublica`) y eliminar (`eliminarPublicaPorId`) publicaciones, 
 *manejando excepciones específicas como `RecursoNoEncontradoException` para situaciones donde no se encuentra una publicación con el ID especificado.
 * 
 * 27-09-2024
 */

@Service

public class PublicServiceImp implements IPublicaService  {
    @Autowired IPublicaRepository publicaRepository;

    @Override
    public String insertarPublica(PublicaModel publica){
        publicaRepository.save(publica);
        return "La publicación se creó con éxito ID: "+ publica.getIdPublica();
    }

    @Override
    public PublicaModel buscarPublicaPorId(int idPublica){
        Optional<PublicaModel> publicacionEncontrada = publicaRepository.findById(idPublica);
        return publicacionEncontrada.orElseThrow(()-> new RecursoNoEncontradoException("No se encontró la publicación con ID "+idPublica+" por favor verificar el ID"));
    }

    @Override
    public List<PublicaModel> listarPublicaciones(){
        return publicaRepository.findAll();
    }

    @Override 
    public String editarPublica(PublicaModel publica){
        Optional<PublicaModel> publicacionEncontrada = publicaRepository.findById(publica.getIdPublica());
        if (publicacionEncontrada.isPresent()) {
            publicaRepository.save(publica);
            return "Se actualizó la publicación por el ID"+ publica.getIdPublica();
        } else {
            throw new RecursoNoEncontradoException("No se encontro la publicación con ID " + publica.getIdPublica() + " .Intente de nuevo.");
        }
    }
    @Override
    public String eliminarPublicaPorId(int idPublica){
        Optional<PublicaModel> publica = publicaRepository.findById(idPublica);
        if (publica.isPresent()) {

            publicaRepository.deleteById(idPublica);
            return "Éxito al eliminar la publicación con ID " + idPublica;

        } else {
            throw new RecursoNoEncontradoException("No se encontró la publicació con Id " + idPublica);
        }
    }

    @Override
    public List<PublicaModel> obtenerPublicacionesPorUsuario(int idUsuario){
        return publicaRepository.findPublicacionByUsuario(idUsuario);
    }
    
}
