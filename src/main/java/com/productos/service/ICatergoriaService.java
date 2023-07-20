package com.productos.service;

import com.productos.entity.Categoria;

import java.util.List;

public interface ICatergoriaService {
    //Listar categorias
    public List<Categoria> listCategorias();

    public Categoria getCategoriaById(Integer idCategoria);

    public Categoria addCategoria(Categoria categoria);

    public Categoria updateCategoria(Categoria categoria);
    public void removeCategoria(Integer idCategoria);
}
