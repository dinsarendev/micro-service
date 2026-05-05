package com.example.erp.finance;
import jakarta.persistence.*;import lombok.*;import java.time.LocalDate;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Payment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private Long invoiceId; private Double amount; private LocalDate paidOn; }
