package ru.barashkov.distributed.lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.BalancingRoutingLogic;
import akka.routing.RoutedActorCell;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;

public class ActorRouter extends AbstractActor {
    private static final Integer TEST_ACTORS_AMOUNT = 10;

    private final ActorRef storageActor;
    private final Router router;


    public ActorRouter() {
        this.storageActor = getContext().actorOf(Props.create(ActorStorage.class));
        ArrayList<Routee> actors = new ArrayList<>();
        for (int i = 0; i < TEST_ACTORS_AMOUNT; i++) {
            actors.add(getContext().actorOf(Props.create(ActorTest.class)));
        }
        this.router = new Router(new BalancingRoutingLogic(), actors);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(
                        MessageGetResult.class,
                        m -> 
                ).
                match(

                ).
                build();
    }
}
