package br.com.aweb.sistema_vendas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_vendas.model.Produto;
import br.com.aweb.sistema_vendas.service.ProdutoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/novo")
    public ModelAndView create(){
        
        return new ModelAndView("produto/form", Map.of("produto", new Produto()));
    }

    @PostMapping("/novo")
    public String create(@Valid Produto produto, BindingResult result){
        if(result.hasErrors())
            return "produto/form";
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    //Listar produtos
    @GetMapping
    public ModelAndView listar() {
        return new ModelAndView("produto/list", Map.of("produtos", produtoService.listarTodos()));
        //List<Produto> produtos = produtoService.listarTodos();
       // return new ModelAndView("produto/list", Map.of("produtos", produtos));
    }
}
