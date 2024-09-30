package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DocTIC.DocTic.Model.UsuarioModel;
/**
 * Esta interfaz maneja la interacción
 * con la base de datos para la entidad Usuario, permitiendo la creación, consulta, 
 * actualización y eliminación de usuarios. 
 * 16-09-2024
 * */

public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Integer> {
    //consultas sql nativas
}
