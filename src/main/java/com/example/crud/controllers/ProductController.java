package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProductDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable UUID id) {
        try {
            Optional<Product> product = repository.findById(String.valueOf(id));
            if (product.isPresent()) {
                return ResponseEntity.ok().body(product);
            }
            return ResponseEntity.status(404).body("Product not found");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data) {
        Product newProduct = new Product(data);
        try {
            repository.save(newProduct);
            return ResponseEntity.status(201).body(newProduct);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO data, @PathVariable UUID id) {
        try {
            Optional<Product> product = repository.findById(String.valueOf(id));

            if (product.isPresent()) {
                product.get().setName(data.name());
                product.get().setPrice_in_cents(data.price_in_cents());
                repository.save(product.get());
                return ResponseEntity.status(200).body(product);
            }

            return ResponseEntity.status(404).body("Produto não encontrado");

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable UUID id) {
        try {
            Product product = repository.findById(String.valueOf(id)).orElse(null);

            if (product == null) {
                return ResponseEntity.status(404).body("Produto não encontrado!");
            }
            repository.delete(product);

            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
