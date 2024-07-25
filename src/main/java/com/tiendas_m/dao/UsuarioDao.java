/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendas_m.dao;

import com.tiendas_m.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AMD
 */
public interface UsuarioDao extends 
        JpaRepository<Usuario,Long>{
    
    public Usuario findByUsername(String username);
    
}
