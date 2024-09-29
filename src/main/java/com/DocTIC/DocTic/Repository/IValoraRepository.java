package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocTIC.DocTic.Model.ValoraModel;

@Repository
public interface IValoraRepository extends JpaRepository<ValoraModel, Integer>{
    
}
