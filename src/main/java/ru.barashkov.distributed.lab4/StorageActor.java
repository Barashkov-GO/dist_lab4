package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;

public class StorageActor extends AbstractActor{

    private Map<Integer, ArrayList<TestResult>> storage = new HashMap<>()
    @Override
    public Receive createReceive() {
        return null;
    }
}
