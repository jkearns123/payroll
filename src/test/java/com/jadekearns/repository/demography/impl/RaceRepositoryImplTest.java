package com.jadekearns.repository.demography.impl;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.factory.demography.RaceFactory;
import com.jadekearns.repository.demography.RaceRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {


    private String raceDemo = "Coloured";

    private RaceRepository raceRepository;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRace = this.raceRepository.getAll();
        return savedRace.iterator().next();
    }


    @Before
    public void setUp() throws Exception {
        this.raceRepository = RaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        System.out.println(this.raceRepository.getAll());
        Assert.assertEquals(2,this.raceRepository.getAll().size());
    }

    @Test
    public void a_create() {
        Race race = RaceFactory.buildRace(raceDemo);
        Race saveRace = this.raceRepository.create(race);
        System.out.println(saveRace);

        Assert.assertEquals(1, this.raceRepository.getAll().size());
        Assert.assertEquals("Coloured",saveRace.getDescription());
        Assert.assertNotNull(saveRace.getId());
    }

    @Test
    public void c_update() {

        Race employee = RaceFactory.buildRace("Female");

        raceRepository.create(employee);
        Race inRepo = raceRepository.read(employee.getId());


        raceRepository.update(employee);

        Assert.assertEquals(employee.getDescription(), inRepo.getDescription());

        //---------------------------

    }

    @Test
    public void e_delete() {
        Race saved = getSavedRace();
        this.raceRepository.delete(saved.getId());

        System.out.println("In array after deleted: " + raceRepository.getAll());

        Assert.assertEquals(1,this.raceRepository.getAll().size());
    }

    @Test
    public void b_read() {

        Race savedRace = getSavedRace();
        Race read = this.raceRepository.read(savedRace.getId());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedRace);

    }
}