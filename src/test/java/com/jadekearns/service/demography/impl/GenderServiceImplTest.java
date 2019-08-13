package com.jadekearns.service.demography.impl;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.factory.demography.GenderFactory;
import com.jadekearns.repository.demography.GenderRepository;
import com.jadekearns.repository.demography.impl.GenderRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {

    private String genderMF = "Male";

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGender = this.repository.getAll();
        return savedGender.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Gender>genders = this.repository.getAll();
        System.out.println("In getall, all: " + genders);

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Gender gen = GenderFactory.buildGender(genderMF);
        Gender saveGen = this.repository.create(gen);
        System.out.println(saveGen);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals("Male",saveGen.getDescription());
        Assert.assertNotNull(saveGen.getId());
    }

    @Test
    public void c_update() {
        Gender gender = GenderFactory.buildGender("Female");

        repository.create(gender);
        Gender inRepo = repository.read(gender.getId());

        repository.update(gender);
        System.out.println(gender.getDescription() + " " + inRepo.getDescription());
        Assert.assertEquals(gender.getDescription(), inRepo.getDescription());
    }

    @Test
    public void e_delete() {
        Gender saved = getSavedGender();
        this.repository.delete(saved.getId());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        Gender savedGender = getSavedGender();
        Gender read = this.repository.read(savedGender.getId());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedGender);
    }
}