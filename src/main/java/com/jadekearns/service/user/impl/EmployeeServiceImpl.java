package com.jadekearns.service.user.impl;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.repository.user.EmployeeRepository;
import com.jadekearns.repository.user.impl.EmployeeRepositoryImpl;
import com.jadekearns.service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService service = null;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(){
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeService getEmployeeService(){
        if (service == null) service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        Set<Employee> employee = this.employeeRepository.getAll();
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public Employee delete(String s) {
        return this.employeeRepository.delete(s);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }
}
