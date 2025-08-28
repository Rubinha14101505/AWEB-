package br.com.aweb.sistema_produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_produto.model.Product;
import br.com.aweb.sistema_produto.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //buscar todos os produtos
    public List<Product> listAll(){
        return productRepository.findAll();
    }

    //buscar produto por id
    public Product findProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
            return optionalProduct.get();
        throw new RuntimeException("produto não encontrado");
    } 

    //inserir ou atualizar o produto
    public  Product creatProduct(Product product){
        return productRepository.save(product);
    }
    //deletar produtos
    public void deleteProduct(Long id){
        if(productRepository.existsById(id))
            throw new RuntimeException("produto não encontrado");
        productRepository.deleteById(id);
    }

    //buscar produto por nome
    public  List<Product> findByName(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
