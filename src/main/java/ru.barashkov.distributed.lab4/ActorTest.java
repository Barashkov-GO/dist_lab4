package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorTest extends AbstractActor {
    private final static String ENGINE = "nashorn";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(
                TestPackage.class,
                this::runPackage
        )
        .build();
    }

    private String executeJS(String jscript, String functionName, Object[] params)
            throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(ENGINE);
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private void runPackage(TestPackage testPackage)
            throws ScriptException, NoSuchMethodException {
        for (Test t : TestPackage.getTests()) {
            String executionResult = executeJS(
                    testPackage.getJscript(),
                    testPackage.getFuncName(),
                    t.getParams()
            );
            sender().tell(
                    new MessageSetResult(
                            testPackage.getPackageId(),
                            t.getTestName(),
                            t.getExpectedResult(),
                            executionResult
                    ),
                    self()
            );
        }
    }
}
