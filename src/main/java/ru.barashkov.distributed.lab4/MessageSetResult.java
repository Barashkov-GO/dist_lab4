package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageSetResult {
    private final String Id;
    private final TestResult testResult;

    public MessageSetResult(
            String packageId,
            String testName,
            testResults) {
        this.Id = packageId;
        this.testResult = testResults;
    }

    public String getId() {
        return this.Id;
    }

    public ArrayList<TestResult> getResults() {
        return this.testResult;
    }
}
