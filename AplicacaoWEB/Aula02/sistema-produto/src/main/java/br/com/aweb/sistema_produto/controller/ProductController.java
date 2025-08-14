package br.com.aweb.sistema_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistema_produto.model.Product;
import br.com.aweb.sistema_produto.service.ProductService;
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    //Listar Produtos
    public String list(Model model){
        model.addAttribute("products", productService, listAll());
        return "products/list";
    }

    //Retorna a view do formulario de cadastro/edição do produto
    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("product", new Product());
        return "prodects/form";
    }
}
