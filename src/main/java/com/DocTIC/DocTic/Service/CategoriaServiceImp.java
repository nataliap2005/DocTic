package com.DocTIC.DocTic.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocTIC.DocTic.Exception.RecursoNoEncontradoException;
import com.DocTIC.DocTic.Model.CategoriaModel;
import com.DocTIC.DocTic.Repository.ICategoriaRepository;

@Service
public class CategoriaServiceImp implements ICategoriaService{
    @Autowired ICategoriaRepository categoriaRepository;

    @Override 
    public String insertarCategoria(CategoriaModel categoria){
        categoriaRepository.save(categoria);
        return "La categoría se creó con éxito ID: " + categoria.getIdCategoria();
    }

    @Override
    public CategoriaModel buscarCategoriaPorId(int categoriaId){

        Optional<CategoriaModel> categoriaEncontrada = categoriaRepository.findById(categoriaId);

        return categoriaEncontrada.orElseThrow(()-> new RecursoNoEncontradoException("¡Error! La categoría con ID "+categoriaId+" no existe en la base de datos o es incorrecto"));
    }
    
    @Override
    public List<CategoriaModel> obtenerCategorias(){
        return categoriaRepository.findAll();
    }

    @Override
    public String editarCategoria(CategoriaModel categoria){
        
        Optional<CategoriaModel> categoriaEncontrada = categoriaRepository.findById(categoria.getIdCategoria());

        if (categoriaEncontrada.isPresent()) {
            categoriaRepository.save(categoria);
            return "Éxito al actualizar la categoría con el ID "+ categoria.getIdCategoria();
        } else {
           throw new RecursoNoEncontradoException("¡Error! La categoría con ID " + categoria.getIdCategoria() + " no existe en la base de datos o es incorrecto." );
        }

    }
        

    @Override
    public String eliminarCategoriaPorId(int categoriaId){

        Optional<CategoriaModel> categoria = categoriaRepository.findById(categoriaId);

        if (categoria.isPresent()) {
            
            categoriaRepository.deleteById(categoriaId);
            return "Éxito al eliminar la categoría con ID " + categoriaId;
           
        } else {
            throw new RecursoNoEncontradoException("¡Error! No existe una categoria con el ID " + categoriaId); 
            
        }

        
    }
}
