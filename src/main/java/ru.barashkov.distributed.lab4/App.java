package ru.barashkov.distributed.lab4;

import akka.actor.Props;
import akka.routing.RoundRobinPool;

import static java.security.AccessController.getContext;

public class App {

    public void main(String[] args) {
        testPerformerActor = getContext().actorOf(
                new RoundRobinPool(5)
                        .withSupervisorStrategy(strategy)
                        .props(Props.create(TestPerformerActor.class, logResultsActor)),
                "routerForTests"
        );
    }
}
