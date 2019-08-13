package com.jadekearns.service.demography.impl;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.repository.demography.RaceRepository;
import com.jadekearns.repository.demography.impl.RaceRepositoryImpl;
import com.jadekearns.service.demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceService service = null;
    private RaceRepository raceRepository;

    private RaceServiceImpl(){
        this.raceRepository = RaceRepositoryImpl.getRepository();
    }

    public static RaceService getRaceService(){
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Set<Race> getAll() {
        Set<Race> race = this.raceRepository.getAll();
        return race;
    }

    @Override
    public Race create(Race race) {
        return this.raceRepository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.update(race);
    }

    @Override
    public Race delete(String s) {
        return this.raceRepository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.raceRepository.read(s);
    }
}
