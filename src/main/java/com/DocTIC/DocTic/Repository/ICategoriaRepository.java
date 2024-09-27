package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.CategoriaModel;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    
}
