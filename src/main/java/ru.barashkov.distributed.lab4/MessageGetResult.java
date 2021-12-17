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
    
}
