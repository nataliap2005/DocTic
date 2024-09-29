package com.DocTIC.DocTic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.DocTIC.DocTic.Model.ENUM.Rol;

@Entity
@Table(name = "publica")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PublicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPublica")
    private Integer idPublica;

    @Column(name = "fechaPub")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private DocumentoModel documento;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
