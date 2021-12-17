package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageGetResult {
    private final String Id;
    private final ArrayList<TestResult> testResults;

    public MessageGetResult(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> testResults) {
        this.Id = packageId;
        this.testResults = testResults;
    }

    public String getId() {
        return this.Id;
    }

    public ArrayList<TestResult> getTestResults() {
        return this.testResults;
    }
}
