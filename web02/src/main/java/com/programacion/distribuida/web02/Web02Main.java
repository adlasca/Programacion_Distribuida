package com.programacion.distribuida.web02;

import jakarta.ws.rs.SeBootstrap;

import java.net.URI;

public class Web02Main {
    public static void main(String[] args)throws Exception {
        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .host("0.0.0.0")
                .port(8081)
                .protocol("http")
                .build();

        SeBootstrap.start(MiAppRest.class,config)
                .thenAccept(instance -> {
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();
                    System.out.println("Iniciado en:"+uri);
                }).exceptionally(t -> {
                    t.printStackTrace();
                    return null;
                });

        Thread.currentThread().join();
    }
}
