package com.cft.apizza.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String mail;

    @Column(length = 20, nullable = false)
    private String cellphone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Orders> orders;
}
