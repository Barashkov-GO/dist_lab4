package ru.barashkov.distributed.lab4;

public class MessageSetResult {
    private final Integer packageId;
    private final TestResult testResult;

    public MessageSetResult(
            Integer packageId,
            String testName,
            String expectedResult,
            String actualResult) {
        this.packageId = packageId;
        this.testResult = new TestResult(testName, expectedResult, actualResult);
    }

    public Integer getPackageId() {
        return this.packageId;
    }

    public TestResult getResult() {
        return this.testResult;
    }
}
