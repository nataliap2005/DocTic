package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.VisualizaModel;

@Repository
public interface IVisualizaRepository extends JpaRepository <VisualizaModel, Integer> {
    
}
