package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class TestActor extends AbstractActor {
    private final static String ENGINE = "nashorn";
    private String testStatus;

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(
            TestPackage.class, m -> sender().tell(
                runTest(TestPackage)
        )
    }

    private String executeJS(String jscript, String functionName, Object[] params)
            throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName(ENGINE);
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private TestResult runTest(TestPackage testPackage, String jscript, String functionName,
                               Object[] params) throws ScriptException, NoSuchMethodException {
        String executionResult = executeJS(jscript, functionName, params);
        ArrayList<TestResult> testResults = new ArrayList<TestResult>();
        for (int i = 0; i < testPackage.getTests(); i++) {
            Test t =
            testResults.add(TestResult(test.getTestName(), test.getExpectedResult(), executionResult));
        }
        this.testStatus = testResult.getTestStatus();
        return testResult;
    }
}
