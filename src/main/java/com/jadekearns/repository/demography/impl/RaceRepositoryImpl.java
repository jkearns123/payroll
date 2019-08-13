package com.jadekearns.repository.demography.impl;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static  RaceRepository raceRepository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepository getRepository(){
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {
        Race updatedRace = null;
        //Race r = new Race.Builder().copy(race).race....; #Due to using SET this is not needed
        Race r = read(race.getId());
        if (r != null){
            delete(race.getId());
            this.races.add(race);
            updatedRace = race;
        }
        return updatedRace;
    }

    @Override
    public Race delete(String s) {
        Race r = read(s);
        if (r != null) {
            this.races.remove(r);
        }
        return r;
    }

    @Override
    public Race read(String s) {
        return this.races.stream().filter(r -> r.getId().equals(s)).findAny().orElse(null);
    }
}
