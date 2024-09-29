package com.DocTIC.DocTic.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="visualiza")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class VisualizaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVisualiza;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

}
