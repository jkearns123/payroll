package com.jadekearns.service.demography;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender,String> {
    Set<Gender> getAll();
}