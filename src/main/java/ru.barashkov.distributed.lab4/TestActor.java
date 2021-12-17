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
    

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(
            TestPackage.class,
            m -> sender().tell(
                runPackage(m),
                self()
            )
        )
        .build();
    }

    private String executeJS(String jscript, String functionName, Object[] params)
            throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName(ENGINE);
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private ArrayList<TestResult> runPackage(TestPackage testPackage) throws ScriptException, NoSuchMethodException {
        ArrayList<TestResult> packageResult = new ArrayList<>();
        for (Test t : TestPackage.getTests()) {
            String executionResult = executeJS(
                    testPackage.getJscript(),
                    testPackage.getFuncName(),
                    t.getParams()
            );
            packageResult.add(
                    new TestResult(
                            t.getTestName(),
                            t.getExpectedResult(),
                            executionResult
                    )
            );
        }
        return packageResult;
    }
}
