package com.jadekearns.repository.user;

import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.repository.IRepository;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
}
