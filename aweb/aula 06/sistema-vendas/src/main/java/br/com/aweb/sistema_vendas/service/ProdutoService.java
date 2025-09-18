package br.com.aweb.sistema_vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.model.Produto;
import br.com.aweb.sistema_vendas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //CREATE
    @Transactional
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    //READ
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    
}


    
    
