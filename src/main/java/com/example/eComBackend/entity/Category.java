package com.example.eComBackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category", schema = "ecommercev2")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public void addProduct(Product product){
        if(products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
