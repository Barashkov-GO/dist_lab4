package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestResultReply {
    private final Integer Id;
    private final ArrayList<TestResult> testResults;

    public TestResultReply(
            Integer packageId,
            ArrayList<TestResult> testResults) {
        this.Id = packageId;
        this.testResults = testResults;
    }

    public Integer getId() {
        return this.Id;
    }

    public ArrayList<TestResult> getResults() {
        return this.testResults;
    }
}
