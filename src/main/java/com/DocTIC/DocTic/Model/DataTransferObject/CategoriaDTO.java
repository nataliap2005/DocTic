package com.DocTIC.DocTic.Model.DataTransferObject;

import com.DocTIC.DocTic.Model.CategoriaModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaDTO {

    private Integer idCategoria;
    private String nombreCategoria;
    private Integer subIdCategoria;
    private Integer idDocumento;

    CategoriaDTO(CategoriaModel categoria){
        this.idCategoria = categoria.getIdCategoria();
        this.nombreCategoria = categoria.getNombreCategoria();
        this.subIdCategoria = categoria.getSubCategoria();
        this.idDocumento = categoria.getDocumento().getIdDocumento();
    };

}
