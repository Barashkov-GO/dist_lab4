package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestPackage {
    private final Integer packageId;
    private final String jscript;
    private final String funcName;
    private final ArrayList<Test> tests;

    public TestPackage(
            @JsonProperty("packageId") Integer packageId,
            @JsonProperty("jscript") String jscript,
            @JsonProperty("functionName") String funcName,
            @JsonProperty
    ) {

    }



}
