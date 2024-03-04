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
@Table(name = "role", schema = "ecommercev2")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    public void addUser(User user){
        if(users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

    public List<String> getUserEmails(List<User> users){
        List<String> userEmails = new ArrayList<>();
        if (users != null) {
            for(User user: users){
                userEmails.add(user.getEmail());
            }
        }
        return userEmails;
    }
}
