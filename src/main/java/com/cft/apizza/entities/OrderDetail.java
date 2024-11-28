package com.cft.apizza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private Integer id;

    // Pendiente la relación
    //private Pizza pizza;

    // Pendiente la relación
    //private Order order;

    @Column(nullable = false)
    private Integer quantity;
}
