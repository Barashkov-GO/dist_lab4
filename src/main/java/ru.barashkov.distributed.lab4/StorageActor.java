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
                match(MessageSetResult.class,
                        m -> setResult(m)
                ).
                match(MessageGetResult.class,
                        m -> sender().tell(
                                new MessageGetResult(
                                    m.getId(),
                                    storage.get(m.getId())
                                )
                        ).
                build();
    }

    private void setResult(MessageSetResult m) {
        if (storage.containsKey()) {
            storage.get().
                    add(m.getResult());
        } else {
            storage.put(
                    m.getId(),
                    m.getResult()
            );
        }
    }
}
