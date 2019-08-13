package com.jadekearns.repository.user;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {

    Set<Employee> getAll();
}
