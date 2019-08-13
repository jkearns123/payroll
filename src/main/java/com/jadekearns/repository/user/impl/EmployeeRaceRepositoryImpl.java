package com.jadekearns.repository.user.impl;

import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.repository.user.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {

    private static EmployeeRaceRepository repository = null;
    private Set<EmployeeRace> employeeRaces;

    private EmployeeRaceRepositoryImpl(){
        this.employeeRaces = new HashSet<>();
    }

    public static EmployeeRaceRepository getRepository(){
        if (repository == null) repository = new EmployeeRaceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return this.employeeRaces;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        this.employeeRaces.add(employeeRace);
        return employeeRace;
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        EmployeeRace updatedEmployeeRace = null;
        //EmployeeRace em = new EmployeeRace.Builder().copy(employeeRace).raceDes...; #Due to using SET this is not needed
        EmployeeRace er = read(employeeRace.getEmployeeNumber());
        if (er != null){
            delete(employeeRace.getEmployeeNumber());
            this.employeeRaces.add(employeeRace);
            updatedEmployeeRace = employeeRace;
        }
        return updatedEmployeeRace;
    }

    @Override
    public EmployeeRace delete(String s) {
        EmployeeRace er = read(s);
        if (er != null) {
            this.employeeRaces.remove(er);
        }
        return er;
    }

    @Override
    public EmployeeRace read(String s) {
        return this.employeeRaces.stream().filter(e -> e.getEmployeeNumber().equals(s)).findAny().orElse(null);
    }
}
