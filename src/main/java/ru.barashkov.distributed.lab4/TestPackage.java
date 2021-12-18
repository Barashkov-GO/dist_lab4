package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestPackage {
    private final Integer packageId;
    private final String jscript;
    private final String funcName;
    private static ArrayList<Test> tests;

    @JsonCreator
    public TestPackage(
            @JsonProperty("packageId") Integer packageId,
            @JsonProperty("jscript") String jscript,
            @JsonProperty("functionName") String funcName,
            @JsonProperty("tests") ArrayList<Test> tests) {
        this.funcName = funcName;
        this.packageId = packageId;
        this.tests = tests;
        this.jscript = jscript;
    }


    public Integer getPackageId() {
        return packageId;
    }

    public String getJscript() {
        return jscript;
    }

    public String getFuncName() {
        return funcName;
    }

    public static ArrayList<Test> getTests() {
        return tests;
    }

    @Override
    public String toString() {
        String out;
        out += "Package id:" + packageId.toString();
    }
}
