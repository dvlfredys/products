package com.productos.service;

import com.productos.entity.Producto;
import com.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    public ProductoRepository productoRepository;
    @Override
    public List<Producto> listProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Producto addProduct(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductById(Integer idProduct) {
        return productoRepository.findById(idProduct).get();
    }

    @Override
    public Producto updateProduct(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productoRepository.deleteById(idProduct);
    }
}
