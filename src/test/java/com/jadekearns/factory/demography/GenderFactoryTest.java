package com.jadekearns.factory.demography;

import com.jadekearns.domain.demography.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    Gender gender = GenderFactory.buildGender("Male");

    @Test
    public void buildGender() {

        Assert.assertEquals("Male",gender.getDescription());

    }

    @Test
    public void buildGenderId(){
        Assert.assertNotNull(gender.getId());
        System.out.println(gender.getId());
    }
}