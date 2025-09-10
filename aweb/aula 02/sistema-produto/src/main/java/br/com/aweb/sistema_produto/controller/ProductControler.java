package br.com.aweb.sistema_produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aweb.sistema_produto.model.Product;
import br.com.aweb.sistema_produto.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductControler {
    @Autowired
    private ProductService productService;

    //listar produtos 
    public String list(Model model){
        model.addAttribute("products",productService.listAll());
        return "products/list";
    }
    //retorna a view do formulario cadastro/edição de produtos
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name", required = false) String name, Model model){
        if (name != null && name.isBlank()){
            List<Product> products = productService.findByName(name);
            model.addAttribute("products", products);
        }
        return "search";
    }
    
}
