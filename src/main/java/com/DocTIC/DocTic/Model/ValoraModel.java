package com.DocTIC.DocTic.Model;

import java.time.LocalDate;

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

/*
 * CREATE TABLE valora ( 
    idValora INT PRIMARY KEY AUTO_INCREMENT,
    valoracion INT NOT NULL, 
    fechaValoracion DATE NOT NULL, 
    idUsuario INT NOT NULL, 
    idDocumento INT NOT NULL, 
    CHECK (valoracion BETWEEN 1 AND 5), 
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE,
    FOREIGN KEY (idDocumento) REFERENCES documento(idDocumento) 
);
 */
@Entity
@Table(name = "valora")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ValoraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValora;
    
    @Column(name = "valoracion", nullable = false)
    private Integer valoracion;

    @Column(name = "fechaValoracion", nullable = false)
    private LocalDate fechaValoracion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name="idDocumento", nullable = false)
    private DocumentoModel documento;    
}
