package com.jadekearns.factory.user;

import com.jadekearns.domain.user.Employee;
import com.jadekearns.util.Miscellaneous;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName, String lastName){
        return new Employee.Builder()
                .employeeNumber(Miscellaneous.generateId())
                .employeeFirstName(firstName)
                .employeeLastName(lastName)
                .build();
    }
}
