package com.DocTIC.DocTic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.ContrasenaModel;
import com.DocTIC.DocTic.Repository.IContrasenaRepository;

/**
 * [ContrasenaServiceImp]
 * 
 * Esta clase ContrasenaServiceImp es una implementación del servicio de contraseñas que gestiona el historial de 
 * contraseñas de los usuarios en la aplicación DocTIC. Utiliza JdbcTemplate para ejecutar procedimientos almacenados 
 * y el repositorio IContrasenaRepository para interactuar con la base de datos. 
 * Ofrece métodos para actualizar contraseñas inactivas, insertar un nuevo historial de contraseñas, 
 * obtener un historial específico de contraseña, listar todo el historial, 
 * y generar una respuesta personalizada con el historial de contraseñas de un usuario determinado. 
 * Además, maneja excepciones cuando los recursos no se encuentran, asegurando un manejo adecuado de errores.
 * 
 * 25-09-2024
 */

@Service
public class ContrasenaServiceImp implements IContrasenaService {
    @Autowired IContrasenaRepository contrasenaRepository;
     @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void actualizarContrasenaInactiva(int idUsuario, int idHistorial) {
        String sql = "CALL actualizarContrasenaInactiva(?, ?)";
        jdbcTemplate.update(sql, idUsuario, idHistorial);
    }


    @Override
    public String insertarhistorialContrasena(ContrasenaModel historialContrasenaData){

        contrasenaRepository.save(historialContrasenaData);
        actualizarContrasenaInactiva(historialContrasenaData.getUsuario().getIdUsuario(), historialContrasenaData.getIdHistorial());

        return "Éxito al guardar el historial de contraseña, ID " + historialContrasenaData.getIdHistorial();
    };
    

    @Override 
    public ContrasenaModel obtenerHistContrasena (int historialContrasenaId){
        Optional <ContrasenaModel> historial =  contrasenaRepository.findById(historialContrasenaId);

        return historial.orElseThrow(()-> new RecursoNoEncontradoException("¡Error! El historial contraseña del id no fue encontrado o es erróneo."));
    };

    @Override
    public List<ContrasenaModel> listarHistorialContrasena() {
        return contrasenaRepository.findAll();
    
    }

    /* Aquí los datos salen los datos de la consulta */


    // @Override
    // public List<ContrasenaModel> obtenerHistorialContrasenasPorUsuario(int idUsuario) {
    //     return contrasenaRepository.findHistorialContrasenasByUsuario(idUsuario);
    // }

    /* Establecemos como queremos la salida de los datos creando un objeto */

    @Override
    public List<Map<String, Object>> getHistorialContrasenasByUsuario(int idUsuario) {
        List<Object[]> results = contrasenaRepository.findHistorialContrasenasByUsuario(idUsuario);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> data = new HashMap<>();
            data.put("idHistorial", row[0]);
            data.put("nombreUsuario", row[1]);
            data.put("contrasena", row[2]);
            data.put("fecha", row[3]);
            data.put("estado", row[4]);
            response.add(data);
        }
        return response;
    }
   
}



