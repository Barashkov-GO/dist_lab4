package ru.barashkov.distributed.lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.routing.Routee;
import static akka.http.javadsl.server.Directives.*;

import java.util.concurrent.Future;

public class MainHttp {
    private final static String PACKAGE_ID_STR = "packageId";
    private final static String TESTING_STR = "Start testing...\n";

    private ActorSystem system;

    public MainHttp(ActorSystem system) {
        this.system = system;
    }

    public Route getRoute() {
        return route(
                path("test", () ->
                    get(
                            () -> parameter(
                                    PACKAGE_ID_STR,
                                    (m) -> {
                                        Future<Object> res = Patterns.ask(
                                                ActorStorage.class,
                                                new MessageGetResult(Integer.parseInt(m))
                                        );
                                        return res;
                                    }
                            )
                    )
                ),
                path("put", () ->
                    post(
                            () -> entity(
                                    Jackson.unmarshaller(TestPackage.class),
                                    m -> {
                                            ActorTest.tell(m, ActorRef.noSender());
                                            return complete(TESTING_STR);
                                    }
                            )
                    )
                )
        );
    }
}
