package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private final String testName;
    private final Object[] params;
    private final String expectedResult;

    public Test(
            @JsonProperty("testName") String testName,
            @JsonProperty("params") Object[] params,
            @JsonProperty("expectedResult") String expectedResult) {
        this.testName = testName;
        this.params = params;
        this.expectedResult = expectedResult;
    }

    public String getTestName() {
        return testName;
    }

    public Object[] getParams() {
        return params;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String toString() {
        return "Test name: " + testName + "\tExpected result: " + expectedResult + "\n";
    }
}
