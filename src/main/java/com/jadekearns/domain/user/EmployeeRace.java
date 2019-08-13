package com.jadekearns.domain.user;

public class EmployeeRace {

    private String employeeNumber, raceId;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public EmployeeRace(String employeeNumber, String raceId) {
        this.employeeNumber = employeeNumber;
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "EmployeeRace{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", raceId='" + raceId + '\'' +
                '}';
    }
}
