package com.productos.service;

import com.productos.entity.Categoria;
import com.productos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements ICatergoriaService{

    @Autowired //hoy no hubo problemas porque coloqué la dependencia correcta --> JPA
    public CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).get();
    }

    @Override
    public Categoria addCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void removeCategoria(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
