/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendas_m.service;

import com.tiendas_m.domain.Producto;
import java.util.List;

/**
 *
 * @author AMD
 */
public interface ProductoService  {
    //Se enuncia un método que recupera los registros de la tabla categoría dentro de un ArrayList,
    //pueden ser todos los registros o solo los activos
    public List<Producto> getProductos(boolean activos);
    
    //Se obtiene un registro de la tabla producto en un objeto producto si el idProducto existe sino pasa un null
    public Producto getProducto(Producto producto);
    
    //Se crea un nuevo registro en producto si el objeto Producto  NO tiene idProducto
    //se actualiza el registro en la tabla producto si el objeto producto tiene un idProducto
    public void save(Producto producto);
    
    //Se elimina el registro por idProducto
    public void delete(Producto producto);
    
    //Retorna una lista de productos que se encuentra en un rango de precios
    public List<Producto> consulta1(double precioInf, double precioSup);
    
    //Retorna una lista de productos que se encuentra en un rango de existencias
    public List<Producto> consulta2(int exisstenciasMin, int existenciasMax);
}
