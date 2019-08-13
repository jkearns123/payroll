package com.jadekearns.factory.user;

import com.jadekearns.domain.user.EmployeeRace;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeRaceFactoryTest {

    final UUID employeeNumber = UUID.randomUUID();
    final UUID raceId = UUID.randomUUID();

    EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(employeeNumber.toString(),raceId.toString());

    @Test
    public void buildEmployeeRaceEmployeeNumber() {
        Assert.assertNotNull(employeeRace.getEmployeeNumber());
        System.out.println(employeeRace.getEmployeeNumber());
    }

    @Test
    public void buildEmployeeRaceRaceId(){
        Assert.assertNotNull(employeeRace.getRaceId());
        System.out.println(employeeRace.getRaceId());
    }
}