/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiendas_m.controller;

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
@RequestMapping("/producto")
public class ProductoController {
    
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
        
        return "/producto/listado";
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
        public String guardar(Producto producto, @RequestParam MultipartFile imagenFile){
            if (!imagenFile.isEmpty()){
                //Se sube al storage
                productoService.save(producto);
                String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "producto",producto.getIdProducto());
                producto.setRutaImagen(rutaImagen);
            }
            productoService.save(producto);
        return "redirect:/producto/listado";
        }
    
    @GetMapping("eliminar/{idProducto}")
    public String eliminar(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("modificar/{idProducto}")
    public String modificar(Producto producto, Model model){
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto );
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/producto/modifica";
    }
    
}
