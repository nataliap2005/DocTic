package com.DocTIC.DocTic.Service;
import java.util.List;
import com.DocTIC.DocTic.Model.DocumentoModel;


public interface IDocumentoService {
    String crearDocumento(DocumentoModel documento);
    List<DocumentoModel> listarDocumentos();
    DocumentoModel buscarDocumentoPorId(int documentoId);
    // DocumentoModel buscarDocumentoPorNombre(DocumentoModel documento);
    DocumentoModel guardarDocumento(DocumentoModel documento);
    DocumentoModel editarDocumento(int id, DocumentoModel documento);
    void eliminarDocumento(int documentoId);
}
