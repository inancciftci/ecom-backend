package com.example.eComBackend.controller;

import com.example.eComBackend.dto.ProductResponse;
import com.example.eComBackend.entity.Category;
import com.example.eComBackend.entity.Product;
import com.example.eComBackend.entity.Store;
import com.example.eComBackend.service.CategoryService;
import com.example.eComBackend.service.ProductService;
import com.example.eComBackend.service.StoreService;
import com.example.eComBackend.util.EntityToResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final StoreService storeService;

    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable Long productId){
        Product p = productService.findById(productId);
        return EntityToResponse.prodToRes(p);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> getAll(@PathVariable Long categoryId){
        List<Product> products = productService.findAll();
        List<ProductResponse> res = new ArrayList<>();
        for(Product product : products) {
            if(product.getCategory().getId() == categoryId) {
                res.add(EntityToResponse.prodToRes(product));
            }
        }
        return res;
    }

    @GetMapping
    public List<ProductResponse> getAll(){
        List<Product> products = productService.findAll();
        List<ProductResponse> res = new ArrayList<>();
        for(Product product : products) {
            res.add(EntityToResponse.prodToRes(product));
        }
        return res;
    }

    @PostMapping("/{storeId}/{categoryId}")
    public ProductResponse createProduct(@RequestBody Product product, @PathVariable Long storeId, @PathVariable Long categoryId){
        Product p = productService.createProduct(product, storeId, categoryId);
        productService.save(p);
        return EntityToResponse.prodToRes(p);
    }

}
