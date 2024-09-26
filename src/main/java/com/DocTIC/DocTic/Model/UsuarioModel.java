package com.DocTIC.DocTic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
