package com.jadekearns.util;

import java.util.UUID;

public class Miscellaneous {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
