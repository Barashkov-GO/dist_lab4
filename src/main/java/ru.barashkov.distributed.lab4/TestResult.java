package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestResult {
    private final String testName;
    private final String expectedResult;
    private final String actualResult;

    public TestResult(
            @JsonProperty("testName") String testName,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("actualResult") String actualResult) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
    }

    public String getTestName() {
        return this.testName;
    }

    public String getExpectedResult() {
        return this.expectedResult;
    }

    public String getActualResult() {
        return actualResult;
    }
}
