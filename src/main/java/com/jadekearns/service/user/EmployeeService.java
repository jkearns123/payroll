package com.jadekearns.service.user;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee,String> {
    Set<Employee> getAll();
}
