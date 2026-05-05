package com.example.erp.tenant;
import jakarta.persistence.*;import lombok.*;
@Entity @Table(schema="public",name="tenants") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tenant { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(unique=true,nullable=false) private String tenantId; @Column(nullable=false) private String name; }
