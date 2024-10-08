/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiendas_m.controller;

import com.tiendas_m.domain.Categoria;
import com.tiendas_m.domain.Producto;
import com.tiendas_m.service.CategoriaService;
import com.tiendas_m.service.ProductoService;
import com.tiendas_m.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AMD
 */
@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }
    
    @GetMapping("listado/{idCategoria}")
    public String listado(Categoria categoria, Model model){
        var productos = categoriaService.getCategoria(categoria).getProductos();
        model.addAttribute("productos", productos);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        return "/pruebas/listado2";
    }
    
    @PostMapping("/consulta1")
    public String consulta1(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        
        var productos = productoService.consulta1(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        
        return "/pruebas/listado2";
    }

    @PostMapping("/consulta2")
    public String consulta2(
            @RequestParam(value = "existenciasMin") int existenciasMin,
            @RequestParam(value = "existenciasMax") int existenciasMax,
            Model model) {
        
        var productos = productoService.consulta2(existenciasMin, existenciasMax);
        model.addAttribute("productos", productos);
        model.addAttribute("existenciasMin", existenciasMin);
        model.addAttribute("existenciasMax", existenciasMax);
        
        return "/pruebas/listado2";
    }
}
