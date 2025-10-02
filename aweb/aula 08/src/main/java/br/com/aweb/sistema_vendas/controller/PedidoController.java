package br.com.aweb.sistema_vendas.controller;

import br.com.aweb.sistema_vendas.model.*;
import br.com.aweb.sistema_vendas.service.ClienteService;
import br.com.aweb.sistema_vendas.service.PedidoService;
import br.com.aweb.sistema_vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    // Listar pedidos
    @GetMapping
    public ModelAndView listar() {
        List<Pedido> pedidos = pedidoService.listarTodos();
        return new ModelAndView("pedido/list", "pedidos", pedidos);
    }

    // Formulário de novo pedido
    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("pedido/form");
        mv.addObject("pedido", new Pedido());
        mv.addObject("clientes", clienteService.listarTodos());
        mv.addObject("produtos", produtoService.listarTodos());
        return mv;
    }

    // Salvar pedido
    @PostMapping("/salvar")
    public String salvar(Pedido pedido, RedirectAttributes attributes) {
        pedidoService.salvar(pedido);
        attributes.addFlashAttribute("mensagem", "Pedido salvo com sucesso!");
        return "redirect:/pedidos";
    }

    // Excluir pedido
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        pedidoService.excluir(id);
        attributes.addFlashAttribute("mensagem", "Pedido excluído com sucesso!");
        return "redirect:/pedidos";
    }
}

