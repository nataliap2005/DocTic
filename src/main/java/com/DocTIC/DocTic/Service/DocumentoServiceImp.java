package com.DocTIC.DocTic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.DocumentoModel;
import com.DocTIC.DocTic.Repository.IDocumentoRepository;

@Service
public class DocumentoServiceImp implements IDocumentoService {

    @Autowired
    private IDocumentoRepository documentoRepository;

    @Override
    public String crearDocumento(DocumentoModel documento) {
        documentoRepository.save(documento);
        return "El documento '" + documento.getNombre() + "' ha sido creado con éxito.";
    }

    @Override
    public List<DocumentoModel> listarDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public DocumentoModel buscarDocumentoPorId(int documentoId) {
        Optional<DocumentoModel> documento = documentoRepository.findById(documentoId);
        return documento.orElseThrow(() -> 
            new RecursoNoEncontradoException("El documento con el ID " + documentoId + " no existe.")
        );
    }

    @Override
    public DocumentoModel guardarDocumento(DocumentoModel documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public void eliminarDocumento(int documentoId) {
        Optional<DocumentoModel> documento = documentoRepository.findById(documentoId);
        if (documento.isPresent()) {
            documentoRepository.deleteById(documentoId);
        } else {
            throw new RecursoNoEncontradoException("El documento con el ID " + documentoId + " no existe.");
        }
    }

    @Override
    public DocumentoModel editarDocumento(int documentoId, DocumentoModel documentoNuevo) {
        Optional<DocumentoModel> documentoEncontrado = documentoRepository.findById(documentoId);
    
        if (documentoEncontrado.isPresent()) {
            DocumentoModel documento = documentoEncontrado.get();
            documento.setNombre(documentoNuevo.getNombre());
            documento.setDescripcion(documentoNuevo.getDescripcion());
            documento.setEstado(documentoNuevo.getEstado());
            documento.setUrl(documentoNuevo.getUrl());
            documento.setFechaPub(documentoNuevo.getFechaPub());
            documento.setCategoria(documentoNuevo.getCategoria());
            return documentoRepository.save(documento); // Devolvemos el documento actualizado
        } else {
            throw new RecursoNoEncontradoException("Documento no encontrado con ID: " + documentoId);
        }
    }
    
    
    }

