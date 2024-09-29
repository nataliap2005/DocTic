package com.DocTIC.DocTic.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "numDocumento")
    private Integer numDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombreUsuario")
    private String nickname;

    @Column(name = "correoE")
    private String email;

    @Column(name = "ciudadOrigen")
    private String ciudad;

    @Column(name = "depOrigen")
    private String departamento;

    @Column(name = "pSecreta")
    private String preguntaSecreta;

    @Column(name = "rSecreta")
    private String respuestaSecreta;

    @OneToMany(mappedBy = "idValora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValoraModel> valoraciones;

    @OneToMany(mappedBy = "idComentario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioModel> comentarios;

    @OneToMany(mappedBy = "idPublica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicaModel> publicaciones;

    @OneToMany(mappedBy = "idDescarga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DescargaModel> descargas;

    @OneToMany(mappedBy = "idHistorial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContrasenaModel> contrasenas;

    @OneToMany(mappedBy = "idVisualiza", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisualizaModel> visualizaciones;
}
