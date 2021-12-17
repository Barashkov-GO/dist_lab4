package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageSetResult {
    private final String Id;
    private final TestResult testResult;

    public MessageSetResult(
            String packageId,
            String testName,
            String expectedResult,
            String actualResult) {
        this.Id = packageId;
        this.testResult = new testResult(;
    }

    public String getId() {
        return this.Id;
    }

    public ArrayList<TestResult> getResults() {
        return this.testResult;
    }
}
