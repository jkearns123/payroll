package com.jadekearns.repository.user.impl;

import com.jadekearns.domain.user.EmployeeGender;
import com.jadekearns.factory.user.EmployeeGenderFactory;
import com.jadekearns.repository.user.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmployeeGenderRepositoryImplTest {


    final UUID EmployeeNumber = UUID.randomUUID();
    final UUID GenderId = UUID.randomUUID();

    private EmployeeGenderRepository employeeGenderRepository;
    private EmployeeGender employeeGender;

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedRace = this.employeeGenderRepository.getAll();
        return savedRace.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @Test
    public void d_getAll() {
        System.out.println(this.employeeGenderRepository.getAll());
        Assert.assertEquals(2,this.employeeGenderRepository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(EmployeeNumber.toString(),GenderId.toString());
        EmployeeGender saveEmployeeGender = this.employeeGenderRepository.create(employeeGender);
        EmployeeGender read = this.employeeGenderRepository.read(employeeGender.getEmployeeNumber());
        System.out.println(saveEmployeeGender);

        Assert.assertEquals(1, this.employeeGenderRepository.getAll().size());
        Assert.assertEquals(read.getEmployeeNumber(),saveEmployeeGender.getEmployeeNumber());
        Assert.assertNotNull(saveEmployeeGender.getGenderId());
    }

    @Test
    public void c_update() {

        final UUID employeeNumber2 = UUID.randomUUID();
        final UUID genderId2 = UUID.randomUUID();

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(employeeNumber2.toString(),genderId2.toString());

        employeeGenderRepository.create(employeeGender);
        EmployeeGender inRepo = employeeGenderRepository.read(employeeGender.getEmployeeNumber());


        employeeGenderRepository.update(employeeGender);

        Assert.assertEquals(employeeGender.getEmployeeNumber(), inRepo.getEmployeeNumber());
    }

    @Test
    public void e_delete() {
        EmployeeGender saved = getSavedEmployeeGender();
        this.employeeGenderRepository.delete(saved.getEmployeeNumber());

        System.out.println("In array after deleted: " + employeeGenderRepository.getAll());

        Assert.assertEquals(1,this.employeeGenderRepository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        EmployeeGender read = this.employeeGenderRepository.read(savedEmployeeGender.getEmployeeNumber());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedEmployeeGender);
    }
}