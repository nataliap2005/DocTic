package com.DocTIC.DocTic.Service;
import java.util.List;

import com.DocTIC.DocTic.Model.CategoriaModel;

/**
 * [ICategoriaService]
 * 
 * Interfaz que define las operaciones relacionadas con la gestión de categorías
 * 
 * 26-09-2024
 */
public interface ICategoriaService {
   /**
     * [insertarCategoria]
     * 
     * Este método se encarga de crear una nueva categoría en el sistema.
     * 
     * 26-09-2024
     */

    String insertarCategoria(CategoriaModel categoria);

     /**
     * [buscarCategoriaPorId]
     * 
     * Este método se encarga de buscar y recuperar una categoría por su id.
     * 
     * 26-09-2024
     */
    CategoriaModel buscarCategoriaPorId(int idCategoria);

    /**
     * [obtenerCategorias]
     * 
     * Este método se encarga de recuperar todas las categorías de la base de datos.
     * 
     * 26-09-2024
     */
    List<CategoriaModel> obtenerCategorias();

    /**
     * [editarCategoria]
     * 
     * Este método se encarga de recuperar todas las categorías de la base de datos.
     * 
     * 26-09-2024
     */

     String editarCategoria(CategoriaModel categoria);


    /**
     * [eliminarCategoriaPorId]
     * 
     * Este método se encarga de eliminar una categoría de la base de datos.
     * 
     * 26-09-2024
     */
    String eliminarCategoriaPorId(int idCategoria);


}
