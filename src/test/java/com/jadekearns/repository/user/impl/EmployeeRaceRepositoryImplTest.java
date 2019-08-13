package com.jadekearns.repository.user.impl;

import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.factory.user.EmployeeRaceFactory;
import com.jadekearns.repository.user.EmployeeRaceRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeRaceRepositoryImplTest {

    final UUID employeeNumber = UUID.randomUUID();
    final UUID raceId = UUID.randomUUID();

    private EmployeeRaceRepository employeeRaceRepository;
    private EmployeeRace employeeRace;

    private EmployeeRace getSavedEmployeeRace(){
        Set<EmployeeRace> savedEmployeeRace = this.employeeRaceRepository.getAll();
        return savedEmployeeRace.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        System.out.println(this.employeeRaceRepository.getAll());
        Assert.assertEquals(2,this.employeeRaceRepository.getAll().size());
    }

    @Test
    public void a_create() {

        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(employeeNumber.toString(),raceId.toString());
        EmployeeRace saveEmployeeRace = this.employeeRaceRepository.create(employeeRace);
        EmployeeRace read = this.employeeRaceRepository.read(employeeRace.getEmployeeNumber());
        System.out.println(saveEmployeeRace);

        Assert.assertEquals(1, this.employeeRaceRepository.getAll().size());
        Assert.assertEquals(read.getEmployeeNumber(),saveEmployeeRace.getEmployeeNumber());
        Assert.assertNotNull(saveEmployeeRace.getRaceId());
    }

    @Test
    public void c_update() {
        final UUID employeeNumber2 = UUID.randomUUID();
        final UUID raceId2 = UUID.randomUUID();

        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(employeeNumber2.toString(),raceId2.toString());

        employeeRaceRepository.create(employeeRace);
        EmployeeRace inRepo = employeeRaceRepository.read(employeeRace.getEmployeeNumber());


        employeeRaceRepository.update(employeeRace);

        Assert.assertEquals(employeeRace.getEmployeeNumber(), inRepo.getEmployeeNumber());
    }

    @Test
    public void e_delete() {
        EmployeeRace saved = getSavedEmployeeRace();
        this.employeeRaceRepository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + employeeRaceRepository.getAll());

        Assert.assertEquals(1,this.employeeRaceRepository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeRace savedEmployeeRace = getSavedEmployeeRace();
        EmployeeRace read = this.employeeRaceRepository.read(savedEmployeeRace.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployeeRace);
    }
}