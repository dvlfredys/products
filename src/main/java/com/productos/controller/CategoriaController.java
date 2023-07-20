package com.productos.controller;

import com.productos.entity.Categoria;
import com.productos.service.CategoriaServiceImp;
import com.productos.service.ICatergoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {
    @Autowired
    public ICatergoriaService iCatergoriaService;

    public static Logger log = LoggerFactory.getLogger(CategoriaController.class);

    @GetMapping("/categoria")
    public String listCategoria(Model model){
        model.addAttribute("categorias", iCatergoriaService.listCategorias());
        log.info(iCatergoriaService.listCategorias().toString());
        return "categorias";
    }
    //Nueva categoria
    @GetMapping("/categoria/nuevo")
    public String addCategorias(Model model) {
        //Crear un Objeto
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        return "crearCategoria";
    }

    @PostMapping("/categoria")
    public String addCategoriaMethod(@ModelAttribute("categoria") Categoria categoria) {
        iCatergoriaService.addCategoria(categoria);
        return "redirect:/categoria";
    }

    //Editar estudiante
    @GetMapping("/categoria/editar/{id}")
    public String updateCategorias(@PathVariable Integer id, Model model) {
        model.addAttribute("categoria", iCatergoriaService.getCategoriaById(id));
        return "editarCategoria";
    }

    @PostMapping("/categoria/{id}")
    public String updateCategoriaMethod(@PathVariable Integer id, @ModelAttribute("categoria") Categoria categoria) {
        Categoria categoriaExistente = iCatergoriaService.getCategoriaById(id);
        categoriaExistente.setNombre(categoria.getNombre());
        iCatergoriaService.updateCategoria(categoriaExistente);
        return "redirect:/categoria";
    }

    @GetMapping("categoria/{id}")
    public String deleteCategoria(@PathVariable Integer id){
        iCatergoriaService.removeCategoria(id);
        return "redirect:/categoria";
    }




}
