package com.jadekearns.controller.user;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.domain.demography.Race;
import com.jadekearns.domain.user.Employee;
import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.factory.demography.GenderFactory;
import com.jadekearns.factory.demography.RaceFactory;
import com.jadekearns.factory.user.EmployeeFactory;
import com.jadekearns.factory.user.EmployeeGenderFactory;
import com.jadekearns.factory.user.EmployeeRaceFactory;
import com.jadekearns.repository.demography.GenderRepository;
import com.jadekearns.repository.demography.RaceRepository;
import com.jadekearns.repository.demography.impl.GenderRepositoryImpl;
import com.jadekearns.repository.demography.impl.RaceRepositoryImpl;
import com.jadekearns.repository.user.EmployeeGenderRepository;
import com.jadekearns.repository.user.EmployeeRaceRepository;
import com.jadekearns.repository.user.EmployeeRepository;
import com.jadekearns.repository.user.impl.EmployeeGenderRepositoryImpl;
import com.jadekearns.repository.user.impl.EmployeeRaceRepositoryImpl;
import com.jadekearns.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class EmployeeControllerTest {

    private EmployeeController employeeController;

    private EmployeeRepository employeeRepository;
    private Employee employee;

    private GenderRepository genderRepository;
    private Gender gender;

    private RaceRepository raceRepository;
    private Race race;

    private EmployeeRaceRepository employeeRaceRepository;
    private EmployeeRace employeeRace;

    private EmployeeGenderRepository employeeGenderRepository;
    private EmployeeGender employeeGender;

   //private EmployeeRepository employeeRepository;
    //private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployee = this.employeeRepository.getAll();
        return savedEmployee.iterator().next();
    }

    private Gender getSavedGender(){
        Set<Gender> savedGender = this.genderRepository.getAll();
        return savedGender.iterator().next();
    }

    private Race getSavedRace(){
        Set<Race> savedRace = this.raceRepository.getAll();
        return savedRace.iterator().next();
    }

    private EmployeeRace getSavedEmployeeRace(){
        Set<EmployeeRace> savedEmployeeRace = this.employeeRaceRepository.getAll();
        return savedEmployeeRace.iterator().next();
    }

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedEmployeeGender = this.employeeGenderRepository.getAll();
        return savedEmployeeGender.iterator().next();
    }





    @Before
    public void setUp() throws Exception {
        this.employeeRepository = EmployeeRepositoryImpl.getRepository();
        this.genderRepository = GenderRepositoryImpl.getRepository();
        this.raceRepository = RaceRepositoryImpl.getRepository();
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getRepository();
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
        employeeController = new EmployeeController();
    }

    @Test
    public void create() {
        Employee employee = EmployeeFactory.buildEmployee("Jade", "Kearns");
        Race race = RaceFactory.buildRace("Coloured");
        Gender gender = GenderFactory.buildGender("Male");

        employeeController.create(employee);
        employeeController.create(race);
        employeeController.create(gender);

        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(getSavedEmployee().getEmployeeNumber(),getSavedRace().getId());
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(getSavedEmployee().getEmployeeNumber(),getSavedGender().getId());

        employeeController.create(employeeRace);
        employeeController.create(employeeGender);

        System.out.println(getSavedEmployee().getEmployeeNumber());
        System.out.println(getSavedEmployee().getEmployeeFirstName());
        Assert.assertEquals(1, this.employeeRepository.getAll().size());

        Assert.assertEquals("Jade", getSavedEmployee().getEmployeeFirstName());
        Assert.assertEquals("Coloured", getSavedRace().getDescription());
        Assert.assertEquals("Male", getSavedGender().getDescription());
        Assert.assertEquals(getSavedEmployee().getEmployeeNumber(), getSavedEmployeeGender().getEmployeeNumber());
        Assert.assertEquals(getSavedRace().getId(), getSavedEmployeeRace().getRaceId());

        System.out.println(getSavedRace().getDescription());
        System.out.println(getSavedGender().getDescription());
        System.out.println();


    }
}