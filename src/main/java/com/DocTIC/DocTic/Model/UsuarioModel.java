package com.DocTIC.DocTic.Model;

import jakarta.persistence.Entity;
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
    private Integer idUsuario;
    private String nombre;
    private String nickname;
    private String email;
    private String ciudad;
    private String departamento;
    private String preguntaSecreta;
    private String respuestaSecreta;
}
