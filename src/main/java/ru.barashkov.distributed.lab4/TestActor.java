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
            TestResult.class, m -> sender().tell(
                runTest(TestResult, )
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

    private TestResult runTest(TestResult test, String jscript, String functionName,
                               Object[] params) throws ScriptException, NoSuchMethodException {
        String executionResult = executeJS(jscript, functionName, params);
        TestResult testResult = new TestResult(test.getTestName(), test.getExpectedResult(), executionResult);
        this.testStatus = testResult.getTestStatus();
        return testResult;
    }
}
