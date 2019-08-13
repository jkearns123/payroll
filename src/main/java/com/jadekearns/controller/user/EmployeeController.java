package com.jadekearns.controller.user;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.domain.demography.Race;
import com.jadekearns.domain.user.Employee;
import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.service.demography.GenderService;
import com.jadekearns.service.demography.RaceService;
import com.jadekearns.service.demography.impl.GenderServiceImpl;
import com.jadekearns.service.demography.impl.RaceServiceImpl;
import com.jadekearns.service.user.EmployeeGenderService;
import com.jadekearns.service.user.EmployeeRaceService;
import com.jadekearns.service.user.EmployeeService;
import com.jadekearns.service.user.impl.EmployeeGenderServiceImpl;
import com.jadekearns.service.user.impl.EmployeeRaceServiceImpl;
import com.jadekearns.service.user.impl.EmployeeServiceImpl;

public class EmployeeController {

    private EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();
    private EmployeeGenderService employeeGenderService = EmployeeGenderServiceImpl.getEmployeeGenderService();
    private EmployeeRaceService employeeRaceService = EmployeeRaceServiceImpl.getEmployeeRaceService();
    private RaceService raceService = RaceServiceImpl.getRaceService();
    private GenderService genderService = GenderServiceImpl.getGenderService();

/*    public void create(String firstName, String lastName, int genderId, int raceId){

        Employee employee = EmployeeFactory.buildEmployee(firstName, lastName);
        employeeService.create(employee);

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender("123", "456");
        employeeGenderService.create(employeeGender);

        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace("567", "987");
        employeeRaceService.create(employeeRace);

        Race race = RaceFactory.buildRace("Indian");
        raceService.create(race);

        Gender gender = GenderFactory.buildGender("Male");
        genderService.create(gender);


    }*/


    public Employee create(Employee employee){
        return this.employeeService.create(employee);
    }

    public Gender create(Gender gender){
        return this.genderService.create(gender);
    }

    public Race create(Race race){
        return this.raceService.create(race);
    }

    public EmployeeGender create(EmployeeGender employeeGender){
        return this.employeeGenderService.create(employeeGender);
    }

    public EmployeeRace create(EmployeeRace employeeRace){
        return this.employeeRaceService.create(employeeRace);
    }






}
