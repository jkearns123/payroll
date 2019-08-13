package com.jadekearns.factory.demography;

import com.jadekearns.domain.demography.Gender;
import com.jadekearns.util.Miscellaneous;

public class GenderFactory {

    public static Gender buildGender(String gender){
        return new Gender.Builder()
                .id(Miscellaneous.generateId())
                .description(gender)
                .build();
    }
}
