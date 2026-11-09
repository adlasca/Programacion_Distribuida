package com.programacion.distribuida.web;

import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import io.helidon.http.media.jsonb.JsonbSupport;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;
import jakarta.json.JsonObject;

import java.util.Map;

public class Web03Main {

    private static DbClient dbClient;

    public static void handleBooks(ServerRequest req, ServerResponse res){

        //var books =
                dbClient.execute()
                .createQuery("select * from books")
                .execute()
                .map(row -> Book.builder()
                        .title(row.column("title").getString())
                        .isbn(row.column("isbn").getString())
                        .build())
                .forEach(System.out::println);
/*
        //Como construye JSONP
        JsonBuilderFactory factory = Json.createBuilderFactory(Map.of());
        JsonObject book = factory.createObjectBuilder()
                .add("title","titulo")
                .add("isbn","123456")
                .build();

        //Como construye JSONB
        var book1 = Book.builder()
                .title("libro")
                .isbn("123456")
                .build();
*/
        //res.send(books);
    }

    static void main() {
        Config config = Config.create();

        var configHttp = config.get("server");
        var configDb = config.get("db");

        dbClient = DbClient.builder()
                .config(configDb)
                .build();

        WebServer.builder()
                //.port(8080)
                .config(configHttp)
                .mediaContext(ctx->ctx.addMediaSupport(JsonbSupport.create()))
                .routing(it->it.get("/books",Web03Main::handleBooks))
                .build()
                .start();

    }
}
