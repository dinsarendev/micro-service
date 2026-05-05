package com.example.erp.hr;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Page<Employee> list(int page, int size, String sort) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sort).ascending()));
    }

    public Employee create(Employee employee) { return repository.save(employee); }
}
