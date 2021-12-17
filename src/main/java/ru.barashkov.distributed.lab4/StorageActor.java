package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor{

    private Map<Integer, ArrayList<TestResult>> storage = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().
                match(
                        MessageSetResult.class,
                        m -> setResult(m)
                ).
                match(
                        MessageGetResult.class,
                        m -> sender().tell(
                                new TestResultReply(
                                    m.getId(),
                                    storage.get(m.getId())
                                ),
                                self()
                        )
                ).
                build();
    }

    private void setResult(MessageSetResult m) {
        String testId = m.getId();
        ArrayList<TestResult> testResults = m.getResult();
        if (storage.containsKey(testId)) {
            storage.get(testId).
                    add(testResults);
        } else {
            storage.put(
                    testId,
                    testResults
            );
        }
    }
}
