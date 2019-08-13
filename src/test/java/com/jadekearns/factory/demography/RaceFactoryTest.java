package com.jadekearns.factory.demography;

import com.jadekearns.domain.demography.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {


    Race race = RaceFactory.buildRace("Coloured");

    @Test
    public void buildRace() {
        Assert.assertEquals("Coloured",race.getDescription());
    }

    @Test
    public void buildRaceID(){
        Assert.assertNotNull(race.getId());
        System.out.println(race.getId());
    }
}