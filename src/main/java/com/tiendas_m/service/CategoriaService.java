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
    //SSe enuncia un método que recupera los registros de la tabla categoría dentro de un ArrayList,
    //pueden ser todos los registros o solo los activos
    public List<Categoria> getCategorias(boolean activos);
}
