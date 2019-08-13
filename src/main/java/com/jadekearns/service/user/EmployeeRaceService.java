package com.jadekearns.service.user;

import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.service.IService;

import java.util.Set;

public interface EmployeeRaceService extends IService<EmployeeRace,String> {
    Set<EmployeeRace> getAll();
}