package com.jadekearns.domain.user;

public class Employee {

    private String employeeNumber, employeeFirstName, employeeLastName;

    private Employee() {
    }

    public Employee(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                '}';
    }

    public static class Builder{

        private String employeeNumber, employeeFirstName, employeeLastName;

        public Builder employeeNumber(String employeeNumber){
            this.employeeNumber = employeeNumber;

            return this;
        }

        public Builder employeeFirstName(String employeeFirstName){
            this.employeeFirstName = employeeFirstName;

            return this;
        }

        public Builder employeeLastName(String employeeLastName){
            this.employeeLastName = employeeLastName;

            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

        public Builder copy(Employee employee){
            this.employeeLastName = employeeLastName;
            this.employeeFirstName = employeeFirstName;
            this.employeeNumber = employeeNumber;

            return this;
        }

    }
}
