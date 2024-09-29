package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.DescargaModel;

@Repository

public interface IDescargaRepository extends JpaRepository<DescargaModel, Integer>{
    
}
