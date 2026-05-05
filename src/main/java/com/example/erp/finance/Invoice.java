package com.example.erp.finance;
import jakarta.persistence.*;import lombok.*;import java.time.LocalDate;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Invoice { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String number; private Double totalAmount; private LocalDate issuedOn; private String status; }
