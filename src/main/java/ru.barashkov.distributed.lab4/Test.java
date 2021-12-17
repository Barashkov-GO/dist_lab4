package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private final String testName;
    private final Object[] params;
    private final String expectedResult;

    public Test(
            @JsonProperty("testName") String testName,
            @JsonProperty("params") Object[] params,
            
    ){

    }
}
