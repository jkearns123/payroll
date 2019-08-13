package com.jadekearns.repository.demography;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race,String> {

    Set<Race> getAll();
}
