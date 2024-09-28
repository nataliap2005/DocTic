package com.DocTIC.DocTic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.CategoriaModel;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    /**
     * [findBySubIdCategoria]
     * 
     * Este método se encarga de encontrar todos las categorias hijas por su subIdCategoria.
     * 
     * 28-09-2024
     */
    List<CategoriaModel> findBySubIdCategoria(int subIdCategoria);
}
