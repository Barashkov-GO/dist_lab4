package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoutedActorCell;
import akka.routing.Router;

import java.util.ArrayList;

public class ActorRouter extends AbstractActor {
    private static final Integer TEST_ACTORS_AMOUNT = 10;
    private final ActorRef storageActor;


    public ActorRouter() {
        ArrayList<ActorRef> actors = new ArrayList<>();
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        for (int i = 0; i < TEST_ACTORS_AMOUNT; i++) {
            actors.add(getContext().actorOf(Props.create(ActorTest.class)));
        }
        router = new Router()

    }
    @Override
    public Receive createReceive() {

    }
}
