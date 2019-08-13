package com.jadekearns.service.user;

import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.service.IService;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender,String> {
    Set<EmployeeGender> getAll();
}