package com.cft.apizza.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orders order;

    @Column(nullable = false)
    private Integer quantity;
}
