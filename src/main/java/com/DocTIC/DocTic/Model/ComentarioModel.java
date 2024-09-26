package com.DocTIC.DocTic.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [ComentarioModel]
 * 
 * Esta clase representa un modelo de datos para gestionar los comentarios en el sistema.
 * 
 * 25-09-2024
 */

@Entity
@Table(name="comentario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioModel {
    @Id
    private Integer idComentario;

    @Column(name = "subIdComentario", unique = true, nullable = false)
    private Integer subIdComentario;

    @Column(name = "textComentario", nullable = false)
    private String textComentario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuarioId;
    
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private DocumentoModel documentoId;

    @ManyToOne
    @JoinColumn(name = "subIdComentario", insertable = false, updatable = false)
    private ComentarioModel comentarioPadre;
}
