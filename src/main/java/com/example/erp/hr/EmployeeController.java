package com.example.erp.hr;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/hr/employees") @RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping
    public Page<Employee> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size,@RequestParam(defaultValue="id") String sort){
        return service.list(page,size,sort);
    }
    @PostMapping public Employee create(@Valid @RequestBody Employee e){return service.create(e);} 
}
