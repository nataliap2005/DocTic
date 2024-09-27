package com.DocTIC.DocTic.Model;

import com.DocTIC.DocTic.Model.ENUM.EstadoContrasena;

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


@Entity
@Table(name= "historial_contraseña")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistorialContrasenaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorial")
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioModel usuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name= "fecha")
    private LocalDate fecha;

    @Column(name="estado")
    @Enumerated(EnumType.STRING)
    private EstadoContrasena estado;
}

