package com.cft.apizza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDate date;

    // Pendiente la relación
    //private Customer customer;

    @Column(length = 200)
    private String details;

    @Column(nullable = false)
    private Integer total;
}
