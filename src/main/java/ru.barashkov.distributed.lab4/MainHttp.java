package ru.barashkov.distributed.lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import static akka.http.javadsl.server.Directives.*;

import java.time.Duration;
import java.util.concurrent.CompletionStage;

public class MainHttp {
    private final static String PACKAGE_ID_STR = "packageId";
    private final static String TESTING_STR = "Start testing...\n";
    private final static Duration TIME_OUT = Duration.ofSeconds(5);

    private final ActorRef actorRouter;

    public MainHttp(ActorRef actorRouter) {
        this.actorRouter = actorRouter;
    }

    public Route getRoute() {
        return route(
                    get(
                            () -> parameter(
                                    PACKAGE_ID_STR,
                                    (m) -> {
                                        CompletionStage<Object> res = Patterns.ask(
                                                actorRouter,
                                                new MessageGetResult(m),
                                                TIME_OUT
                                        );
                                        return completeOKWithFuture(res, Jackson.marshaller());
                                    }
                            )
                    ),
                    post(
                            () -> entity(
                                    Jackson.unmarshaller(TestPackage.class),
                                    m -> {
                                            actorRouter.tell(m, ActorRef.noSender());
                                            return complete(TESTING_STR);
                                    }
                            )
                    )
        );
    }
}
