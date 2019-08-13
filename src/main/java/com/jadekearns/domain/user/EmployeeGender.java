package com.jadekearns.domain.user;

public class EmployeeGender {

    private String employeeNumber, genderId;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public EmployeeGender(String employeeNumber, String genderId) {
        this.employeeNumber = employeeNumber;
        this.genderId = genderId;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }
}
