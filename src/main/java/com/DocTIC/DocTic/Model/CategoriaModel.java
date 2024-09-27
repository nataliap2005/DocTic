package com.DocTIC.DocTic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "nombreCategoria", nullable = false, unique = true)
    private String nombreCategoria;

    @Column(name = "subIdCategoria", nullable = true)
    private Integer subCategoria;

    @ManyToOne
    @JoinColumn(name = "subIdCategoria", insertable = false, updatable = false)
    @Transient
    private CategoriaModel categoriaPadre;

    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = true)
    private DocumentoModel documento;    
}
