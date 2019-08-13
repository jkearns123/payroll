package com.jadekearns.factory.user;

import com.jadekearns.domain.user.EmployeeRace;

public class EmployeeRaceFactory {

    public static EmployeeRace buildEmployeeRace(String empId,String raceId){
        return new EmployeeRace(empId,raceId);
    }
}
