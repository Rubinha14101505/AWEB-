package br.com.aweb.crud_bo_db.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private String price;
    public ProductDTO() {

        
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
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
}
