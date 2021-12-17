package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class ActorRouter extends AbstractActor {
    private static final Integer TEST_ACTORS_AMOUNT = 10;
    private final ActorRef storageActor;


    public ActorRouter() {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        for (int i = 0; i < TEST_ACTORS_AMOUNT; i++) {
            ActorRef ac = getContext().actorOf(Props.create(ActorTest.class));
        }

    }
    @Override
    public Receive createReceive() {

    }
}
