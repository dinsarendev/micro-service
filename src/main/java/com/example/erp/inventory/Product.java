package com.example.erp.inventory;
import jakarta.persistence.*;import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String sku; private String name; private Integer stockQty; private Double price; }
