package com.example.erp.finance;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;

    public Page<Invoice> listInvoices(int page, int size) { return invoiceRepository.findAll(PageRequest.of(page, size)); }
    public Invoice createInvoice(Invoice invoice) { return invoiceRepository.save(invoice); }
    public Payment createPayment(Payment payment) { return paymentRepository.save(payment); }
}
