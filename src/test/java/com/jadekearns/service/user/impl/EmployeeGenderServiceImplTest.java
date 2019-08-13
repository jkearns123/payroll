package com.jadekearns.service.user.impl;

import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.factory.user.EmployeeGenderFactory;
import com.jadekearns.repository.user.EmployeeGenderRepository;
import com.jadekearns.repository.user.impl.EmployeeGenderRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeGenderServiceImplTest {

    final UUID EmployeeNumber = UUID.randomUUID();
    final UUID GenderId = UUID.randomUUID();

    private EmployeeGenderRepository repository;
    private EmployeeGender employeeGender;

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedRace = this.repository.getAll();
        return savedRace.iterator().next();
    }


    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender>employeeGenders = this.repository.getAll();
        System.out.println("In getall, all: " + employeeGenders);

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(EmployeeNumber.toString(),GenderId.toString());
        EmployeeGender saveEmployeeGender = this.repository.create(employeeGender);
        EmployeeGender read = this.repository.read(employeeGender.getEmployeeNumber());
        System.out.println(saveEmployeeGender);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals(read.getEmployeeNumber(),saveEmployeeGender.getEmployeeNumber());
        Assert.assertNotNull(saveEmployeeGender.getGenderId());
    }

    @Test
    public void c_update() {
        final UUID employeeNumber2 = UUID.randomUUID();
        final UUID genderId2 = UUID.randomUUID();

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(employeeNumber2.toString(),genderId2.toString());

        repository.create(employeeGender);
        EmployeeGender inRepo = repository.read(employeeGender.getEmployeeNumber());


        repository.update(employeeGender);

        Assert.assertEquals(employeeGender.getEmployeeNumber(), inRepo.getEmployeeNumber());

    }

    @Test
    public void e_delete() {
        EmployeeGender saved = getSavedEmployeeGender();
        this.repository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        EmployeeGender read = this.repository.read(savedEmployeeGender.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployeeGender);
    }
}