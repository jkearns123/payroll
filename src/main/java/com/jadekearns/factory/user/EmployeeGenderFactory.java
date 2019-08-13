package com.jadekearns.factory.user;

import com.jadekearns.domain.user.EmployeeGender;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(String empId, String genderId){
        return new EmployeeGender(empId, genderId);
    }
}
