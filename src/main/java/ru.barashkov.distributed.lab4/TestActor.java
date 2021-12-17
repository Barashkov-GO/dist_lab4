package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestActor extends AbstractActor {
    private final static String ENGINE = "nashorn";

    @Override
    public Receive createReceive() {
    }

    private String executeJS(String jscript, String functionName, Object[] params) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName(ENGINE);
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }
}
