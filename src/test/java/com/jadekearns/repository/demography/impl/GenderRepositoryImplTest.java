package com.jadekearns.repository.demography.impl;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.factory.demography.GenderFactory;
import com.jadekearns.repository.demography.GenderRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private String genderMF = "Male";

    private GenderRepository genderRepository;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGender = this.genderRepository.getAll();
        return savedGender.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.genderRepository = GenderRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        System.out.println(this.genderRepository.getAll());
        Assert.assertEquals(2,this.genderRepository.getAll().size());
    }

    @Test
    public void a_create() {
        Gender gen = GenderFactory.buildGender(genderMF);
        Gender saveGen = this.genderRepository.create(gen);
        System.out.println(saveGen);

        Assert.assertEquals(1, this.genderRepository.getAll().size());
        Assert.assertEquals("Male",saveGen.getDescription());
        Assert.assertNotNull(saveGen.getId());
    }

    @Test
    public void b_update() {

        Gender gender = GenderFactory.buildGender("Female");

        genderRepository.create(gender);
        Gender inRepo = genderRepository.read(gender.getId());

        genderRepository.update(gender);
        System.out.println(gender.getDescription() + " " + inRepo.getDescription());
        Assert.assertEquals(gender.getDescription(), inRepo.getDescription());

    }

    @Test
    public void e_delete() {
        Gender saved = getSavedGender();
        this.genderRepository.delete(saved.getId());

        System.out.println("In array after deleted: " + genderRepository.getAll());

        Assert.assertEquals(1,this.genderRepository.getAll().size());
    }

    @Test
    public void read() {
        Gender savedGender = getSavedGender();
        Gender read = this.genderRepository.read(savedGender.getId());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedGender);
    }
}