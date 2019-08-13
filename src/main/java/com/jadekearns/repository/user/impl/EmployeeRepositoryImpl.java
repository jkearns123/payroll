package com.jadekearns.repository.user.impl;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.repository.user.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    //singleton
    private static  EmployeeRepository employeeRepository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getRepository(){
        if (employeeRepository == null) employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }

    private Employee findProduct(final String employeeNumber){
        for(Employee e : this.employees){
            if(e.getEmployeeNumber().equals(employeeNumber)) return e;
        }
        return null;
        //return this.prouducts.stream().filter(product -> product.getProductId().equals(productId)).findAny().orElse(null);
    }

    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee updatedEmployee = null;
        //Employee em = new Employee.Builder().copy(employee).employeeFirstName(); #Due to using SET this is not needed
        Employee e = read(employee.getEmployeeNumber());
        if (e != null){
            delete(employee.getEmployeeNumber());
            this.employees.add(employee);
            updatedEmployee = employee;
        }
        return updatedEmployee;
//-----------------------------------------------------------------------
        /*Employee toDelete = findProduct(employee.getEmployeeNumber());
        if(toDelete != null){
            this.employees.remove(toDelete);
            return create(employee);
        }
        return null;*/
    }

    @Override
    public Employee delete(String s) {
        Employee e = read(s);
        if (e != null) {
            this.employees.remove(e);
        }
        return e;
    }

    @Override
    public Employee read(String s) {
        return this.employees.stream().filter(e -> e.getEmployeeNumber().equals(s)).findAny().orElse(null);
    }
}
