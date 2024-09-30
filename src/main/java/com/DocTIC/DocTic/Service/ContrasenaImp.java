package com.DocTIC.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ContrasenaModel;
import com.DocTIC.DocTic.Repository.IContrasenaRepository;

@Service
public class ContrasenaImp implements IContrasenaService {
    @Autowired IContrasenaRepository historialcontrasenaRepository;

     @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void actualizarContrasenaInactiva(int idUsuario, int idHistorial) {
        String sql = "CALL actualizarContrasenaInactiva(?, ?)";
        jdbcTemplate.update(sql, idUsuario, idHistorial);
    }



    @Override
    public String insertarhistorialContrasena(ContrasenaModel historialContrasenaData){

        historialcontrasenaRepository.save(historialContrasenaData);
        actualizarContrasenaInactiva(historialContrasenaData.getUsuario().getIdUsuario(), historialContrasenaData.getIdHistorial());

        return "Éxito al guardar el historial de contraseña, ID " + historialContrasenaData.getIdHistorial();
    };
    

    @Override 
    public ContrasenaModel obtenerHistContrasena (int historialContrasenaId){
        Optional <ContrasenaModel> historial =  historialcontrasenaRepository.findById(historialContrasenaId);

        return historial.orElseThrow(()-> new RecursoNoEncontradoException("¡Error! El historial contraseña del id no fue encontrado o es erróneo."));
    };

    @Override
    public List<ContrasenaModel> listarHistorialContrasena() {
        return historialcontrasenaRepository.findAll();
    
    }
   
}



