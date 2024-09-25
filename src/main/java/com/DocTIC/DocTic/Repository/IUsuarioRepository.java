package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DocTIC.DocTic.Model.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Integer> {
    //consultas sql nativas
}
