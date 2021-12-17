package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageSetResult {
    private final Integer Id;
    private final TestResult testResult;

    public MessageSetResult(
            Integer packageId,
            String testName,
            String expectedResult,
            String actualResult) {
        this.Id = packageId;
        this.testResult = new TestResult(testName, expectedResult, actualResult);
    }

    public Integer getId() {
        return this.Id;
    }

    public TestResult getResult() {
        return this.testResult;
    }
}
