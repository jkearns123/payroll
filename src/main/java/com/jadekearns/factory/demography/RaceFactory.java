package com.jadekearns.factory.demography;

import com.jadekearns.domain.demography.Race;
import com.jadekearns.util.Miscellaneous;

public class RaceFactory {

    public static Race buildRace(String race){
        return new Race.Builder()
                .id(Miscellaneous.generateId())
                .description(race)
                .build();
    }
}
