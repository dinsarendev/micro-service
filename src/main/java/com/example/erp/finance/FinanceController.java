package com.example.erp.finance;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/finance") @RequiredArgsConstructor
public class FinanceController {
    private final FinanceService service;
    @GetMapping("/invoices") public Page<Invoice> listInvoices(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){return service.listInvoices(page,size);}    
    @PostMapping("/invoices") public Invoice createInvoice(@Valid @RequestBody Invoice i){return service.createInvoice(i);} 
    @PostMapping("/payments") public Payment createPayment(@Valid @RequestBody Payment p){return service.createPayment(p);} 
}
