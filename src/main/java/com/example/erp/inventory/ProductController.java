package com.example.erp.inventory;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/inventory/products") @RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @GetMapping
    public Page<Product> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size,@RequestParam(defaultValue="id") String sort){
        return service.list(page,size,sort);
    }
    @PostMapping public Product create(@Valid @RequestBody Product p){return service.create(p);} 
}
