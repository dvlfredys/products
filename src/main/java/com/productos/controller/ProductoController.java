package com.productos.controller;

import com.productos.entity.Categoria;
import com.productos.entity.Producto;
import com.productos.service.ICatergoriaService;
import com.productos.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    public static Logger log = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    public IProductoService productoService;

    @Autowired
    public ICatergoriaService catergoriaService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listProducts());
        log.info(productoService.listProducts().toString());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String formularioAddProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", catergoriaService.listCategorias());
        return "formularioAddProducto";
    }

    @PostMapping("/productos")
    public String addProducto(@ModelAttribute("producto") Producto producto){
//        // Obtener el ID de la categoría seleccionada desde el objeto Producto
//        Integer idCategoriaSeleccionada = producto.getIdCategoria().getIdCategoria();
//        log.info(idCategoriaSeleccionada.toString());
//
//        // Obtener la categoría seleccionada utilizando el idCategoria
//        Categoria categoriaSeleccionada = catergoriaService.getCategoriaById(idCategoriaSeleccionada);
//
//        // Establecer la categoría seleccionada en el objeto Producto
//        producto.setIdCategoria(categoriaSeleccionada);
        productoService.addProduct(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/edit/{id}")
    public String formularioEditProducto(@PathVariable Integer id, Model model){
        model.addAttribute("producto", productoService.getProductById(id));
        model.addAttribute("categorias", catergoriaService.listCategorias());
        return "formularioEditProducto";
    }

    @PostMapping("/productos/{id}")
    public String updateProducto(@PathVariable Integer id, @ModelAttribute("producto") Producto producto){
        Producto productoExistente = productoService.getProductById(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        productoExistente.setIdCategoria(producto.getIdCategoria());
        productoService.updateProduct(productoExistente);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String deleteProducto(@PathVariable Integer id){
        productoService.deleteProduct(id);
        return "redirect:/productos";
    }
}
