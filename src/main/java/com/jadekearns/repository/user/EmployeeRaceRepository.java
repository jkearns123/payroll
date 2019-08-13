package com.jadekearns.repository.user;

import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.repository.IRepository;

import java.util.Set;

public interface EmployeeRaceRepository extends IRepository<EmployeeRace,String> {
    Set<EmployeeRace> getAll();
}
