/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendas_m.service;

import com.tiendas_m.domain.Categoria;
import java.util.List;

/**
 *
 * @author AMD
 */
public interface CategoriaService  {
    //Se enuncia un método que recupera los registros de la tabla categoría dentro de un ArrayList,
    //pueden ser todos los registros o solo los activos
    public List<Categoria> getCategorias(boolean activos);
    
    //Se obtiene un registro de la tabla categoria en un objeto categoria si el idCategoria existe sino pasa un null
    public Categoria getCategoria(Categoria categoria);
    
    //Se crea un nuevo registro en categoria si el objeto Categoria  NO tiene idCategoria
    //se actualiza el registro en la tabla categoria si el objeto categoria tiene un idCategoria
    public void save(Categoria categoria);
    
    //Se elimina el registro por idCategoria
    public void delete(Categoria categoria);
}
