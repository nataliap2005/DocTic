package com.DocTIC.DocTic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DocTIC.DocTic.Model.HistorialContrasenaModel;

@Repository
public interface IHistorialcontrasenaRepository extends JpaRepository <HistorialContrasenaModel, Integer> {
}