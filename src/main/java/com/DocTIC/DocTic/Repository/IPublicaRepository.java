package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.PublicaModel;

@Repository

public interface IPublicaRepository extends JpaRepository<PublicaModel, Integer> {
    
}
