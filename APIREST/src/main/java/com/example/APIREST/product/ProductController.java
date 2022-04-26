package com.example.APIREST.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @GetMapping("/product/{id}")
    public List<Product>getProducts(){
        return productService.getProducts();
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable Long id){
    Product productUpdate=productService.findById(id).get();

    productUpdate.setBrand(productUpdate.getBrand());
    productUpdate.setCategory(productUpdate.getCategory());
    productUpdate.setPrice(productUpdate.getPrice());
    productUpdate.setDescription(productUpdate.getDescription());
    productUpdate.setEan(productUpdate.getEan());
    productUpdate.setTitle(productUpdate.getTitle());
    productUpdate.setUnit(productUpdate.getUnit());

    }

    @DeleteMapping("/product/{id}")
    public void deleteMapping(@PathVariable Long id){
        productService.deleteById(id);
    }
}
