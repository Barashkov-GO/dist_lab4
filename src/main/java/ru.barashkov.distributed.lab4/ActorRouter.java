package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {
    private final ActorRef storageActor;

    public ActorRouter() {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        
    }
    @Override
    public Receive createReceive() {

    }
}
