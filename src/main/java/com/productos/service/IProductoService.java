package com.productos.service;

import com.productos.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> listProducts();
    public Producto addProduct(Producto producto);
    public Producto getProductById(Integer idProduct);
    public Producto updateProduct(Producto producto);
    public void deleteProduct(Integer idProduct);
}
