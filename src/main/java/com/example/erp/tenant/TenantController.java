package com.example.erp.tenant;
import lombok.RequiredArgsConstructor;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/tenants") @RequiredArgsConstructor
public class TenantController { private final TenantProvisioningService service;
@PostMapping public Tenant create(@RequestBody Tenant req){ return service.register(req.getTenantId(), req.getName()); }
}
