package br.com.aweb.crud_no_db.dto;

public class ProductDTO {
   
    private Long id;
    private String name;
    private String price;
    public ProductDTO() {

        
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id2) {
        this.id = id2;
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
