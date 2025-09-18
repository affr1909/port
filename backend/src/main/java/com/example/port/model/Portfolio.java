package com.example.port.model;

import jakarta.persistence.*;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String stockName;
    private Integer quantity;
    private Double price;
    private String purchaseDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters/setters
}
