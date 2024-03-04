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
@Table(name = "store", schema = "ecommercev2")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "bank_account")
    private String bankAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)

    private List<Product> products;

    public void addProduct(Product product){
        if(products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
