package com.jadekearns.service.user.impl;

import com.jadekearns.domain.user.EmployeeRace;
import com.jadekearns.factory.user.EmployeeRaceFactory;
import com.jadekearns.repository.user.EmployeeRaceRepository;
import com.jadekearns.repository.user.impl.EmployeeRaceRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeRaceServiceImplTest {

    final UUID employeeNumber = UUID.randomUUID();
    final UUID raceId = UUID.randomUUID();

    private EmployeeRaceRepository repository;
    private EmployeeRace employeeRace;

    private EmployeeRace getSavedEmployeeRace(){
        Set<EmployeeRace> savedEmployeeRace = this.repository.getAll();
        return savedEmployeeRace.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<EmployeeRace>employeeRaces = this.repository.getAll();
        System.out.println("In getall, all: " + employeeRaces);

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(employeeNumber.toString(),raceId.toString());
        EmployeeRace saveEmployeeRace = this.repository.create(employeeRace);
        EmployeeRace read = this.repository.read(employeeRace.getEmployeeNumber());
        System.out.println(saveEmployeeRace);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals(read.getEmployeeNumber(),saveEmployeeRace.getEmployeeNumber());
        Assert.assertNotNull(saveEmployeeRace.getRaceId());
    }

    @Test
    public void c_update() {
        final UUID employeeNumber2 = UUID.randomUUID();
        final UUID raceId2 = UUID.randomUUID();

        EmployeeRace employeeRace = EmployeeRaceFactory.buildEmployeeRace(employeeNumber2.toString(),raceId2.toString());

        repository.create(employeeRace);
        EmployeeRace inRepo = repository.read(employeeRace.getEmployeeNumber());


        repository.update(employeeRace);

        Assert.assertEquals(employeeRace.getEmployeeNumber(), inRepo.getEmployeeNumber());
    }

    @Test
    public void e_delete() {
        EmployeeRace saved = getSavedEmployeeRace();
        this.repository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeRace savedEmployeeRace = getSavedEmployeeRace();
        EmployeeRace read = this.repository.read(savedEmployeeRace.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployeeRace);
    }
}