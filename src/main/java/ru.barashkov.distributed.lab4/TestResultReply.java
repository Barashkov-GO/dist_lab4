package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestResultReply {
    public TestResultReply(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> testResults) {
    }
}
