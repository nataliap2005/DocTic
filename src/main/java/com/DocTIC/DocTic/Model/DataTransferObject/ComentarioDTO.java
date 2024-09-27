package com.DocTIC.DocTic.Model.DataTransferObject;

import java.time.LocalDate;

import com.DocTIC.DocTic.Model.ComentarioModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComentarioDTO {
    private Integer idComentario;
    private Integer subIdComentario;
    private String textComentario;
    private LocalDate fecha;
    private Integer usuarioId;
    private Integer documentoId;

    public ComentarioDTO(ComentarioModel comentario) {
        this.idComentario = comentario.getIdComentario();
        this.subIdComentario = comentario.getSubIdComentario();
        this.textComentario = comentario.getTextComentario();
        this.fecha = comentario.getFecha();
        this.usuarioId = comentario.getIdUsuario().getIdUsuario();
        this.documentoId = comentario.getIdDocumento().getIdDocumento();  
    }
}