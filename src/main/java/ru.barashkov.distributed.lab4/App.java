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
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import scala.concurrent.Future;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static java.security.AccessController.getContext;

public class App {
    private final static String SYSTEM_NAME = "js";
    private final static String SERVER_IP = "localhost";
    private final static Integer SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create(SYSTEM_NAME);
        ActorRef actorRouter = system.actorOf(Props.create(ActorRouter.class));
        final Http http = Http.get(system);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(actorRouter);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.getRoute().flow(system, actorMaterializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(SERVER_IP, SERVER_PORT),
                actorMaterializer
        );
        System.in.read();
        binding.

    }
}
