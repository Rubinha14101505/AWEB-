package br.com.aweb.sistema_produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é Obrigatorio")
    private String name;
    @Positive(message = "Preço deve ser o positivo")
    private Double prince;
    private String description;


    // Construtores

    public Product() {
    }


    public Product(Long id,  String name, Double prince, String description) {
        this.id = id;
        this.name = name;
        this.prince = prince;   
        this.description = description;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Double getPrince() {
        return prince;
    }


    public void setPrince(Double prince) {
        this.prince = prince;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
}
