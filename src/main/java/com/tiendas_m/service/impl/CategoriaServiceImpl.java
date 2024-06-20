package com.tiendas_m.service.impl;

import com.tiendas_m.dao.CategoriaDao;
import com.tiendas_m.domain.Categoria;
import com.tiendas_m.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {
            //lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }
}
