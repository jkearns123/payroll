package com.jadekearns.repository.demography.impl;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl  implements GenderRepository {

    private static  GenderRepository genderRepository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepository getRepository(){
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {
        Gender updatedGender = null;
        //Gender gen = new Gender.Builder().copy(gender).gender.....; #Due to using SET this is not needed
        Gender g = read(gender.getId());
        if (g != null){
            delete(gender.getId());
            this.genders.add(gender);
            updatedGender = gender;
        }
        return updatedGender;
    }

    @Override
    public Gender delete(String s) {
        Gender g = read(s);
        if (g != null) {
            this.genders.remove(g);
        }
        return g;
    }

    @Override
    public Gender read(String s) {
        return this.genders.stream().filter(g -> g.getId().equals(s)).findAny().orElse(null);
    }
}
