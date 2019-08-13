package com.jadekearns.service.demography.impl;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.repository.demography.GenderRepository;
import com.jadekearns.repository.demography.impl.GenderRepositoryImpl;
import com.jadekearns.service.demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private static GenderService service = null;
    private GenderRepository genderRepository;

    private GenderServiceImpl(){
        this.genderRepository = GenderRepositoryImpl.getRepository();
    }

    public static GenderService getGenderService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        Set<Gender> gender = this.genderRepository.getAll();
        return gender;
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.update(gender);
    }

    @Override
    public Gender delete(String s) {
        return this.genderRepository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.genderRepository.read(s);
    }
}
