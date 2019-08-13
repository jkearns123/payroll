package com.jadekearns.factory.user;

import com.jadekearns.domain.user.EmployeeGender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    final UUID employeeNumber = UUID.randomUUID();
    final UUID genderId = UUID.randomUUID();

    EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(employeeNumber.toString(),genderId.toString());

    @Test
    public void buildEmployeeGenderEmployeeNumber() {
        Assert.assertNotNull(employeeGender.getEmployeeNumber());
    }

    @Test
    public void buildEmployeeGenderGenderId(){
        Assert.assertNotNull(employeeGender.getGenderId());
    }
}