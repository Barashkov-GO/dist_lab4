package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class TestResult {
    private final static String SUCCESS_STR = "SUCCESS";
    private final static String FAIL_STR = "FAILED";
    private final String testName;
    private final String expectedResult;
    private final String actualResult;
    private final String testStatus;

    public TestResult(
            @JsonProperty("testName") String testName,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("actualResult") String actualResult) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.testStatus = Objects.equals(this.expectedResult, this.actualResult) ? SUCCESS_STR : FAIL_STR;
    }

    public String getTestName() {
        return this.testName;
    }

    public String getExpectedResult() {
        return this.expectedResult;
    }

    public String getActualResult() {
        return this.actualResult;
    }

    public String getTestStatus() {
        return this.testStatus;
    }
}
