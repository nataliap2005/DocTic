package com.DocTIC.DocTic.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DocTIC.DocTic.Model.DocumentoModel;



public interface IDocumentoRepository extends JpaRepository<DocumentoModel, Integer> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario.
}
  

