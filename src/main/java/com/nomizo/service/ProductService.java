package com.nomizo.service;

import com.nomizo.db.ProductRepository;
import com.nomizo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

        /* POST */
    //  To save one product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // To save a list of products
    public List<Product> saveProducts(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

        /* GET */
    // To get a list of products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // To get a product by name
    public Product getProductByName(String name) {
        return productRepository.findbyName(name);
    }

    // To get product by Id
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

        /* DELETE */
    // To delete product by id
    public String deleteProductById(int id) {
        productRepository.deleteById(id);
        return "Product removed !! "+id;
    }

        /* PUT */
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }


}
