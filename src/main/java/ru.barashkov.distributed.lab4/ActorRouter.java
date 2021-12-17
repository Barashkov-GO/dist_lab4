package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class ActorRouter extends AbstractActor {
    private final ActorRef storageActor;

    public ActorRouter() {
        this.storageActor = getContext().
    }
    @Override
    public Receive createReceive() {

    }
}
