package com.example.erp.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Page<Product> list(int page, int size, String sort) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sort)));
    }

    public Product create(Product product) { return repository.save(product); }
}
