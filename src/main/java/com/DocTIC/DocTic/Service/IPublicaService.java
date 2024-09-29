package com.DocTIC.DocTic.Service;

import java.util.List;

import com.DocTIC.DocTic.Model.PublicaModel;

public interface IPublicaService {
    String insertarPublica(PublicaModel publica);

    PublicaModel buscarPublicaPorId(int idPublica);

    List<PublicaModel> listarPublicaciones();

    String editarPublica(PublicaModel publica);

    String eliminarPublicaPorId(int idPublica);
}
