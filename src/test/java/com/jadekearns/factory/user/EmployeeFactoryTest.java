package com.jadekearns.factory.user;

import com.jadekearns.domain.user.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    Employee employee = EmployeeFactory.buildEmployee("Jade","Kearns");

    @Test
    public void buildEmployeeFirstName() {
        Assert.assertEquals("Jade",employee.getEmployeeFirstName());
    }

    @Test
    public void buildEmployeeLastName() {
        Assert.assertEquals("Kearns",employee.getEmployeeLastName());
    }

    @Test
    public void buildGenderId(){
        Assert.assertNotNull(employee.getEmployeeNumber());
        System.out.println(employee.getEmployeeNumber());
    }


}