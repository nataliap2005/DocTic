package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.ContrasenaModel;

@Repository
public interface IContrasenaRepository extends JpaRepository <ContrasenaModel, Integer> {
}