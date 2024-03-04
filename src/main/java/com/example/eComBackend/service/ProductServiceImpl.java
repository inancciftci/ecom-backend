package com.example.eComBackend.service;

import com.example.eComBackend.entity.Category;
import com.example.eComBackend.entity.Product;
import com.example.eComBackend.entity.Store;
import com.example.eComBackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final StoreService storeService;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product createProduct(Product product, Long storeId, Long categoryId) {
        Store s = storeService.getStoreById(storeId);
        Category c = categoryService.findById(categoryId);
        product.setCategory(c);
        product.setStore(s);
        c.addProduct(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(() -> new RuntimeException("Product with given id not found"));
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
