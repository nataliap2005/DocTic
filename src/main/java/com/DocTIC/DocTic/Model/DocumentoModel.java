package com.DocTIC.DocTic.Model;

import com.DocTIC.DocTic.Model.ENUM.EstadoDocumento;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "documento")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocumento")
    private Integer idDocumento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaPub")
    private LocalDate fechaPub;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoDocumento estado;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = true)
    private CategoriaModel categoria;
    
    @OneToMany(mappedBy = "idComentario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioModel> comentarios;
    
    @OneToMany(mappedBy = "idVisualiza", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisualizaModel> visualizaciones;

    @OneToMany(mappedBy = "idValora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValoraModel> valoraciones;

    @OneToMany(mappedBy = "idPublica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicaModel> publicaciones;

    @OneToMany(mappedBy = "idDescarga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DescargaModel> descargas;
}
