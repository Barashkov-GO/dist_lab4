package ru.barashkov.distributed.lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.BalancingPool;
import akka.routing.RoundRobinPool;

import static java.security.AccessController.getContext;

public class App {

    public void main(String[] args) {
        ActorSystem system = ActorSystem.create("js");
        ActorRef storeActor = system.actorOf(
                Props.create(new BalancingPool())
        );
        ActorRef actorRouter =
        testPerformerActor = getContext().actorOf(
                new RoundRobinPool(5)
                        .withSupervisorStrategy(strategy)
                        .props(Props.create(TestPerformerActor.class, logResultsActor)),
                "routerForTests"
        );
    }
}
