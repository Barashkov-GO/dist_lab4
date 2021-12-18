package ru.barashkov.distributed.lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.routing.BalancingPool;
import akka.routing.RoundRobinPool;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;

import static java.security.AccessController.getContext;

public class App {

    public void main(String[] args) {
        ActorSystem system = ActorSystem.create("js");
        ActorRef actorRouter = system.actorOf(Props.create(ActorRouter.class));
        final Http http = Http.get(system);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.getRoute().flow(system, actorMaterializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                actorMaterializer
        );
    }
}
