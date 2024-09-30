package com.DocTIC.DocTic.Service;

import java.util.List;
import com.DocTIC.DocTic.Model.DescargaModel;

public interface IDescargaService {
    String insertarDescarga(DescargaModel descarga);

    DescargaModel buscarDescargaPorId(int idDescarga);

    List<DescargaModel> listarDescargas();

    String eliminarDescargaPorId(int idDescarga);

    List<DescargaModel> obtenerDescargasPorUsuario(int idUsuario);
}
