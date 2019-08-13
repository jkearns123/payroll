package com.jadekearns.service.demography.impl;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.factory.demography.RaceFactory;
import com.jadekearns.repository.demography.RaceRepository;
import com.jadekearns.repository.demography.impl.RaceRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {

    private String raceDemo = "Coloured";

    private RaceRepository repository;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRace = this.repository.getAll();
        return savedRace.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Race>races = this.repository.getAll();
        System.out.println("In getall, all: " + races);

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Race race = RaceFactory.buildRace(raceDemo);
        Race saveRace = this.repository.create(race);
        System.out.println(saveRace);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals("Coloured",saveRace.getDescription());
        Assert.assertNotNull(saveRace.getId());
    }

    @Test
    public void c_update() {
        Race employee = RaceFactory.buildRace("Female");

        repository.create(employee);
        Race inRepo = repository.read(employee.getId());


        repository.update(employee);

        Assert.assertEquals(employee.getDescription(), inRepo.getDescription());
    }

    @Test
    public void e_delete() {
        Race saved = getSavedRace();
        this.repository.delete(saved.getId());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        Race savedRace = getSavedRace();
        Race read = this.repository.read(savedRace.getId());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedRace);
    }
}