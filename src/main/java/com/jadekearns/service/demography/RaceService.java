package com.jadekearns.service.demography;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race,String> {
    Set<Race> getAll();
}