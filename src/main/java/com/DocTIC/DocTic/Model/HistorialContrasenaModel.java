package com.DocTIC.DocTic.Model;

import java.sql.Date;

import com.DocTIC.DocTic.Model.ENUM.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "historial_contraseña")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistorialContrasenaModel {
    @Id
    private Integer idContraseña;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioModel usuarioModel;
    private String contraseña;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name="estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;
}

