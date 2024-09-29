package com.DocTIC.DocTic.Model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [CategoriaModel]
 * 
 * Esta clase representa un modelo de datos para gestionar las categorías en el sistema.
 * 
 * 28-09-2024
 */

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
    private Integer subIdCategoria;

    @ManyToOne
    @JoinColumn(name = "subIdCategoria", insertable = false, updatable = false)
    private CategoriaModel categoriaPadre;  
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = false)
    @Transient // Para que Jpa no mapee este campo. 
    private List<DocumentoModel> documentos;
}
