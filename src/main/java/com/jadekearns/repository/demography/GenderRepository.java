package com.jadekearns.repository.demography;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender,String> {

    Set<Gender> getAll();
}
